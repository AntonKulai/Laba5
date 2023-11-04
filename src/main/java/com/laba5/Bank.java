package com.laba5;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<BankAccount> accounts = new ArrayList<>();

    public BankAccount createAccount(String accountName, double initialDeposit) {
        int accountNumber = accounts.size() + 1;
        BankAccount account = new BankAccount(accountNumber, accountName, initialDeposit);
        accounts.add(account);
        return account;
    }

    public BankAccount findAccount(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        throw new AccountNotFoundException("Account not found for account number: " + accountNumber);
    }

    public void transferMoney(int fromAccountNumber, int toAccountNumber, double amount) {
        BankAccount fromAccount = findAccount(fromAccountNumber);
        BankAccount toAccount = findAccount(toAccountNumber);

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }
}



