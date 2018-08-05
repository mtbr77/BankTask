package com.example.Bank;

import com.example.Bank.domain.Account;
import com.example.Bank.domain.Transaction;
import com.example.Bank.repos.AccountRepo;
import com.example.Bank.repos.ClientRepo;
import com.example.Bank.repos.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Controller
public class TransactionsController {
    @Autowired
    AccountRepo accountRepository;
    @Autowired
    ClientRepo clientRepository;
    @Autowired
    TransactionRepo transactionRepository;

    @GetMapping("/transactions")
    public String transactions(Map<String, Object> model) {
        Iterable<Transaction> transactions = transactionRepository.findAll();

        model.put("transactions", transactions);

        return "transactions";
    }

    @PostMapping("/transactions")
    public String add(@RequestParam int senderAcc, @RequestParam int getterAcc, @RequestParam double amount, Map<String, Object> model) {
        Transaction transaction = new Transaction(senderAcc,getterAcc,amount);
        Optional<Account> account = accountRepository.findById(senderAcc);
        Optional<Account> targetAccount = accountRepository.findById(getterAcc);
        if (!account.isPresent() || !targetAccount.isPresent()) {
            return "transactions";
        }

        //Client client = clientRepository.findById(account.get().getClient()).get();
        double balance = account.get().getSum();
        double targetBalance = targetAccount.get().getSum();

        /*if (balance < transaction.getAmount() || clientId != account.get().getClient()) {
            return "transactions";
        }*/

        account.get().setSum(balance - amount);
        targetAccount.get().setSum(targetBalance + transaction.getAmount());
        accountRepository.save(account.get());
        accountRepository.save(targetAccount.get());

        transaction.setTime(new Timestamp(new Date().getTime()));
        transactionRepository.save(transaction);
        Iterable<Transaction> transactions = transactionRepository.findAll();
        model.put("transactions", transactions);
        return "transactions";
    }

    @PostMapping("filter")
    public String filter(@RequestParam int filter, Map<String, Object> model) {
        Iterable<Transaction> transactions = null;

        if (filter != 0) {
            transactions = transactionRepository.findByFilter(filter);
        } else {
            transactions = transactionRepository.findAll();
        }

        model.put("transactions", transactions);

        return "transactions";
    }
}
