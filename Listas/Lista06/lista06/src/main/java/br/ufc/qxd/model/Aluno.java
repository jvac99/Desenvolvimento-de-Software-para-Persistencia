package br.ufc.qxd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String matricula;
}
