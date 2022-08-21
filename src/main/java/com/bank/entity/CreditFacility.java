package com.bank.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class CreditFacility {

    @Id
    @GeneratedValue
    @Column(name = "credit_facility_id", unique = true)
    private Integer creditFacilityId;

    private String CreditFacility;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_credit_facility_loan_id", referencedColumnName = "credit_facility_id")
    private List<Loan> loanList;

}
