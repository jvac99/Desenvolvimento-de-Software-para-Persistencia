package com.ufc.qxd.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MeusFavoritos {
    private int id;
    private String nome;
    List<Filme> filmes;
    List<Musica> musicas;
    List<Livro> livros;
    List<Serie> series;
}
