package com.bsf.assessment.service.account;

import com.bsf.assessment.entity.Account;
import com.bsf.assessment.enums.TransferType;
import com.bsf.assessment.exception.BSFParentException;
import com.bsf.assessment.repository.AccountRepository;
import com.bsf.assessment.request.TransferReq;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {

    @Mock
    private AccountRepository accountRepository;
    private IAccountService accountService;

    @BeforeEach
    void setUp() {
        accountService=new AccountServiceImpl(accountRepository);
    }

    @Test
    void getAccountByCodeEmptyAccountCodeTest() throws BSFParentException {
        Account account=new Account();
        account.setCreationDate(new Date());
        account.setCode("12345");
        account.setBalance(1500.0);
        when(accountRepository.getAccountByCode(any(String.class))).thenReturn(account);
        Account retrievedAccount=null;
        retrievedAccount = accountService.getAccountByCode("  ");
        assertNotNull(retrievedAccount);
        assertEquals(retrievedAccount.getCode(),account.getCode());
    }

    @Test
    void getAccountByCodeNullAccountCodeTest() throws BSFParentException {
        Account account=new Account();
        account.setCreationDate(new Date());
        account.setCode("12345");
        account.setBalance(1500.0);
        when(accountRepository.getAccountByCode(any(String.class))).thenReturn(account);
        Account retrievedAccount=null;
        retrievedAccount = accountService.getAccountByCode(null);
        assertNotNull(retrievedAccount);
        assertEquals(retrievedAccount.getCode(),account.getCode());
    }

    @Test
    void getAccountByCode() throws BSFParentException {
        Account account=new Account();
        account.setCreationDate(new Date());
        account.setCode("12345");
        account.setBalance(1500.0);
        when(accountRepository.getAccountByCode(any(String.class))).thenReturn(account);
        Account retrievedAccount=null;
        retrievedAccount = accountService.getAccountByCode("12345");
        assertNotNull(retrievedAccount);
        assertEquals(retrievedAccount.getCode(),account.getCode());
    }

    @Test
    void transferWithNoFromAccount() throws BSFParentException {
        Account account=new Account();
        account.setCreationDate(new Date());
        account.setCode("12345");
        account.setBalance(1500.0);

        TransferReq req=new TransferReq();
        req.setFromAccountCode("");
        req.setToAccountCode("67890");
        req.setAmount(20.0);
        when(accountRepository.getAccountByCode(any(String.class))).thenReturn(account);
        Map<TransferType, Account> transferResMap=accountService.transfer(req);
        assertTrue(transferResMap.size()>0);
    }

    @Test
    void transferWithNoToAccount() throws BSFParentException {
        Account account=new Account();
        account.setCreationDate(new Date());
        account.setCode("12345");
        account.setBalance(1500.0);

        TransferReq req=new TransferReq();
        req.setFromAccountCode("12345");
        req.setToAccountCode("");
        req.setAmount(20.0);
        when(accountRepository.getAccountByCode(any(String.class))).thenReturn(account);
        Map<TransferType, Account> transferResMap=accountService.transfer(req);
        assertTrue(transferResMap.size()>0);
    }

    @Test
    void transferInsufficientBalance() throws BSFParentException {
        Account account=new Account();
        account.setCreationDate(new Date());
        account.setCode("12345");
        account.setBalance(10.0);

        TransferReq req=new TransferReq();
        req.setFromAccountCode("12345");
        req.setToAccountCode("67890");
        req.setAmount(20.0);
        when(accountRepository.getAccountByCode(any(String.class))).thenReturn(account);
        Map<TransferType, Account> transferResMap=accountService.transfer(req);
        assertTrue(transferResMap.size()>0);
    }

    @Test
    void transferCreditFailure() throws BSFParentException {
        Account account=new Account();
        account.setCreationDate(new Date());
        account.setCode("12345");
        account.setBalance(300.0);

        TransferReq req=new TransferReq();
        req.setFromAccountCode("12345");
        req.setToAccountCode("67890");
        req.setAmount(20.0);
        when(accountRepository.save(any())).thenThrow(RuntimeException.class);
        Map<TransferType, Account> transferResMap=accountService.transfer(req);
        assertTrue(transferResMap.size()>0);
    }

    @Test
    void transfer() throws BSFParentException {
        Account account=new Account();
        account.setCreationDate(new Date());
        account.setCode("12345");
        account.setBalance(500.0);

        TransferReq req=new TransferReq();
        req.setFromAccountCode("12345");
        req.setToAccountCode("67890");
        req.setAmount(20.0);
        when(accountRepository.getAccountByCode(any(String.class))).thenReturn(account);
        Map<TransferType, Account> transferResMap=accountService.transfer(req);
        assertTrue(transferResMap.size()>0);
    }

}