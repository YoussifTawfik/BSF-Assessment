package com.bsf.assessment.repository;

import com.bsf.assessment.entity.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends BSFBaseRepository<Account,Long> {

    Account getAccountByCode( String code);
}
