package com.ufc.qxd;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Questao03ConverterJackson {
    public static void main(String[] args) {
        String origem = null;
        String destino = null;
        File file = null;
        File file2 = null;
        File file3 = null;
        ObjectMapper om = null;
        Object Object;
        XmlMapper xm = null;
        JsonNode jsonTree = null;
        Builder csvSchemaBuilder;
        JsonNode jsonNode;
        CsvMapper csvMapper = null;
        CsvSchema csvSchema = null;

        // Recebendo origem
        origem = args[0];

        file = new File(origem);
        destino = file.getName();
        destino = destino.substring(0, destino.lastIndexOf('.'));
        file2 = new File(destino + ".xml");
        om = new ObjectMapper();
        file3 = new File(destino + ".csv");

        try {
            Object = om.readValue(file, Object.class);

            // XML
            xm = new XmlMapper();
            xm.enable(SerializationFeature.INDENT_OUTPUT);
            xm.writeValue(file2, Object);

            // CSV
            jsonTree = new ObjectMapper().readTree(file);

            csvSchemaBuilder = CsvSchema.builder();
            jsonNode = jsonTree.elements().next().elements().next();
            jsonNode.fieldNames().forEachRemaining(fieldName -> {
                csvSchemaBuilder.addColumn(fieldName);
            });

            csvSchema = csvSchemaBuilder.build().withHeader();
            csvMapper = new CsvMapper();
            csvMapper.writerFor(JsonNode.class)
                    .with(csvSchema)
                    .writeValue(file3, jsonTree.elements().next());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
