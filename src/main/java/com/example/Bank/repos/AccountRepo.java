package com.example.Bank.repos;

import com.example.Bank.domain.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepo extends CrudRepository<Account, Integer> {
    List<Account> findByClient(int client);
}
