package com.fintech;

import com.fintech.facade.BankLoanFacade;
import com.fintech.model.Applicant;
import com.fintech.subsystem.IdentityValidator;

public class Main {
    public static void main(String[] args) {
        BankLoanFacade bank = new BankLoanFacade();

        System.out.println();

        Applicant kuttybay = new Applicant("Kuttybay Tangatar", "950315301110", 850000, 50000);
        Applicant abock = new Applicant("Abdrakhman Etmakhambetov", "981120400123", 250000, 110000);
        Applicant asnki = new Applicant("Asanali Toleukhan", "991231500123", 900000, 0);

        System.out.println(bank.applyForLoan(kuttybay, "Another BMW", 2000000, 24));
        System.out.println(bank.applyForLoan(abock, "Appartments in Aktobe", 3500000, 12));
        System.out.println(bank.applyForLoan(asnki, "Temka", 500000, 6));

        System.out.println();
        IdentityValidator validator = new IdentityValidator();
        System.out.println("Checking Asanali's IIN: " + validator.isValid(asnki.getIin()));
        //асанали здесь чисто для примера, сам он порядочный пацан
        System.out.println();
    }
}
