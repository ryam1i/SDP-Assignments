package com.fintech.strategy;

public class AnnuityRepaymentStrategy implements RepaymentStrategy {

    @Override
    public RepaymentPlan calculate(double amount, int months, double annualRate) {
        double monthlyRate = (annualRate / 100.0) / 12.0;
        double monthlyPayment = amount * (monthlyRate / (1.0 - Math.pow(1.0 + monthlyRate, -months)));
        long total = Math.round(monthlyPayment * months);
        long payment = Math.round(monthlyPayment);

        return new RepaymentPlan("Annuity", total, payment + " KZT per month");
    }
}
