package ru.jucharick.AOP_Transactions.money.services;

import ru.jucharick.AOP_Transactions.money.domains.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccounts();
    Account getAccountById(Long id);
    Account updateAccount(Long id, Account account);
    Account createAccount(Account account);
    void deleteAccount(Long id);
}
