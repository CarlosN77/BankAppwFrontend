package com.projeto.bankapp;

import jakarta.persistence.*;

@Entity
@Table(name = "contas")
public class Contaentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", insertable=false, updatable=false)
    private Cliententity titularprincipal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = true)
    private Cliententity titularsecundario;

    @Column(name = "numero_de_conta", nullable = false)
    private int numerodeconta;

    @Column(nullable = false)
    private double saldo;

    // getters and setters
}