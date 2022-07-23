package com.bsf.assessment.service.account;

import com.bsf.assessment.entity.Account;
import com.bsf.assessment.enums.TransferType;
import com.bsf.assessment.exception.AccountNotFoundException;
import com.bsf.assessment.exception.BSFParentException;
import com.bsf.assessment.exception.InvalidParameterException;
import com.bsf.assessment.exception.InsufficientBalanceException;
import com.bsf.assessment.repository.AccountRepository;
import com.bsf.assessment.request.TransferReq;
import com.bsf.assessment.utils.BSFLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private final AccountRepository accountRepository;
    private final BSFLogger LOGGER=BSFLogger.getInstance(AccountServiceImpl.class);

    @Override
    @Transactional
    public Map<TransferType, Account> transfer(TransferReq req) throws BSFParentException {
        String methodName="transfer";
        LOGGER.traceEntry(methodName);
        Account fromAccount=getAccountByCode(req.getFromAccountCode());
        Account toAccount=getAccountByCode(req.getToAccountCode());
        debit(fromAccount, req.getAmount());
        credit(toAccount, req.getAmount());
        Map<TransferType, Account> transferResMap=new HashMap<>();
        transferResMap.put(TransferType.FROM, fromAccount);
        transferResMap.put(TransferType.TO, toAccount);
        LOGGER.traceExit(methodName);
        return transferResMap;
    }

    @Override
    public Account getAccountByCode(String code) throws BSFParentException {
        String methodName="getAccountByCode";
        LOGGER.traceEntry(methodName);
        LOGGER.logInfo(methodName,"Account Code= "+code);
        if (code==null || code.isBlank()) throw new InvalidParameterException("Code can not be null or empty!!!");
        Account account= accountRepository.getAccountByCode(code);
        if (account==null) throw new AccountNotFoundException("Can't find an account with code= "+code);
        LOGGER.traceExit(methodName);
        return account;
    }

    @Override
    public void debit(Account account, Double amount) throws BSFParentException {
        String methodName="debit";
        LOGGER.traceEntry(methodName);
        LOGGER.logInfo(methodName,"Debit Amount= "+amount);
        if (account.getBalance() < amount) throw new InsufficientBalanceException("Account balance is not sufficient!!!");
        account.setBalance(account.getBalance()-amount);
        accountRepository.save(account);
        LOGGER.traceExit(methodName);
    }

    @Override
    public void credit(Account account, Double amount) {
        String methodName="Credit";
        LOGGER.traceEntry(methodName);
        LOGGER.logInfo(methodName,"Credit Amount= "+amount);
        account.setBalance(account.getBalance()+amount);
        accountRepository.save(account);
        LOGGER.traceExit(methodName);
    }
}
