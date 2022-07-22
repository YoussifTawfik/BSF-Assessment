package com.bsf.assessment.enums;

public enum AccountStatusEnum {

    ACTIVE("Active"),INACTIVE("Inactive"),PENDING("Pending"),STOLEN("Stolen"),DORMANT("Dormant");

    private final String alias;

    AccountStatusEnum(String alias){
        this.alias=alias;
    }

    public String getAlias(){return this.alias;}

}
