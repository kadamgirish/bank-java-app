package com.bank.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue
    private Integer accountId;

    private Integer accountNumber;

    private String accountHolder;

    private Integer balance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_credit_facility_id")
    private CreditFacility creditFacility;
}
