package com.fintech.model;

public class Applicant {
    private String name;
    private String iin;
    private double salary;
    private double currentDebt;

    public Applicant(String name, String iin, double salary, double currentDebt) {
        this.name = name;
        this.iin = iin;
        this.salary = salary;
        this.currentDebt = currentDebt;
    }

    public String getName() {
        return name;
    }

    public String getIin() {
        return iin;
    }

    public double getSalary() {
        return salary;
    }

    public double getCurrentDebt() {
        return currentDebt;
    }
}
