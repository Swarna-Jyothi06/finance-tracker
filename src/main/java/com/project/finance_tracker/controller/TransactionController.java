package com.project.finance_tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.finance_tracker.entity.Transaction;
import com.project.finance_tracker.repository.TransactionRepository;

@RestController
@RequestMapping("/transactions")
@CrossOrigin
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @PostMapping("/add")
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @GetMapping("/all")
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @GetMapping("/user/{userId}")
    public List<Transaction> getTransactionsByUser(@PathVariable Long userId) {
        return transactionRepository.findByUserId(userId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTransaction(@PathVariable Long id) {
        transactionRepository.deleteById(id);
        return "Transaction Deleted Successfully";
    }
}