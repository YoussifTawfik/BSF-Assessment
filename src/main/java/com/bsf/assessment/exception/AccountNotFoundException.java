package com.bsf.assessment.exception;

public class AccountNotFoundException extends BSFParentException{

    public AccountNotFoundException(String message){
        super(message);
    }

    public AccountNotFoundException(){
        super();
    }
}
