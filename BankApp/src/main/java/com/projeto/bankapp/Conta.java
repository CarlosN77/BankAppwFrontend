package com.projeto.bankapp;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Conta {

    public int numerodeconta;
    private Cliente titularprincipal;
    private Cliente titularsecundario;
    public double saldo;
}
