package com.bsf.assessment.service.account;

import com.bsf.assessment.dto.AccountResDto;
import com.bsf.assessment.entity.Account;
import com.bsf.assessment.exception.AccountNotFoundException;
import com.bsf.assessment.exception.NotSufficientBalanceException;
import com.bsf.assessment.repository.AccountRepository;
import com.bsf.assessment.request.TransferReq;
import com.bsf.assessment.transformer.AccountTransformer;
import com.bsf.assessment.utils.BSFLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.*;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountTransformer accountTransformer;

    private final BSFLogger LOGGER=BSFLogger.getInstance(AccountServiceImpl.class);

    @Override
    @Transactional
    public Map<String, Account> transfer(TransferReq req) throws Exception {
        String methodName="transfer";
        LOGGER.traceEntry(methodName);
        Account fromAccount=getAccountByCode(req.getFromAccountCode());
        Account toAccount=getAccountByCode(req.getToAccountCode());
        debit(fromAccount, req.getAmount());
        credit(toAccount, req.getAmount());
        Map<String, Account> transferResMap=new HashMap<>();
        transferResMap.put("From Account", fromAccount);
        transferResMap.put("To Account", toAccount);
        LOGGER.traceExit(methodName);
        return transferResMap;
    }

    @Override
    public Account getAccountByCode(String code) throws AccountNotFoundException {
        String methodName="getAccountByCode";
        LOGGER.traceEntry(methodName);
        LOGGER.logInfo(methodName,"Account Code= "+code);
        Account account= accountRepository.getAccountByCode(code);
        if (account==null) throw new AccountNotFoundException("Can't find an account with code= "+code);
        LOGGER.traceExit(methodName);
        return account;
    }

    @Override
    public void debit(Account account, Double amount) throws Exception {
        String methodName="debit";
        LOGGER.traceEntry(methodName);
        LOGGER.logInfo(methodName,"Debit Amount= "+amount);
        if (account.getBalance()-amount<0.0) throw new NotSufficientBalanceException("Account balance is not sufficient!!!");
        account.setBalance(account.getBalance()-amount);
        accountRepository.save(account);
        LOGGER.traceExit(methodName);
    }

    @Override
    public void credit(Account account, Double amount) throws AccountNotFoundException {
        String methodName="Credit";
        LOGGER.traceEntry(methodName);
        LOGGER.logInfo(methodName,"Credit Amount= "+amount);
        account.setBalance(account.getBalance()+amount);
        accountRepository.save(account);
        LOGGER.traceExit(methodName);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}
