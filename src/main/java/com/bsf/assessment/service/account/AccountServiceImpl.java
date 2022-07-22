package com.bsf.assessment.service.account;

import com.bsf.assessment.dto.AccountDto;
import com.bsf.assessment.entity.Account;
import com.bsf.assessment.repository.BSFBaseRepository;
import com.bsf.assessment.transformer.AccountTransformer;
import com.bsf.assessment.utils.BSFLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    BSFBaseRepository<Account,Long> accountRepository;
    @Autowired
    private AccountTransformer accountTransformer;

    private final BSFLogger logger=BSFLogger.getInstance(AccountServiceImpl.class);

    @Override
    public AccountDto createAccount(){
        String methodName="createAccount";
        logger.traceEntry(methodName);
        Account account=new Account();
        account.setCreationDate(new Date());
        account.setBalance(2500.0);
        accountRepository.save(account);
        logger.logInfo(methodName,"Account has been created with id= "+account.getId());
        logger.traceExit(methodName);
        return accountTransformer.transform(account);
    }
}
