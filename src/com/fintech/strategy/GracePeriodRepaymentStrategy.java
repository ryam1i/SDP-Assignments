package com.fintech.strategy;

public class GracePeriodRepaymentStrategy implements RepaymentStrategy {

    @Override
    public RepaymentPlan calculate(double amount, int months, double annualRate) {
        int graceMonths = 3;
        double monthlyRate = (annualRate / 100.0) / 12.0;
        double interestOnly = amount * monthlyRate;
        int remainingMonths = months - graceMonths;
        double mainPayment = amount * (monthlyRate / (1.0 - Math.pow(1.0 + monthlyRate, -remainingMonths)));
        long total = Math.round(interestOnly * graceMonths + mainPayment * remainingMonths);

        return new RepaymentPlan("Grace Period (3 months)", total, Math.round(interestOnly) + " KZT first 3 months, then " + Math.round(mainPayment) + " KZT");
    }
}
