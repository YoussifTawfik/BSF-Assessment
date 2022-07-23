package com.bsf.assessment.init;

import com.bsf.assessment.entity.Account;
import com.bsf.assessment.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DBDataInitializer {

    @Autowired
    private AccountRepository accountRepository;


    public void initAccounts(){
        Account account1=new Account();
        account1.setCode("12345");
        account1.setCreationDate(new Date());
        account1.setBalance(1500.0);
        accountRepository.save(account1);

        Account account2=new Account();
        account2.setCode("67890");
        account2.setCreationDate(new Date());
        account2.setBalance(300.0);
        accountRepository.save(account2);
    }
}
