package com.projeto.bankapp.models;


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
    private ClientDTO titularprincipal;
    private ClientDTO titularsecundario;
    public double saldo;
}
