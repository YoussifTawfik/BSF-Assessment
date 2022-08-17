package com.bsf.assessment.exception;

import com.bsf.assessment.dto.ErrorMessageModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BSFParentException.class)
    public ResponseEntity<Object> handleBSFExceptions(BSFParentException ex, WebRequest request) {
        ErrorMessageModel errorMessageModel=new ErrorMessageModel(LocalDateTime.now(),ex.getMessage());
        return new ResponseEntity<>(errorMessageModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
