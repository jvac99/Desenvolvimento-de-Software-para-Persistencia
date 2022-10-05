package com.ufc.qxd;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.ufc.qxd.model.Favoritos;
import com.ufc.qxd.model.MeusFavoritos;

public class Questao03ConverterOpenCsv {
    public static void main(String[] args)
            throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        String origem;
        String destino;
        File file;
        File file2;
        File file3;
        ObjectMapper om;
        Favoritos object;
        XmlMapper xm;
        Writer writer;
        StatefulBeanToCsv<MeusFavoritos> statefulBeanToCsv;

        // Recebendo origem
        origem = args[0];

        file = new File(origem);
        destino = file.getName();
        destino = destino.substring(0, destino.lastIndexOf('.'));
        file2 = new File(destino + ".xml");
        file3 = new File(destino + ".csv");
        om = new ObjectMapper();

        try {
            object = om.readValue(file, Favoritos.class);

            xm = new XmlMapper();
            xm.enable(SerializationFeature.INDENT_OUTPUT);
            xm.writeValue(file2, object);

            // CSV

            writer = new FileWriter(file3);
            statefulBeanToCsv = new StatefulBeanToCsvBuilder<MeusFavoritos>(writer)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .build();

            for (MeusFavoritos mf : object.getMeusFavoritosList()) {
                statefulBeanToCsv.write(mf);
            }

            writer.close();
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        }
    }
}
