package com.bank.controller;

import com.bank.entity.Account;
import com.bank.entity.Applicant;
import com.bank.entity.CreditFacility;
import com.bank.entity.Loan;
import com.bank.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @GetMapping
    public List<Applicant> getAllApplicant(){
        return applicantService.gatAllApplicant();
    }

//    TODO test method need to remove
    @GetMapping("/test")
    public Applicant getApplicant() {
        Applicant applicant = new Applicant();
        Account account = new Account();
        CreditFacility cf = new CreditFacility();
        Loan loan = new Loan();
        ArrayList<Loan> al = new ArrayList<>();
        al.add(loan);
        cf.setLoanList(al);
        account.setCreditFacility(cf);
        applicant.setAccount(account);
        return applicant;
    }


    @PostMapping
    public Applicant createNewApplicant(@RequestBody @Valid Applicant applicant) {
        return applicantService.createApplicant(applicant);
    }

    @PutMapping
    public Applicant updateApplicant(@RequestBody @Valid Applicant applicant) {
        if(applicant.getApplicantId() == null) {
            return null;// TODO should throw error
        }
        return applicantService.updateApplicant(applicant);
    }

    @DeleteMapping("/{applicantId}")
    public Boolean deleteApplicant(@PathVariable Integer applicantId) {
        return applicantService.deleteApplicant(applicantId);
    }
}
