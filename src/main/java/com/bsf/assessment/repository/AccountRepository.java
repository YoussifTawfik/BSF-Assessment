package com.bsf.assessment.repository;

import com.bsf.assessment.entity.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends BSFBaseRepository<Account,Long> {

    @Query("SELECT ac FROM Account ac WHERE ac.code = :code")
    Account getAccountByCode(@Param("code") String code);
}
