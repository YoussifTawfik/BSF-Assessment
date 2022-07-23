package com.bsf.assessment.transformer;

import com.bsf.assessment.dto.AccountDto;
import com.bsf.assessment.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountTransformer {

    public AccountDto transform(Account entity){
        AccountDto dto=new AccountDto();
        dto.setCreationDate(entity.getCreationDate());
        dto.setBalance(entity.getBalance());
        dto.setCode(entity.getCode());
        return dto;
    }
}
