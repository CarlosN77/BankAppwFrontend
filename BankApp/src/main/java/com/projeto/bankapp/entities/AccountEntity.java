package com.projeto.bankapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountEntity {

    @Id
    @Column(name = "numerodeconta", nullable = false)
    private Integer numerodeconta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_nif", nullable = false)
    private ClientEntity cliente;

    @Column(nullable = false)
    private double saldo;

    public void setClient(ClientEntity client) {
        this.cliente = client;
    }


}