package com.bank.service;

import com.bank.entity.Loan;

import java.util.List;

public interface LoanService {

    List<Loan> getLoansByCreditFacilityId(Integer creditFacilityId);

    List<Loan> addNewLoan(Loan loan);

    Loan updateLoanDetails(Loan loan);

    boolean deleteLoan(Integer loanId);

    Loan creditLoanAmount(Integer loanId, Double loanAmount);
}
