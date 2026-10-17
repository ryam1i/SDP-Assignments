package com.fintech.subsystem;

import com.fintech.model.Applicant;

public class SolvencyService {

    public boolean canAfford(Applicant applicant, double monthlyPayment) {
        double totalDebt = applicant.getCurrentDebt() + monthlyPayment;
        return applicant.getSalary() >= totalDebt * 2;
    }
}
