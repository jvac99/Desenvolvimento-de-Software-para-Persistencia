package com.ufc.qxd;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.ufc.qxd.model.Filme;
import com.ufc.qxd.model.Filmes;

public class Desserializa {
    public static void main(String[] args) {
        File file = new File("filmes.xml");
        XmlMapper xmlMapper = new XmlMapper();
        Filmes filmes;
        try {
            filmes = xmlMapper.readValue(file, Filmes.class);

            for (Filme filme : filmes.getListFilmes()) {
                System.out.println(filme);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
