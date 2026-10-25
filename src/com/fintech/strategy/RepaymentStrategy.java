package com.fintech.strategy;

public interface RepaymentStrategy {
    RepaymentPlan calculate(double amount, int months, double annualRate);
}
