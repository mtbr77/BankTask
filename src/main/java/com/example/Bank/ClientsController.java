package com.example.Bank;

import com.example.Bank.domain.Client;
import com.example.Bank.repos.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ClientsController {
    @Autowired
    private ClientRepo clientRepo;


    @GetMapping("/clients")
    public String clients(Map<String, Object> model) {
        Iterable<Client> clients = clientRepo.findAll();

        model.put("clients", clients);

        return "clients";
    }

    @PostMapping("/clients")
    public String add(@RequestParam String name, @RequestParam String address, @RequestParam int age, Map<String, Object> model) {
        Client client = new Client(name, address, age);

        clientRepo.save(client);

        Iterable<Client> clients = clientRepo.findAll();

        model.put("clients", clients);

        return "clients";
    }


}
