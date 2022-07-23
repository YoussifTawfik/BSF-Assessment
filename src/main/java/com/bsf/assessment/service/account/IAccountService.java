package com.bsf.assessment.service.account;

import com.bsf.assessment.dto.AccountDto;
import com.bsf.assessment.dto.AccountResDto;
import com.bsf.assessment.entity.Account;
import com.bsf.assessment.exception.AccountNotFoundException;
import com.bsf.assessment.request.TransferReq;

import java.util.List;
import java.util.Map;

public interface IAccountService {

    Map<String, Account> transfer(TransferReq req) throws Exception;

    Account getAccountByCode(String code) throws AccountNotFoundException;

    void debit(Account account, Double amount) throws Exception;

    void credit(Account account, Double amount) throws Exception;

    List<Account> getAllAccounts();

}
