package services;

import Models.Account;

public interface AccountService {
    boolean isAccountCreated(Account account);
    Account login (String username, String password);
}
