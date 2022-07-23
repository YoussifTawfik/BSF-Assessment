package com.bsf.assessment.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "ACCOUNTS")
@Getter
@Setter
@NoArgsConstructor
@ToString
@SequenceGenerator(name = "SEQ", sequenceName = "ACCOUNTS_SEQUENCE", allocationSize = 1)
public class Account extends BaseEntity {

    private Date creationDate;

    @NotNull
    private Double balance;

    @NotNull
    private String code;

}
