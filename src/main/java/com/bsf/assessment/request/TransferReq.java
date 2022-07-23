package com.bsf.assessment.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor @NoArgsConstructor
public class TransferReq implements Serializable {

    @NotNull
    private String fromAccountCode;

    @NotNull
    private String toAccountCode;

    @NotNull
    @DecimalMax("1000.0") @DecimalMin("0.0")
    private Double amount;
}
