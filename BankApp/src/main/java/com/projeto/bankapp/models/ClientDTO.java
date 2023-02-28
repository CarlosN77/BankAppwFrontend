package com.projeto.bankapp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ClientDTO {

    private Integer nif;
    private String senha;
    private String primeironome;
    private String segundonome;
    private Conta conta;
    private LocalDate datadenascimento;
    private Integer telefone;
    private Integer telemovel;
    private String email;
    private String profissao;
}
