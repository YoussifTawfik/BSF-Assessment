package com.bsf.assessment.exception;

public class InsufficientBalanceException extends BSFParentException{

    public InsufficientBalanceException(String message){
        super(message);
    }

    public InsufficientBalanceException(){
        super();
    }
}