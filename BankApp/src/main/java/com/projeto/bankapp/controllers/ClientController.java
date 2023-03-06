package com.projeto.bankapp.controllers;

import com.projeto.bankapp.entities.ClientEntity;
import com.projeto.bankapp.repositories.ClientRepository;
import com.projeto.bankapp.services.Clientservice;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.AuthenticationException;
import java.util.List;

@Controller
public class ClientController {

    private final ClientRepository clientRepository;
    private final Clientservice clientservice;


    @Autowired
    public ClientController(ClientRepository clientRepository, Clientservice clientservice){
        this.clientRepository = clientRepository;
        this.clientservice = clientservice;
    }


    @RequestMapping("/register")
    public ModelAndView registerForm() {
        ModelAndView modelAndView = new ModelAndView("register");
        return modelAndView;
    }

    @RequestMapping("/afterlogin")
    public ModelAndView afterregisterForm() {
        ModelAndView modelAndView = new ModelAndView("afterlogin");
        return modelAndView;
    }

    @PostMapping("/criarNovoCliente")
    public ModelAndView criarNovoCliente(
            @RequestParam String datanascimento,
            @RequestParam String segundonome,
            @RequestParam int telefone,
            @RequestParam String email,
            @RequestParam String primeironome,
            @RequestParam int nif,
            @RequestParam String profissao,
            @RequestParam String password,
            @RequestParam int telemovel) {

        clientservice.criarNovoCliente(nif, primeironome, segundonome,password , datanascimento, telefone, telemovel, email,
                profissao);
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public String login(
            @RequestParam Integer nif,
            @RequestParam String password,
            HttpSession session, Model model) throws AuthenticationException {
        ClientEntity cliente = clientservice.login(nif, password);
        if (cliente == null) {
            throw new AuthenticationException("Invalid login credentials");
        }
        else {
            System.out.println("Cliente logged in: " + cliente);
            session.setAttribute("cliente", cliente);
            model.addAttribute("cliente", cliente);
            return "redirect:/afterlogin";
        }
    }


    @GetMapping("/afterlogin")
    public String showafterlogin(Model model, HttpSession session) {
        ClientEntity cliente = (ClientEntity) session.getAttribute("cliente");
        System.out.println("Cliente from session: " + cliente); // add this line
            model.addAttribute("cliente", cliente);
            return "afterlogin";
        }






    @RequestMapping ("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @GetMapping
    public List<ClientEntity> getAllClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientEntity> getClientById(@PathVariable Long id) {
        ClientEntity client = clientRepository.findById(String.valueOf(id)).orElse(null);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientEntity createClient(@RequestBody ClientEntity client) {
        return clientRepository.save(client);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        if (!clientRepository.existsById(String.valueOf(id))) {
            return ResponseEntity.notFound().build();
        }
        clientRepository.deleteById(String.valueOf(id));
        return ResponseEntity.noContent().build();
    }

}