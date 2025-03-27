package Models;
import java.util.HashMap;
import java.util.Map;

public class Wallet {
    private final String name = "MostafaE-wallet";
    private Map<Integer, Account> accounts  ;
    private static Wallet instance;
    private Wallet() {
        accounts = new HashMap<>();
    }
    // Apply singleton pattern
    public static Wallet getInstance() {
        if (instance == null) {
            instance = new Wallet();

        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<Integer, Account> accounts) {
        this.accounts = accounts;
    }

    public Account getAccountByName(String targetName) {
        // search for account by name in the wallet's accounts map.
        Account acc = null;
        for (Account account : accounts.values()) {
            if (account.getUserName().equalsIgnoreCase(targetName)) {
                acc = account;
            }
        }
       if (acc != null)
           return acc;

       return null;
    }
}
