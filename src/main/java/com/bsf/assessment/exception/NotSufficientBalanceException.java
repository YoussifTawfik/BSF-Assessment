package com.bsf.assessment.exception;

public class NotSufficientBalanceException extends Exception{

    public NotSufficientBalanceException(String message){
        super(message);
    }

    public NotSufficientBalanceException(){
        super();
    }
}