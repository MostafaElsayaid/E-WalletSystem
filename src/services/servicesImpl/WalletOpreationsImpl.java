package services.servicesImpl;

import Models.Account;
import Models.Transaction;
import Models.Wallet;
import services.WalletOpreations;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class WalletOpreationsImpl implements WalletOpreations {
    private static Account account;

    private Scanner scanner = new Scanner(System.in);

    public WalletOpreationsImpl(Account account) {
        this.account = account;
    }


    @Override
    public void start() {
        int counter = 0;
        while (true) {
            System.out.println("--------------->*<----------------");
            System.out.println("Welcome Back " + account.getUserName());
            System.out.println("1.deposit  2.withdraw  3.checkBalance  4.transferMoney  ");
            System.out.println("5.TransactionsHistory   6.ShowProfileDetails");
            System.out.println("7.Return to Main Menu");
            System.out.println("Enter your choice:");
            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Invalid Input. Please enter a number.");
                scanner.nextLine();
                continue;
            }
            boolean exit = false;
            switch (choice) {
                case 1:
                    System.out.println("Enter amount to deposit:");
                    double depositeAmount = scanner.nextDouble();
                    deposit(depositeAmount);
                    break;

                case 2:
                    System.out.println("Enter amount to withdraw:");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 3:
                     System.out.println("Your current balance is: " + checkBalance());
                    break;
                case 4:
                    System.out.println("Enter target's name:");
                    String targetName = scanner.next();
                    System.out.println("Enter amount to transfer:");
                    double amount = scanner.nextDouble();
                    transfer(targetName, amount);
                    break;
                case 5:
                    printTransactionHistory();
                    break;

                case 6:
                     showAccountDetails();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                default:
                    counter++;
                    if (counter != 4) {
                        System.out.println("Invalid choice!");
                    }
            }
            if(exit) break;
            if(counter == 4){
                System.out.println("Too many invalid choices. Returning to main menu.");
                break;
            }
        }
    }

    @Override
    public void deposit(double amount) {
        if (amount < 0)
            System.out.println("Insufficient funds!");
        else {
            double newBalance = account.getBalance() + amount;
            account.setBalance(newBalance);
            System.out.println("Deposit successful! your Balance is :"+ account.getBalance());
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > account.getBalance() || amount < 0)
            System.out.println("Insufficient funds!");
        else {
            double newBalance = account.getBalance() - amount;
            account.setBalance(newBalance);
            System.out.println("Withdrawal successful! Your Balance is :"+ account.getBalance());
        }

    }

    @Override
    public double checkBalance() {
        return account.getBalance();
    }

    @Override
    public void transfer(String targetName, double amount) {
        if (amount > account.getBalance() || amount < 0){
            System.out.println("Insufficient funds!");
        } else {
            double newBalance = account.getBalance() - amount;
            account.setBalance(newBalance);
            try {
                Wallet wallet = Wallet.getInstance();
                Account targetAcc = wallet.getAccountByName(targetName);
                if(targetAcc!= null){
                    double targetBalance = targetAcc.getBalance() + amount;
                    targetAcc.setBalance(targetBalance);
                    System.out.println("Transfer successful! Your Balance is :"+ account.getBalance());
                    System.out.println("Transferred to account: " + targetAcc.getUserName());
                }  else{
                    System.out.println("Account not found!");
                }
                Transaction tx = new Transaction(account.getUserName(), targetAcc.getUserName(), amount);
                account.getTransactions().add(tx);
                targetAcc.getTransactions().add(tx);
            } catch (Exception e) {
                System.out.println("Error occurred while transferring funds: " + e.getMessage());
            }



        }
    }

    @Override
    public void printTransactionHistory() {
        System.out.println("Transaction History for " + account.getUserName());
        for (Transaction tx : account.getTransactions()) {
            System.out.println(tx.toString());
        }
    }



    @Override
    public void showAccountDetails() {
        System.out.println( account.toString());
    }
}
