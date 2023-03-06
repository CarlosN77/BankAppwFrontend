package com.projeto.bankapp.services;

import com.projeto.bankapp.repositories.ClientRepository;
import com.projeto.bankapp.entities.ClientEntity;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.time.LocalDate;

@Service
@Transactional
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Clientservice {

    @Autowired
    private ClientRepository clientRepository;




    public void criarNovoCliente(int nif, String primeironome,String segundonome, String password,
                                 String datanascimento, int telefone, int telemovel, String email, String profissao) {

        ClientEntity client = new ClientEntity();

        client.setNif(nif);
        client.setPrimeironome(primeironome);
        client.setSegundonome(segundonome);
        client.setDatanascimento(datanascimento);
        client.setSegundonome(segundonome);
        client.setPassword(password);
        client.setEmail(email);
        client.setProfissao(profissao);
        client.setTelemovel(telemovel);
        client.setTelefone(telefone);
        clientRepository.save(client);
    }

    public ClientEntity login(Integer nif, String password) throws AuthenticationException {
         return clientRepository.findByNifAndPassword(nif, password);


    }

}



