package com.bsf.assessment.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ResponseModel implements Serializable {

    private Integer statusCode;

    private String message;

    private Object data;

    public ResponseModel(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

}
