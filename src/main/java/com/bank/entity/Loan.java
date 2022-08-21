package com.bank.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Loan {

    @Id
    @GeneratedValue
    private Integer loanId;

    @NotNull
    private String loanType;

    private Double loanAmount;

    private  Double loanBalance;

    @Column(name = "fk_credit_facility_loan_id")
    private Integer creditFacilityId;
}
