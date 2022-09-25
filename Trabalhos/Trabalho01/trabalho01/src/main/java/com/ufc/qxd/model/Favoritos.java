package com.ufc.qxd.model;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JacksonXmlRootElement(localName = "Favoritos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Favoritos {
    @JacksonXmlElementWrapper(localName = "meusFavoritosList")
    @JacksonXmlProperty(localName = "meusFavoritos")
    private List<MeusFavoritos> meusFavoritosList;
}
