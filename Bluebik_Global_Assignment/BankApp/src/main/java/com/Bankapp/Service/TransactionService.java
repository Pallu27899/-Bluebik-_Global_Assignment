package com.Bankapp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Bankapp.Entity.Account;
import com.Bankapp.Repository.AccountRepository;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public void credit(Long userId, Double amount) {
        Account account = getAccountByUserId(userId);
        if (account.getBalance() + amount > 10000000) {
            throw new RuntimeException("Credit amount exceeds maximum account balance");
        }
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);
    }

    @Transactional
    public void debit(Long userId, Double amount) {
        Account account = getAccountByUserId(userId);
        if (account.getBalance() - amount < 0) {
            throw new RuntimeException("Debit amount exceeds minimum account balance");
        }
        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);
    }

    private Account getAccountByUserId(Long userId) {
        List<Account> accounts = accountRepository.findByUsersUserId(userId);
        if (accounts.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        return accounts.get(0); // Assume that each user has only one account for simplicity
    }
}
