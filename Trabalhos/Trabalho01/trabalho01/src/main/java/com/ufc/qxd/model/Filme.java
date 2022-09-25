package com.ufc.qxd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Filme {
    private int id;
    private String titulo;
    private int lancamento;
    private String diretor;
    private String genero;
    private float duracao;
}
