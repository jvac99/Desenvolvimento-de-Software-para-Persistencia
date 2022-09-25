package com.ufc.qxd.model;

import java.util.List;

public class Filmes {

    private List<Filme> listFilmes;

    public Filmes() {
    }

    public Filmes(List<Filme> listFilmes) {
        this.listFilmes = listFilmes;
    }

    public List<Filme> getListFilmes() {
        return listFilmes;
    }

    public void setListFilmes(List<Filme> listFilmes) {
        this.listFilmes = listFilmes;
    }

    @Override
    public String toString() {
        return this.listFilmes.toString();
    }

}
