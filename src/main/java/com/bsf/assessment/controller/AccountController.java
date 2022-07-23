package com.bsf.assessment.controller;

import com.bsf.assessment.adapter.AccountAdapter;
import com.bsf.assessment.entity.Account;
import com.bsf.assessment.request.TransferReq;
import com.bsf.assessment.response.ResponseModel;
import com.bsf.assessment.service.account.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "account")
public class AccountController {

    @Autowired
    private AccountAdapter accountAdapter;

    @PostMapping("transfer")
    public ResponseModel transferMoney(@Valid @RequestBody TransferReq req){
        try {
            return new ResponseModel(HttpStatus.OK.value(),"Transaction Succeed",accountAdapter.transfer(req));
        }catch (Exception ex){
            return new ResponseModel(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage());
        }
    }

    @GetMapping("all")
    public ResponseModel findAllAccounts(){
        try {
            return new ResponseModel(HttpStatus.OK.value(),"Retrieving Succeed",accountAdapter.getAllAccounts());
        }catch (Exception ex){
            return new ResponseModel(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage());
        }
    }

    @GetMapping("details")
    public ResponseModel findByCode(@RequestParam String code){
        try {
            return new ResponseModel(HttpStatus.OK.value(),"Retrieving Succeed",accountAdapter.getAccountByCode(code));
        }catch (Exception ex){
            return new ResponseModel(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage());
        }
    }

}
