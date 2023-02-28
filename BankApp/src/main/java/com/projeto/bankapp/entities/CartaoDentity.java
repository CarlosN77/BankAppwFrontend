package com.projeto.bankapp.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "cartaodebito")
public class CartaoDentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_de_cartao", nullable = false)
    private int numerodecartao;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "cliente_id")
//    private Cliententity cliente;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "conta_id")
//    private Contaentity conta;

    @Column(name = "pin")
    private int pin;

    @Column(name = "tipo")
    private String tipo;

}
