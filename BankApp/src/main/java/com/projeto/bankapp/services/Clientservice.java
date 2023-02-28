package com.projeto.bankapp.services;

import com.projeto.bankapp.mappers.ClientMapper;
import com.projeto.bankapp.models.ClientDTO;
import com.projeto.bankapp.repositories.ClientRepository;
import com.projeto.bankapp.entities.Cliententity;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.naming.AuthenticationException;
import java.rmi.ServerException;

@Service
@Transactional
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Clientservice {

    @Autowired
    private ClientRepository clientRepository;

    private Cliententity client;


    public void createClient(ClientDTO client) {
        Cliententity newClient = new Cliententity();
        ClientMapper.INSTANCE.createClient(newClient, client);
        clientRepository.save(newClient);
    }



    public Cliententity login(Integer nif, String password) throws AuthenticationException {
        Cliententity cliente = clientRepository.findByNifAndPassword(nif, password);
        if (client == null) {
            throw new AuthenticationException("Invalid login credentials");
        }
        return client;
    }

}



