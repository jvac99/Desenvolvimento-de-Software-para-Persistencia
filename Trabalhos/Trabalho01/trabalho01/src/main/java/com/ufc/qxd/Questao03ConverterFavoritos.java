package com.ufc.qxd;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
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

public class Questao03ConverterFavoritos {
    public static void main(String[] args) {
        String origem;
        String destino;
        File file;
        File file2;
        ObjectMapper om;
        Favoritos favoritos;
        XmlMapper xm;
        Writer writer;
        StatefulBeanToCsv<MeusFavoritos> statefulBeanToCsv;

        // Recebendo origem
        origem = args[0];

        file = new File(origem);
        destino = file.getName();
        destino = destino.substring(0, destino.lastIndexOf('.'));
        file2 = new File(destino + ".xml");
        om = new ObjectMapper();

        try {
            favoritos = om.readValue(file, Favoritos.class);

            xm = new XmlMapper();
            xm.enable(SerializationFeature.INDENT_OUTPUT);
            xm.writeValue(file2, favoritos);

            // CSV
            writer = Files.newBufferedWriter(Paths.get(destino + ".csv"));
            statefulBeanToCsv = new StatefulBeanToCsvBuilder<MeusFavoritos>(writer)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .build();

            statefulBeanToCsv.write(favoritos.getMeusFavoritosList());

            writer.close();
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        }
    }
}
