package com.projeto.bankapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
public class Clientcontroller {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    Clientservice clientservice;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(yyyy-mm-dd);
    @Autowired
    public Clientcontroller(Clientservice clientservice){
        this.clientservice = clientservice;
    }

    @RequestMapping("/register")
    public ModelAndView registerForm() {
        ModelAndView modelAndView = new ModelAndView("register");
        return modelAndView;
    }

    @PostMapping("/criarNovoCliente")
    public ModelAndView criarNovoCliente(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dataNascimento,
            @RequestParam String segundonome,
            @RequestParam int telefone,
            @RequestParam String email,
            @RequestParam String primeironome,
            @RequestParam int nif,
            @RequestParam String profissao,
            @RequestParam String password,
            @RequestParam int telemovel) {

        clientservice.criarNovoCliente(nif, primeironome, password, segundonome, dataNascimento, telefone, telemovel, email,
                profissao);
        return registerForm();
    }

    @GetMapping
    public List<Cliententity> getAllClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliententity> getClientById(@PathVariable Integer id) {
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
    public ResponseEntity<Void> deleteClient(@PathVariable Integer id) {
        if (!clientRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        clientRepository.deleteById(Integer.valueOf(id));
        return ResponseEntity.noContent().build();
    }

}