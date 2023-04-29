package com.robvega.bank;

import java.util.Random;

public class BankAccount {
    private String accountNumber;
    private double currentAccountBalance;
    private double savingAccountBalance;
    private static int accountsCount;
    private static double totalBalanceBetweenAccounts;

    public BankAccount(double currentAccountBalance, double savingAccountBalance) {
        this.setAccountNumber(randomDigits());
        this.setCurrentAccountBalance(currentAccountBalance);
        this.setSavingAccountBalance(savingAccountBalance);
        accountsCount++;
        totalBalanceBetweenAccounts += this.getCurrentAccountBalance() + this.getSavingAccountBalance();
    }

    private String randomDigits() {
        Random random = new Random();
        String newAccountNumber = "";
        for (int i = 1; i <= 10; i++) {
            newAccountNumber += Integer.toString(random.nextInt(10));
        }
        return newAccountNumber;
    }

    public void depositMoney(String accountType, double amount) {
        if (accountType.equals("current") && amount > 0) {
            this.currentAccountBalance += amount;
            totalBalanceBetweenAccounts += amount;
        } else if (accountType.equals("saving") && amount > 0) {
            this.savingAccountBalance += amount;
            totalBalanceBetweenAccounts += amount;
        } else {
            System.out.println("Not a valid account!!!");
        }
    }

    public void withdrawMoney(String accountType, double amount) {
        if (accountType.equals("current")) {
            if (this.currentAccountBalance >= amount) {
                this.currentAccountBalance -= amount;
                totalBalanceBetweenAccounts -= amount;
            } else {
                System.out.println("Not enough money on the account :(");
            }
        } else if (accountType.equals("saving")) {
            if (this.savingAccountBalance >= amount) {
                this.savingAccountBalance -= amount;
                totalBalanceBetweenAccounts -= amount;
            } else {
                System.out.println("Not enough money on the account :(");
            }
        } else {
            System.out.println("Not a valid account!!!");
        }
    }

    public void printAccountBalance() {
        System.out.printf("Account N: " + this.accountNumber + "\n" +
                "Current Account Balance: $" + this.currentAccountBalance + "\n" +
                "Saving Account Balance: $" + this.savingAccountBalance + "\n");
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getCurrentAccountBalance() {
        return currentAccountBalance;
    }

    public void setCurrentAccountBalance(double currentAccountBalance) {
        this.currentAccountBalance = currentAccountBalance;
    }

    public double getSavingAccountBalance() {
        return savingAccountBalance;
    }

    public void setSavingAccountBalance(double savingAccountBalance) {
        this.savingAccountBalance = savingAccountBalance;
    }

    public static int getAccountsCount() {
        return accountsCount;
    }

    public static double getTotalBalanceBetweenAccounts() {
        return totalBalanceBetweenAccounts;
    }
}
