package com.ufc.qxd;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ufc.qxd.model.Favoritos;
import com.ufc.qxd.model.MeusFavoritos;
import com.ufc.qxd.model.Filme;
import com.ufc.qxd.model.Livro;
import com.ufc.qxd.model.Musica;
import com.ufc.qxd.model.Serie;

public class Questao02Json {
    public static void main(String[] args) {
        int idMF = 0;
        int key;
        int condition;
        int id;
        int numDeTemporadas;
        int favTemporada;
        int numPaginas;
        int lancamento;
        String nomeMF;
        String titulo;
        String genero;
        String criador;
        float duracao;
        List<Filme> filmes;
        List<Musica> musicas;
        List<Livro> livros;
        List<Serie> series;
        Favoritos favoritos;
        File file = null;
        ObjectMapper om = null;
        InputStream is = System.in;
        Scanner scanner = new Scanner(is);
        List<MeusFavoritos> favoritosList = new ArrayList<MeusFavoritos>();

        do {
            System.out.println("----------------------------------");
            System.out.println("Sistema favoritos");
            System.out.println("----------------------------------");
            System.out.println("Digite o nome da pessoa: ");
            nomeMF = scanner.nextLine();
            idMF++;
            filmes = new ArrayList<Filme>();
            musicas = new ArrayList<Musica>();
            livros = new ArrayList<Livro>();
            series = new ArrayList<Serie>();

            do {
                System.out.println("----------------------------------");
                System.out.println("0 para sair");
                System.out.println("1 para filme");
                System.out.println("2 para musica");
                System.out.println("3 para livro");
                System.out.println("4 para serie");
                System.out.println("----------------------------------");
                System.out.println("Digite qual você deseja adicionar: ");
                key = Integer.parseInt(scanner.nextLine());

                switch (key) {
                    case 0:
                        break;
                    case 1:
                        System.out.println("Digite o título: ");
                        titulo = scanner.nextLine();
                        System.out.println("Digite o diretor: ");
                        criador = scanner.nextLine();
                        System.out.println("Digite o ano de lançamento: ");
                        lancamento = Integer.parseInt(scanner.nextLine());
                        System.out.println("Digite o genero: ");
                        genero = scanner.nextLine();
                        System.out.println("Digite a duracao: ");
                        duracao = Float.parseFloat(scanner.nextLine());
                        id = filmes.size() + 1;
                        filmes.add(new Filme(id, titulo, lancamento, criador, genero, duracao));
                        break;
                    case 2:
                        System.out.println("Digite o título: ");
                        titulo = scanner.nextLine();
                        System.out.println("Digite o autor: ");
                        criador = scanner.nextLine();
                        System.out.println("Digite o ano de lançamento: ");
                        lancamento = Integer.parseInt(scanner.nextLine());
                        System.out.println("Digite o genero: ");
                        genero = scanner.nextLine();
                        System.out.println("Digite a duração: ");
                        duracao = Float.parseFloat(scanner.nextLine());
                        id = musicas.size() + 1;
                        musicas.add(new Musica(id, titulo, lancamento, criador, genero, duracao));
                        break;
                    case 3:
                        System.out.println("Digite o título: ");
                        titulo = scanner.nextLine();
                        System.out.println("Digite o autor: ");
                        criador = scanner.nextLine();
                        System.out.println("Digite o ano de lançamento: ");
                        lancamento = Integer.parseInt(scanner.nextLine());
                        System.out.println("Digite o genero: ");
                        genero = scanner.nextLine();
                        System.out.println("Digite o número de páginas: ");
                        numPaginas = Integer.parseInt(scanner.nextLine());
                        id = livros.size() + 1;
                        livros.add(new Livro(id, titulo, lancamento, criador, genero, numPaginas));
                        break;
                    case 4:
                        System.out.println("Digite o título: ");
                        titulo = scanner.nextLine();
                        System.out.println("Digite o ano de lançamento: ");
                        lancamento = Integer.parseInt(scanner.nextLine());
                        System.out.println("Digite o genero: ");
                        genero = scanner.nextLine();
                        System.out.println("Digite o número de temporadas: ");
                        numDeTemporadas = Integer.parseInt(scanner.nextLine());
                        System.out.println("Digite o numero da sua temporada favorita: ");
                        favTemporada = Integer.parseInt(scanner.nextLine());
                        id = series.size() + 1;
                        series.add(new Serie(id, titulo, lancamento, genero, numDeTemporadas, favTemporada));
                        break;
                    default:
                        System.out.println("Error: número inválido!");
                        break;
                }
            } while (key != 0);
            MeusFavoritos meusfavoritos = new MeusFavoritos(idMF, nomeMF, filmes, musicas, livros, series);
            favoritosList.add(meusfavoritos);
            System.out.println("Deseja adicionar outro favoritos? (Digite 1 para continuar e 0 para sair)");
            condition = Integer.parseInt(scanner.nextLine());
        } while (condition != 0);

        favoritos = new Favoritos(favoritosList);
        file = new File("favoritos.json");
        om = new ObjectMapper();
        om.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            // Método que pode ser usado para serializar qualquer valor Java, tem como saída
            // JSON, gravada no arquivo fornecido.
            om.writeValue(file, favoritos);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}