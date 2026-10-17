package com.fintech.subsystem;

public class TransferService {

    public String makeTransfer(String iin, double amount) {
        int randomId = (int) (Math.random() * 900000) + 100000;
        return "KZ-" + randomId;
    }
}
