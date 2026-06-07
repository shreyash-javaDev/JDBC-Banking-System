package com.jlw.task4;

public class Customer {

    private long accountNo;
    private String name;
    private double balance;

    public Customer(long accountNo, String name, double balance) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
    }

    public long getAccountNo() {
        return accountNo;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
}
}
