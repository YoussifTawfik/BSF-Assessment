package com.bsf.assessment.service.account;

import com.bsf.assessment.dto.AccountDto;
import com.bsf.assessment.dto.AccountResDto;
import com.bsf.assessment.entity.Account;
import com.bsf.assessment.enums.TransferType;
import com.bsf.assessment.exception.AccountNotFoundException;
import com.bsf.assessment.exception.BSFParentException;
import com.bsf.assessment.request.TransferReq;

import java.util.List;
import java.util.Map;

public interface IAccountService {

    Map<TransferType, Account> transfer(TransferReq req) throws BSFParentException;

    Account getAccountByCode(String code) throws BSFParentException;

    void debit(Account account, Double amount) throws BSFParentException;

    void credit(Account account, Double amount) throws BSFParentException;

}
