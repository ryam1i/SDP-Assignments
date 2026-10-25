package com.fintech.strategy;

public class DifferentiatedRepaymentStrategy implements RepaymentStrategy {

    @Override
    public RepaymentPlan calculate(double amount, int months, double annualRate) {
        double monthlyRate = (annualRate / 100.0) / 12.0;
        double principalPerMonth = amount / months;
        double firstMonth = principalPerMonth + (amount * monthlyRate);
        double lastMonth = principalPerMonth + (principalPerMonth * monthlyRate);
        double totalInterest = amount * (annualRate / 100.0) * ((months + 1.0) / 24.0);
        long total = Math.round(amount + totalInterest);

        return new RepaymentPlan("Differentiated", total, Math.round(firstMonth) + " KZT first month, down to " + Math.round(lastMonth) + " KZT");
    }
}
