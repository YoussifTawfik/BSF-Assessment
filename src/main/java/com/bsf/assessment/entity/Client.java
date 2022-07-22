package com.bsf.assessment.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "CLIENTS")
@Getter @Setter @NoArgsConstructor @ToString
@SequenceGenerator(name = "SEQ", sequenceName = "CLIENTS_SEQUENCE", allocationSize = 1)
public class Client extends BaseEntity {

//    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "PHONE")
    private String phone;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<Account> accounts;
}
