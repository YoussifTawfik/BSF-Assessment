package com.bsf.assessment.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CLIENTS")
@Getter @Setter @NoArgsConstructor @ToString
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
}
