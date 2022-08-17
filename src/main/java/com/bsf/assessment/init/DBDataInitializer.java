package com.bsf.assessment.init;

import com.bsf.assessment.entity.Account;
import com.bsf.assessment.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class DBDataInitializer {


    private final AccountRepository accountRepository;


    public void initAccounts(){
        Account account1=Account.builder()
                .code("12345")
                .creationDate(new Date())
                .balance(2000.0)
                .build();
        accountRepository.save(account1);

        Account account2=Account.builder()
                .code("67890")
                .creationDate(new Date())
                .balance(300.0)
                .build();
        accountRepository.save(account2);
    }
}
