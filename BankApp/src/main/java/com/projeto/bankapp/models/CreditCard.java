package com.projeto.bankapp.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CreditCard extends Cartao {

    private double limite;

    public CreditCard(ClientDTO clientDTO, Conta conta, int numerodecartao, double limite) {
        super(clientDTO, conta, numerodecartao);
        this.limite = limite;
    }

    }

