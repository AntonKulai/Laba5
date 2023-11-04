package com.laba5;
import java.util.Random;

public class BankAccount {
    private int accountNumber;
    private String accountName;
    private double balance;

    public BankAccount(int accountNumber, String accountName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = initialDeposit;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new NegativeAmountException("Cannot deposit a negative amount.");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            throw new NegativeAmountException("Cannot withdraw a negative amount.");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountSummary() {
        return "Account Number: " + accountNumber + ", Account Name: " + accountName + ", Balance: " + balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}







