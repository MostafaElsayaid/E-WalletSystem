package Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Account {
    private static int accountCount = 100;
    private Integer accountId;
    private String userName;
    private String password;
    private double balance = 0;
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    private boolean isActive = true;

    public Account() {
    }

    public boolean isActive() {
        return isActive;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Integer getAccountId() {
        return accountId;
    }
    public  Account(String userName, String password){
        this.accountId = accountCount++;
        this.userName = userName;
        this.password = password;
    }
    public Account( String userName, String password, double balance) {
        this.accountId = accountCount++;
        this.userName = userName;
        this.password = password;
        this.balance = balance;

    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }




    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userName='" + userName + '\'' +
                ", balance=" + balance +
                ", transactions=" + transactions +
                '}';
    }
}
