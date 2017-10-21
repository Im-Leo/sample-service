package com.plaguesoft.microservices.sample.service.service;

import com.plaguesoft.microservices.sample.service.domain.Account;
import com.plaguesoft.microservices.sample.service.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account getAccount(Long id) {
        return accountRepository.findOne(id);
    }

    public Collection<Account> findByName(String name) {
        return accountRepository.findByName(name);
    }

    public List<Account> getAll() {
        return accountRepository.findAll();
    }

}
