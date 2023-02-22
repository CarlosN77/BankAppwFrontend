package com.projeto.bankapp;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "clients")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Cliententity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int nif;

    @Column(nullable = false)
    private String primeironome;

    @Column(nullable = false)
    private String segundonome;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Contaentity conta;


    @Column(nullable = false)
    private int telefone;

    @Column(nullable = false)
    private int telemovel;

    @Column(nullable = false)
    private LocalDate datadenascimento;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String profissao;

    @Column(nullable = false)
    private String password;

    @Override
    public String toString() {
        return "ClientEntity{" +
                ", name='" + primeironome + segundonome + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }





}

