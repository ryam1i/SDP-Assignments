package com.fintech.facade;

import com.fintech.model.Applicant;
import com.fintech.model.LoanResult;
import com.fintech.subsystem.CreditScoreService;
import com.fintech.subsystem.IdentityValidator;
import com.fintech.subsystem.SolvencyService;
import com.fintech.subsystem.TransferService;

public class BankLoanFacade {
    private IdentityValidator identityValidator;
    private CreditScoreService creditScoreService;
    private SolvencyService solvencyService;
    private TransferService transferService;

    public BankLoanFacade() {
        this.identityValidator = new IdentityValidator();
        this.creditScoreService = new CreditScoreService();
        this.solvencyService = new SolvencyService();
        this.transferService = new TransferService();
    }

    public LoanResult applyForLoan(Applicant applicant, String purpose, double amount, int months) {
        if (!identityValidator.isValid(applicant.getIin())) {
            return new LoanResult(false, applicant.getName(), purpose, amount, "IIN is invalid or blacklisted");
        }

        int score = creditScoreService.getScore(applicant.getIin());
        if (score < 600) {
            return new LoanResult(false, applicant.getName(), purpose, amount, "Credit score too low (" + score + ")");
        }

        int rate = score >= 750 ? 16 : 22;
        double monthlyPayment = (amount * (1.0 + rate / 100.0)) / months;

        if (!solvencyService.canAfford(applicant, monthlyPayment)) {
            return new LoanResult(false, applicant.getName(), purpose, amount, "Monthly payment is too high for salary");
        }

        String contractNumber = transferService.makeTransfer(applicant.getIin(), amount);
        return new LoanResult(true, applicant.getName(), purpose, amount, "Contract " + contractNumber + ", Rate " + rate + "%");
    }
}
