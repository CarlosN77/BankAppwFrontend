package com.projeto.bankapp;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class Clientservice {
    private final ClientRepository clientRepository;

    public Clientservice(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void criarNovoCliente(int nif, String primeironome,String segundonome, String password,
                                 LocalDate dataNascimento, int telefone, int telemovel, String email, String profissao) {
        System.out.println("Received request to create new client: " + primeironome + " " + segundonome);
        Cliententity client = new Cliententity();

        client.setNif(nif);
        client.setPrimeironome(primeironome);
        client.setPassword(password);
        client.setDatanascimento(dataNascimento);
        client.setSegundonome(segundonome);
        client.setEmail(email);
        client.setProfissao(profissao);
        client.setTelemovel(telemovel);
        client.setTelefone(telefone);
        clientRepository.save(client);
    }
}

