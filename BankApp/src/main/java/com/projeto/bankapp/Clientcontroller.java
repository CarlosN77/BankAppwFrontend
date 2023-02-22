package com.projeto.bankapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    public void criarCliente( ) {
        clientservice.criarNovoCliente(266, "Carlos", "123","123",LocalDate.of(2004, 10, 12), 1234,1234,"a","a");
    }

    @GetMapping
    public List<Cliententity> getAllClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliententity> getClientById(@PathVariable Long id) {
        Cliententity client = clientRepository.findById(id).orElse(null);
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

}