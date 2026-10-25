package com.fintech.strategy;

public class Main {
    public static void main(String[] args) {
        double amount = 1200000;
        int months = 12;
        double rate = 18;

        System.out.println("Loan calculation for " + (long) amount + " KZT for " + months + " months at " + (int) rate + "%:\n");

        LoanCalculator calculator = new LoanCalculator(new AnnuityRepaymentStrategy());
        System.out.println(calculator.calculate(amount, months, rate));

        calculator.setStrategy(new DifferentiatedRepaymentStrategy());
        System.out.println(calculator.calculate(amount, months, rate));

        calculator.setStrategy(new GracePeriodRepaymentStrategy());
        System.out.println(calculator.calculate(amount, months, rate));
    }
}
