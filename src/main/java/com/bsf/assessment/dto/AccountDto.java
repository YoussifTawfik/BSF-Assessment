package com.bsf.assessment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor
public class AccountDto {

    private Date creationDate;

    private Double balance;

    private Long clientId;

    private Long statusId;

}
