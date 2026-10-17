package com.fintech.model;

public class LoanResult {
    private boolean approved;
    private String name;
    private String purpose;
    private double amount;
    private String info;

    public LoanResult(boolean approved, String name, String purpose, double amount, String info) {
        this.approved = approved;
        this.name = name;
        this.purpose = purpose;
        this.amount = amount;
        this.info = info;
    }

    public boolean isApproved() {
        return approved;
    }

    @Override
    public String toString() {
        long roundedAmount = (long) amount;
        if (approved) {
            return name + " (" + purpose + ", " + roundedAmount + " KZT) -> APPROVED: " + info;
        }
        return name + " (" + purpose + ", " + roundedAmount + " KZT) -> REJECTED: " + info;
    }
}
