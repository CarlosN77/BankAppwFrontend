package com.projeto.bankapp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Cliente {

    private int nif;
    private String senha;
    private String primeironome;
    private String segundonome;
    private Conta conta;
    private LocalDate datadenascimento;
    private int telefone;
    private int telemovel;
    private String email;
    private String profissao;
}
