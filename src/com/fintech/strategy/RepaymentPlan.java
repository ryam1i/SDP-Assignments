package com.fintech.strategy;

public class RepaymentPlan {
    private String name;
    private long total;
    private String note;

    public RepaymentPlan(String name, long total, String note) {
        this.name = name;
        this.total = total;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public long getTotal() {
        return total;
    }

    public String getNote() {
        return note;
    }

    @Override
    public String toString() {
        return name + " -> " + note + " (Total payout: " + total + " KZT)";
    }
}
