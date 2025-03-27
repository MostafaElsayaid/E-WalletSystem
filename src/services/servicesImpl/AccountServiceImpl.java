package services.servicesImpl;

import Models.Account;
import Models.Wallet;
import services.AccountService;

import java.util.Map;

public class AccountServiceImpl implements AccountService {
    private Wallet wallet = Wallet.getInstance();
    @Override
    public boolean isAccountCreated(Account account) {
        Map<Integer, Account> accounts = wallet.getAccounts();
        for (Map.Entry<Integer, Account> entry : accounts.entrySet()){
            Account acc = entry.getValue();
            if (acc.getUserName().equals(account.getUserName())){
                return false;
            }
        }
        wallet.getAccounts().put(account.getAccountId(), account);
        return true;
        }

    @Override
    public Account login(String username, String password) {
        Account foundAcc = null;
        Map<Integer, Account> accounts = wallet.getAccounts();
        for (Map.Entry<Integer, Account> entry : accounts.entrySet()) {
            Account acc = entry.getValue();
            if (acc.getUserName().equals(username) && acc.getPassword().equals(password)) {
               foundAcc = acc;
            }
        }
        if (foundAcc != null)
            return foundAcc;
        return null;
    }
}

