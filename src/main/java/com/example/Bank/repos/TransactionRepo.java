package com.example.Bank.repos;

import com.example.Bank.domain.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepo extends CrudRepository<Transaction, Integer> {
    @Query(value = "select * FROM transaction where getter_acc = :id OR sender_acc = :id", nativeQuery = true)
    List<Transaction> findByFilter(@Param("id") int id);

}
