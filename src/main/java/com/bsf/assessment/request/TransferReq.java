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

    @NotNull(message = "From Account code can not be null")
    private String fromAccountCode;

    @NotNull(message = "To Account code can not be null")
    private String toAccountCode;

    @NotNull(message = "Amount value can not be null")
    @DecimalMin(value = "1.0",message = "Amount value can not be less than 1.0")
    private Double amount;
}
