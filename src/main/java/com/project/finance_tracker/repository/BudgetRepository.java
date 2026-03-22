package com.project.finance_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.finance_tracker.entity.Budget;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
}