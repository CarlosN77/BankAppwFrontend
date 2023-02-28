package com.projeto.bankapp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "Clients")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Cliententity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer nif;

    @Column(nullable = false, columnDefinition = "varchar(255) default null comment 'PrimeiroNome'")
    private String primeironome;

    @Column(nullable = false, columnDefinition = "varchar(255) default null comment 'SegundoNome'")
    private String segundonome;

    @Column(nullable = false, columnDefinition = "varchar(255) default null comment 'Password'")
    private String password;

    @Column(nullable = false, columnDefinition = "date default null comment 'DataDeNascimento'")
    private LocalDate datadenascimento;

    @Column(nullable = false, unique = true, columnDefinition = "varchar(255) default null comment 'Email'")
    private String email;

    @Column(nullable = false, columnDefinition = "int default null comment 'Telemovel'")
    private Integer telemovel;

    @Column(nullable = false, columnDefinition = "int default null comment 'Telefone'")
    private Integer telefone;

    @Column(nullable = false, columnDefinition = "varchar(255) default null comment 'Profissao'")
    private String profissao;
}