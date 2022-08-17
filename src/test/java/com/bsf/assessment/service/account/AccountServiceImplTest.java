package com.bsf.assessment.service.account;

import com.bsf.assessment.entity.Account;
import com.bsf.assessment.enums.TransferType;
import com.bsf.assessment.exception.AccountNotFoundException;
import com.bsf.assessment.exception.BSFParentException;
import com.bsf.assessment.exception.InsufficientBalanceException;
import com.bsf.assessment.exception.InvalidParameterException;
import com.bsf.assessment.repository.AccountRepository;
import com.bsf.assessment.request.TransferReq;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
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
    @InjectMocks
    private AccountServiceImpl accountService;
    private Account account;

    @BeforeEach
    void setUp() {
        account=Account.builder()
                .code("12345")
                .creationDate(new Date())
                .balance(2000.0)
                .build();
    }


    @Test
    public void givenCode_whenGetAccountByCode_thenReturnAccount() throws BSFParentException {

        // given
        BDDMockito.given(accountRepository.getAccountByCode(account.getCode())).willReturn(account);
        // when
        Account retrievedAccount=accountService.getAccountByCode(account.getCode());
        // then
        org.assertj.core.api.Assertions.assertThat(retrievedAccount).isNotNull();
    }

    @Test
    public void givenNullCode_whenGetAccountByCode_thenThrowsException(){

        // given

        // when
        Assertions.assertThrows(InvalidParameterException.class, ()-> accountService.getAccountByCode(null));
        // then
        Mockito.verify(accountRepository,never()).getAccountByCode(Mockito.anyString());
    }

    @Test
    public void givenCode_whenGetAccountByCode_thenThrowsNotFoundException(){

        // given
        BDDMockito.given(accountRepository.getAccountByCode(account.getCode())).willReturn(null);
        // when
        Assertions.assertThrows(AccountNotFoundException.class, ()-> accountService.getAccountByCode(account.getCode()));
        // then

    }

    @Test
    public void givenAccountAndAmount_whenDebit_thenReduceBalance() throws BSFParentException {

        // given
        BDDMockito.given(accountRepository.save(account)).willReturn(account);
        // when
        accountService.debit(account,50.0);
        // then
        Mockito.verify(accountRepository,Mockito.times(1)).save(Mockito.any(Account.class));

    }

    @Test
    public void givenAccountAndLessAmount_whenDebit_thenThrowsInsufficientBalanceException() throws BSFParentException {

        // given

        // when
        Assertions.assertThrows(InsufficientBalanceException.class,()-> accountService.debit(account,5000.0));
        // then
        Mockito.verify(accountRepository,never()).save(Mockito.any(Account.class));
    }

    @Test
    public void givenTransferReq_whenTransfer_thenMapResponse() throws BSFParentException {

        // given
        TransferReq transferReq=new TransferReq();
        transferReq.setFromAccountCode("12345");
        transferReq.setToAccountCode("98765");
        transferReq.setAmount(100.0);
        BDDMockito.given(accountRepository.getAccountByCode(Mockito.anyString())).willReturn(account);
        BDDMockito.given(accountRepository.save(account)).willReturn(account);
        // when
        Map<TransferType, Account> transferMap=accountService.transfer(transferReq);
        // then
        org.assertj.core.api.Assertions.assertThat(transferMap).isNotNull();
        org.assertj.core.api.Assertions.assertThat(transferMap).isNotEmpty();
    }


}