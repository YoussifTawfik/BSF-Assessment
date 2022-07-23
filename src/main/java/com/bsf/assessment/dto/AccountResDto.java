package com.bsf.assessment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor @NoArgsConstructor
public class AccountResDto implements Serializable {

    private String code;

    private Double newBalance;
}
