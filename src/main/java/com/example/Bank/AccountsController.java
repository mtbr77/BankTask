package com.example.Bank;

import com.example.Bank.domain.Account;
import com.example.Bank.domain.Client;
import com.example.Bank.repos.AccountRepo;
import com.example.Bank.repos.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class AccountsController {
    @Autowired
    private AccountRepo accountsRepo;
    @Autowired
    private ClientRepo clientsRepo;


    /*@GetMapping("/accounts")
    public String accounts(Map<String, Object> model) {
        Iterable<Account> accounts = accountsRepo.findAll();

        model.put("accounts", accounts);

        return "accounts";
    }*/

    @GetMapping("/clients/{id}/accounts")
    public String getClientAccounts(@PathVariable("id") int id, Map<String, Object> model) {
        Iterable<Account> accounts = accountsRepo.findByClient(id);
        Client client = clientsRepo.findById(id).get();
        model.put("accounts", accounts);
        model.put("client", client);
        return "accounts";
    }

    @PostMapping("/addAcc")
    public String add(@RequestParam int id, @RequestParam double sum, Map<String, Object> model) {
        Account account = new Account(id, sum);
        accountsRepo.save(account);
        return "redirect:/clients/"+id+"/accounts";
    }


}
