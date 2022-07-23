package com.bsf.assessment.adapter;

import com.bsf.assessment.dto.AccountDto;
import com.bsf.assessment.dto.AccountResDto;
import com.bsf.assessment.dto.TransferDto;
import com.bsf.assessment.entity.Account;
import com.bsf.assessment.enums.TransferType;
import com.bsf.assessment.exception.BSFParentException;
import com.bsf.assessment.request.TransferReq;
import com.bsf.assessment.service.account.IAccountService;
import com.bsf.assessment.transformer.AccountTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AccountAdapter {

    private final AccountTransformer transformer;

    public AccountDto getAccountByCode(Account account) throws BSFParentException {
        return transformer.transform(account);
    }

    public TransferDto transfer(Map<TransferType, Account> accountMap) throws Exception {
        TransferDto transferDto=new TransferDto();
        transferDto.setFromAccountDetails(new AccountResDto(accountMap.get(TransferType.FROM).getCode(), accountMap.get(TransferType.FROM).getBalance()));
        transferDto.setToAccountDetails(new AccountResDto(accountMap.get(TransferType.TO).getCode(), accountMap.get(TransferType.TO).getBalance()));
        return transferDto;
    }


}
