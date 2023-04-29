package com.robvega.bank;

public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(200.0, 350.0);
        BankAccount anotherAccount = new BankAccount(500.0, 100.0);

        System.out.println("Accounts count: " + BankAccount.getAccountsCount());
        System.out.println("Total Bank Money: $" + BankAccount.getTotalBalanceBetweenAccounts());

        account.printAccountBalance();
        account.depositMoney("current", 1000.5);
        account.depositMoney("saving", 500.0);
        account.withdrawMoney("current", 1000.0);
        account.printAccountBalance();

        anotherAccount.printAccountBalance();

        System.out.println("Total Bank Money: $" + BankAccount.getTotalBalanceBetweenAccounts());
    }
}
