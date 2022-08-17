package com.bsf.assessment.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "ACCOUNTS")
@Getter
@Setter
@ToString
@Builder
@SequenceGenerator(name = "SEQ", sequenceName = "ACCOUNTS_SEQUENCE", allocationSize = 1)
public class Account extends BaseEntity {

    private Date creationDate;

    @NotNull
    private Double balance;

    @NotNull
    private String code;

}
