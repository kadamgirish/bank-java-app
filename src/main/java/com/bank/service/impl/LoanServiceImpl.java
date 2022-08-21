package com.bank.service.impl;

import com.bank.entity.Loan;
import com.bank.repository.LoanRepository;
import com.bank.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;
    @Override
    public List<Loan> getLoansByCreditFacilityId(Integer creditFacilityId) {
        return loanRepository.findByCreditFacilityId(creditFacilityId);
    }

    @Override
    public List<Loan> addNewLoan(Loan loan) {
        loanRepository.save(loan);
        // TODO proper id mapping in entity relations
        return loanRepository.findByCreditFacilityId(loan.getCreditFacilityId());
    }

    @Override
    public Loan updateLoanDetails(Loan loan) {
        if(loanRepository.existsById(loan.getLoanId()))
            return loanRepository.save(loan);
        return null; // TODO throw error
    }

    @Override
    public boolean deleteLoan(Integer loanId) {
        if(loanRepository.existsById(loanId)){
            loanRepository.deleteById(loanId);
            return true;
        }
        return false;
    }

    @Override
    public Loan creditLoanAmount(Integer loanId, Double loanAmount) {
        Loan loan = loanRepository.findById(loanId).get();
        if(loan != null) {
            Double amount = loan.getLoanBalance() - loanAmount;
            loan.setLoanBalance(amount);
            loan = loanRepository.save(loan);
        }
        return loan;
    }
}
