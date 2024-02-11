package ru.jucharick.AOP_Transactions.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.jucharick.AOP_Transactions.domains.Account;
import ru.jucharick.AOP_Transactions.repositories.AccountRepository;
import ru.jucharick.AOP_Transactions.services.AccountService;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class iAccountService implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Account updateAccount(Long id, Account account) {
        Account accountByID = getAccountById(id);
        accountByID.setCnum(account.getCnum());
        accountByID.setAcid(account.getAcid());
        accountByID.setAmount(account.getAmount());
        accountByID.setUpd_date(LocalDateTime.now());
        return accountRepository.save(accountByID);
    }

    @Override
    public Account createAccount(Account account) {
        account.setUpd_date(LocalDateTime.now());
        return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(Long id) {
        Account accountByID = getAccountById(id);
        accountRepository.delete(accountByID);
    }
}
