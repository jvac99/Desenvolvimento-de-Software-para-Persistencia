package com.ufc.qxd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Serie {
    private int id;
    private String titulo;
    private int lancamento;
    private String genero;
    private int numDeTemporadas;
    private int favTemporada;
}
