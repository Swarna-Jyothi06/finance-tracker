package com.project.finance_tracker.entity;

import jakarta.persistence.*;

@Entity
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double foodBudget;
    private double transportBudget;
    private double shoppingBudget;
    private double billsBudget;

    private double foodSpent;
    private double transportSpent;
    private double shoppingSpent;
    private double billsSpent;

    private double savingsGoal;

    private double totalBudget;
    private double totalSpent;
    private double totalRemaining;

    private double foodRemaining;
    private double transportRemaining;
    private double shoppingRemaining;
    private double billsRemaining;

    public Budget() {
    }

    public Long getId() {
        return id;
    }

    public double getFoodBudget() {
        return foodBudget;
    }

    public void setFoodBudget(double foodBudget) {
        this.foodBudget = foodBudget;
    }

    public double getTransportBudget() {
        return transportBudget;
    }

    public void setTransportBudget(double transportBudget) {
        this.transportBudget = transportBudget;
    }

    public double getShoppingBudget() {
        return shoppingBudget;
    }

    public void setShoppingBudget(double shoppingBudget) {
        this.shoppingBudget = shoppingBudget;
    }

    public double getBillsBudget() {
        return billsBudget;
    }

    public void setBillsBudget(double billsBudget) {
        this.billsBudget = billsBudget;
    }

    public double getFoodSpent() {
        return foodSpent;
    }

    public void setFoodSpent(double foodSpent) {
        this.foodSpent = foodSpent;
    }

    public double getTransportSpent() {
        return transportSpent;
    }

    public void setTransportSpent(double transportSpent) {
        this.transportSpent = transportSpent;
    }

    public double getShoppingSpent() {
        return shoppingSpent;
    }

    public void setShoppingSpent(double shoppingSpent) {
        this.shoppingSpent = shoppingSpent;
    }

    public double getBillsSpent() {
        return billsSpent;
    }

    public void setBillsSpent(double billsSpent) {
        this.billsSpent = billsSpent;
    }

    public double getSavingsGoal() {
        return savingsGoal;
    }

    public void setSavingsGoal(double savingsGoal) {
        this.savingsGoal = savingsGoal;
    }

    public double getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(double totalBudget) {
        this.totalBudget = totalBudget;
    }

    public double getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(double totalSpent) {
        this.totalSpent = totalSpent;
    }

    public double getTotalRemaining() {
        return totalRemaining;
    }

    public void setTotalRemaining(double totalRemaining) {
        this.totalRemaining = totalRemaining;
    }

    public double getFoodRemaining() {
        return foodRemaining;
    }

    public void setFoodRemaining(double foodRemaining) {
        this.foodRemaining = foodRemaining;
    }

    public double getTransportRemaining() {
        return transportRemaining;
    }

    public void setTransportRemaining(double transportRemaining) {
        this.transportRemaining = transportRemaining;
    }

    public double getShoppingRemaining() {
        return shoppingRemaining;
    }

    public void setShoppingRemaining(double shoppingRemaining) {
        this.shoppingRemaining = shoppingRemaining;
    }

    public double getBillsRemaining() {
        return billsRemaining;
    }

    public void setBillsRemaining(double billsRemaining) {
        this.billsRemaining = billsRemaining;
    }
}