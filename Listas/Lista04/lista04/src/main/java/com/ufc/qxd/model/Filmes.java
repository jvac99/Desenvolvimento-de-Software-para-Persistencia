package com.ufc.qxd.model;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Netflix")
public class Filmes {

    @JacksonXmlElementWrapper(localName = "filmes")
    @JacksonXmlProperty(localName = "filme")
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
