package com.project.finance_tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.finance_tracker.entity.Transaction;
import com.project.finance_tracker.repository.TransactionRepository;

@Service
public class ExportService {

    @Autowired
    private TransactionRepository transactionRepository;

    public String generateCsvForUser(Long userId) {
        List<Transaction> transactions = transactionRepository.findByUserId(userId);

        StringBuilder csv = new StringBuilder();
        csv.append("Transaction ID,User ID,Type,Date,Category,Account,Description,Amount\n");

        for (Transaction t : transactions) {
            csv.append(t.getId()).append(",")
               .append(t.getUserId()).append(",")
               .append(t.getType()).append(",")
               .append(t.getDate()).append(",")
               .append(t.getCategory()).append(",")
               .append(t.getAccount()).append(",")
               .append(t.getDescription()).append(",")
               .append(t.getAmount()).append("\n");
        }

        return csv.toString();
    }
}
