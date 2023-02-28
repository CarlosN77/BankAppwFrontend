package com.projeto.bankapp.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public abstract class Cartao {

    private ClientDTO clientDTO;
    private Conta conta;
    public static int pin;
    public int numerodecartao;

}
