package com.bsf.assessment.exception;

public class InvalidParameterException extends BSFParentException{

    public InvalidParameterException(){

    }
    public InvalidParameterException(String message){
        super(message);
    }
}
