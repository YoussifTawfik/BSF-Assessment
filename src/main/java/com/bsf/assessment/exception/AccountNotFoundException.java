package com.bsf.assessment.exception;

public class AccountNotFoundException extends Exception{

    public AccountNotFoundException(String message){
        super(message);
    }

    public AccountNotFoundException(){
        super();
    }
}
