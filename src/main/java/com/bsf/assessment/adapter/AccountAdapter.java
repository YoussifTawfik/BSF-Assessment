package com.bsf.assessment.adapter;

import com.bsf.assessment.dto.AccountDto;
import com.bsf.assessment.dto.AccountResDto;
import com.bsf.assessment.entity.Account;
import com.bsf.assessment.exception.AccountNotFoundException;
import com.bsf.assessment.request.TransferReq;
import com.bsf.assessment.service.account.AccountServiceImpl;
import com.bsf.assessment.transformer.AccountTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class AccountAdapter {

    @Autowired
    private AccountServiceImpl accountService;
    @Autowired
    private AccountTransformer transformer;

    public AccountDto getAccountByCode(String code) throws AccountNotFoundException {
        return transformer.transform(accountService.getAccountByCode(code));
    }

    public List<AccountDto> getAllAccounts(){
        List<Account> accounts=accountService.getAllAccounts();
        return accounts.stream().map(transformer::transform).collect(Collectors.toList());
    }

    public Map<String, AccountResDto> transfer(TransferReq req) throws Exception {
        Map<String, Account> accountMap=accountService.transfer(req);
        return accountMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, v-> new AccountResDto(v.getValue().getCode(),v.getValue().getBalance())));
    }


}
