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
        dto.setClientId(entity.getClient()!=null?entity.getClient().getId():null);
        dto.setStatusId(entity.getAccountStatus()!=null?entity.getAccountStatus().getId():null);
        return dto;
    }
}
