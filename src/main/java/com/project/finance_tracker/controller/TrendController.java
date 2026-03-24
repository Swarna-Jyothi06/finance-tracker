package com.project.finance_tracker.controller;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.finance_tracker.entity.Transaction;
import com.project.finance_tracker.repository.TransactionRepository;

@RestController
@RequestMapping("/trends")
@CrossOrigin
public class TrendController {

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/summary")
    public Map<String, Double> getSummary() {
        List<Transaction> transactions = transactionRepository.findAll();

        double totalIncome = 0;
        double totalExpense = 0;

        for (Transaction t : transactions) {
            if (t.getType() != null && t.getType().equalsIgnoreCase("Income")) {
                totalIncome += t.getAmount();
            } else if (t.getType() != null && t.getType().equalsIgnoreCase("Expense")) {
                totalExpense += t.getAmount();
            }
        }

        Map<String, Double> result = new HashMap<>();
        result.put("totalIncome", totalIncome);
        result.put("totalExpense", totalExpense);
        result.put("balance", totalIncome - totalExpense);

        return result;
    }

    @GetMapping("/category")
    public Map<String, Double> getCategoryWiseExpense() {
        List<Transaction> transactions = transactionRepository.findAll();

        Map<String, Double> categoryTotals = new LinkedHashMap<>();

        for (Transaction t : transactions) {
            if (t.getType() != null && t.getType().equalsIgnoreCase("Expense")) {
                String category = t.getCategory() == null ? "Other" : t.getCategory();
                categoryTotals.put(category, categoryTotals.getOrDefault(category, 0.0) + t.getAmount());
            }
        }

        return categoryTotals;
    }

    @GetMapping("/monthly-expense")
    public Map<String, Double> getMonthlyExpense() {
        List<Transaction> transactions = transactionRepository.findAll();

        Map<Integer, Double> monthMap = new TreeMap<>();

        for (Transaction t : transactions) {
            if (t.getDate() != null && t.getType() != null && t.getType().equalsIgnoreCase("Expense")) {
                int month = t.getDate().getMonthValue();
                monthMap.put(month, monthMap.getOrDefault(month, 0.0) + t.getAmount());
            }
        }

        Map<String, Double> result = new LinkedHashMap<>();
        for (Map.Entry<Integer, Double> entry : monthMap.entrySet()) {
            String monthName = Month.of(entry.getKey()).getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
            result.put(monthName, entry.getValue());
        }

        return result;
    }

    @GetMapping("/income-expense")
    public Map<String, Object> getIncomeVsExpense() {
        List<Transaction> transactions = transactionRepository.findAll();

        double totalIncome = 0;
        double totalExpense = 0;

        for (Transaction t : transactions) {
            if (t.getType() != null && t.getType().equalsIgnoreCase("Income")) {
                totalIncome += t.getAmount();
            } else if (t.getType() != null && t.getType().equalsIgnoreCase("Expense")) {
                totalExpense += t.getAmount();
            }
        }

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("labels", Arrays.asList("Income", "Expense"));
        result.put("values", Arrays.asList(totalIncome, totalExpense));

        return result;
    }
}
