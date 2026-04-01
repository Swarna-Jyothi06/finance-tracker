package com.project.finance_tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.finance_tracker.entity.Budget;
import com.project.finance_tracker.repository.BudgetRepository;

@RestController
@RequestMapping("/budget")
@CrossOrigin
public class BudgetController {

    @Autowired
    private BudgetRepository budgetRepository;

    @PostMapping("/save")
    public Budget saveBudget(@RequestBody Budget budget) {

        double totalBudget =
                budget.getFoodBudget() +
                budget.getTransportBudget() +
                budget.getShoppingBudget() +
                budget.getBillsBudget();

        double totalSpent =
                budget.getFoodSpent() +
                budget.getTransportSpent() +
                budget.getShoppingSpent() +
                budget.getBillsSpent();

        budget.setFoodRemaining(budget.getFoodBudget() - budget.getFoodSpent());
        budget.setTransportRemaining(budget.getTransportBudget() - budget.getTransportSpent());
        budget.setShoppingRemaining(budget.getShoppingBudget() - budget.getShoppingSpent());
        budget.setBillsRemaining(budget.getBillsBudget() - budget.getBillsSpent());

        budget.setTotalBudget(totalBudget);
        budget.setTotalSpent(totalSpent);
        budget.setTotalRemaining(totalBudget - totalSpent);

        return budgetRepository.save(budget);
    }

    @GetMapping("/all")
    public List<Budget> getAllBudgets() {
        return budgetRepository.findAll();
    }

    @GetMapping("/latest")
    public Budget getLatestBudget() {
        List<Budget> budgets = budgetRepository.findAll();
        if (budgets.isEmpty()) {
            return null;
        }
        return budgets.get(budgets.size() - 1);
    }
}