package com.projeto.bankapp;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class Clientservice {
    private final ClientRepository clientRepository;

    public Clientservice(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void criarNovoCliente(int nif, String primeironome,String Segundonome, String senha,
                                        LocalDate dataNascimento, int telefone, int telemovel, String email, String profissao) {
        Cliententity client = new Cliententity();

        client.setNif(266150004);
        client.setPrimeironome("Carlos");
        client.setPassword("1234");
        client.setDatadenascimento(LocalDate.of(2000, 10, 12));
        client.setSegundonome("Neves");
        client.setEmail("aa");
        client.setProfissao("aa");
        client.setTelemovel(912);
        client.setTelefone(978);
        clientRepository.save(client);

    }
}

