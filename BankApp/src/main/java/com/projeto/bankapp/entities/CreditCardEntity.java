package com.projeto.bankapp.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;


@Entity
@Table(name = "cartaocredito")
public class CreditCardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_de_cartao", nullable = false)
    private int numerodecartaoe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private ClientEntity cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conta_id")
    private AccountEntity conta;

    @Column(name = "pin")
    private int pin;

    @Column(name = "limite")
    private double limite;

}
