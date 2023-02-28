package com.projeto.bankapp.controllers;

import com.projeto.bankapp.entities.Cliententity;
import com.projeto.bankapp.mappers.ClientMapper;
import com.projeto.bankapp.models.ClientDTO;
import com.projeto.bankapp.repositories.ClientRepository;
import com.projeto.bankapp.services.Clientservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class Clientcontroller {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    Clientservice clientservice;

    @Autowired
    public Clientcontroller(Clientservice clientservice){
        this.clientservice = clientservice;
    }





    @GetMapping
    public List<Cliententity> getAllClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliententity> getClientById(@PathVariable int id) {
        Cliententity client = clientRepository.findById(Long.valueOf(id)).orElse(null);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliententity createClient(@RequestBody Cliententity client) {
        return clientRepository.save(client);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        if (!clientRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        clientRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping("/register")
    public RedirectView registerForm() {
        return new RedirectView("/register.html");
    }

//    @PostMapping("/register")
//    public RedirectView criarNovoCliente(
//            @RequestParam int nif,
//            @RequestParam LocalDate dataNascimento,
//            @RequestParam int telefone,
//            @RequestParam String email,
//            @RequestParam String primeironome,
//            @RequestParam String segundonome,
//            @RequestParam String profissao,
//            @RequestParam String password,
//            @RequestParam int telemovel) {
//
//        clientservice.criarNovoCliente(nif, primeironome,segundonome, password, dataNascimento, telefone, telemovel, email,
//                profissao);
//        return registerForm();
//    }


    @PostMapping(path = "/createClient")
    public RedirectView createClient(@RequestBody ClientDTO clientDTO) {
        clientservice.createClient(clientDTO);
        return registerForm();
    }

//    @RequestMapping("/login")
//    public RedirectView rForm() {
//        return new RedirectView("/register.html");
//    }

    @RequestMapping ("/login")
    public RedirectView login() {
        return new RedirectView("/login.html");
//        try {
//            Cliententity client = clientservice.login(nif, password);
//            return ResponseEntity.ok(client);
//        } catch (AuthenticationException e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
//        }
    }


}