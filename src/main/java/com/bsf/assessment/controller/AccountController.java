package com.bsf.assessment.controller;

import com.bsf.assessment.adapter.AccountAdapter;
import com.bsf.assessment.exception.BSFParentException;
import com.bsf.assessment.request.TransferReq;
import com.bsf.assessment.response.ResponseModel;
import com.bsf.assessment.service.account.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {


    private final AccountAdapter accountAdapter;
    private final IAccountService accountService;

    @PostMapping("transfer")
    public ResponseModel transferMoney(@Valid @RequestBody TransferReq req) throws BSFParentException {
        return new ResponseModel(HttpStatus.OK.value(),"Transaction Succeed",accountAdapter.transfer(accountService.transfer(req)));
    }

    @GetMapping("details")
    public ResponseModel getAccountByCode(@NotNull @NotEmpty @RequestParam String code) throws BSFParentException {
        return new ResponseModel(HttpStatus.OK.value(),"Retrieving Succeed",accountAdapter.getAccountByCode(accountService.getAccountByCode(code)));
    }

}
