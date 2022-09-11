package com.ufc.qxd;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import com.ufc.qxd.model.Filme;
import com.ufc.qxd.model.Filmes;

public class Serializa {
    public static void main(String[] args) {
        List<Filme> listFilmes = new ArrayList<Filme>();
        String condition = "nao";
        Scanner scanner = new Scanner(System.in);
        int id = 0;
        String titulo;
        String sinopse;
        String diretor;

        do {
            id++;
            System.out.println("Digite o titulo: ");
            titulo = scanner.nextLine();
            System.out.println("Digite a sinopse: ");
            sinopse = scanner.nextLine();
            System.out.println("Digite o diretor: ");
            diretor = scanner.nextLine();
            listFilmes.add(new Filme(id, titulo, sinopse, diretor));
            System.out.println("Deseja adicionar outro filme? (Digite sim para continuar e nao para sair)");
            condition = scanner.nextLine();
        } while (condition.equals("sim"));

        Filmes filmes = new Filmes(listFilmes);
        File file = new File("filmes.xml");

        XmlMapper xm = new XmlMapper();
        xm.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            xm.writeValue(file, filmes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
