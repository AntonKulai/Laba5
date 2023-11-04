package com.laba5;

public class BankTest {
    public static void main(String[] args) {
        Bank bank = new Bank();
        BankAccount account1 = bank.createAccount("Alice", 1000);
        BankAccount account2 = bank.createAccount("Bob", 500);

        try {
            account1.withdraw(1500); // Спроба зняти більше грошей, ніж є на рахунку
        } catch (InsufficientFundsException e) {
            System.out.println("Insufficient funds: " + e.getMessage());
        }

        try {
            account1.deposit(-200); // Спроба здійснити внесок з від'ємною сумою
        } catch (NegativeAmountException e) {
            System.out.println("Negative deposit amount: " + e.getMessage());
        }

        try {
            BankAccount account3 = bank.findAccount(3); // Спроба знайти неіснуючий рахунок
        } catch (AccountNotFoundException e) {
            System.out.println("Account not found: " + e.getMessage());
        }

        bank.transferMoney(1, 2, 700); // Переказати гроші з account1 до account2
        System.out.println(account1.getAccountSummary());
        System.out.println(account2.getAccountSummary());
    }
}


