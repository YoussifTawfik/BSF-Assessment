package com.bsf.assessment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor
public class AccountDto {

    private String code;

    private Double balance;

    private Date creationDate;

//    public AccountDto from(Account account){
//
//    }
}
