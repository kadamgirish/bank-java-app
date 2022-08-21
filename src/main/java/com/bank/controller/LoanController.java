package com.bank.controller;

import com.bank.entity.Loan;
import com.bank.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping("/{creditFacilityId}")
    public List<Loan> getLoans(@PathVariable Integer creditFacilityId) {
        return loanService.getLoansByCreditFacilityId(creditFacilityId);
    }

    @PostMapping
    public List<Loan> addNewLoan(@RequestBody @Valid Loan loan) {
        return loanService.addNewLoan(loan);
    }

    @PutMapping
    public Loan updateLoanDetails(@RequestBody @Valid Loan loan) {
        return loanService.updateLoanDetails(loan);
    }

    @PutMapping("/{loanId}/{loanAmount}")
    public Loan creditLoanAmount(@PathVariable @NotNull Integer loanId, @PathVariable @NotNull Double loanAmount) {
        return loanService.creditLoanAmount(loanId, loanAmount);
    }

    @DeleteMapping("/{loanId}")
    public Boolean deleteLoan(@PathVariable Integer loanId) {
        return loanService.deleteLoan(loanId);
    }

}
