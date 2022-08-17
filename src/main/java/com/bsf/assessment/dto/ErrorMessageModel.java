package com.bsf.assessment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data @AllArgsConstructor
public class ErrorMessageModel {

    private LocalDateTime timestamp;
    private String message;
}
