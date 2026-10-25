package com.fintech.strategy;

public class LoanCalculator {
    private RepaymentStrategy strategy;

    public LoanCalculator(RepaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(RepaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public RepaymentPlan calculate(double amount, int months, double annualRate) {
        return strategy.calculate(amount, months, annualRate);
    }
}
