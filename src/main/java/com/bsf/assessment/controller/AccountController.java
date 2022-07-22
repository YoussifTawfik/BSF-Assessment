package com.bsf.assessment.controller;

import com.bsf.assessment.entity.Account;
import com.bsf.assessment.response.ResponseModel;
import com.bsf.assessment.service.account.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "account")
public class AccountController {

    @Autowired
    private AccountServiceImpl accountServiceImpl;

    @GetMapping("save")
    public ResponseModel saveAccount(){
        try {
            return new ResponseModel(HttpStatus.OK.value(),"Account Created Successfully",accountServiceImpl.createAccount());
        }catch (Exception ex){
            return new ResponseModel(HttpStatus.OK.value(),ex.getMessage());
        }
    }
}
