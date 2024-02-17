package ru.jucharick.pay.services;

import ru.jucharick.pay.domains.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccounts();
    Account getAccountById(Long id);
    Account updateAccount(Long id, Account account);
    Account createAccount(Account account);
    void deleteAccount(Long id);
}
