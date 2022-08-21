package com.bank.service.impl;

import com.bank.entity.Applicant;
import com.bank.repository.ApplicantRepository;
import com.bank.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;
    @Override
    public List<Applicant> gatAllApplicant() {
        return applicantRepository.findAll();
    }

    @Override
    public Applicant getApplicantById(Integer applicantId) {
        //TODO throw error if applicant not available
        return applicantRepository.findById(applicantId).get();
    }

    @Override
    public Applicant createApplicant(Applicant applicant) {
        return applicantRepository.save(applicant);
    }

    @Override
    public Applicant updateApplicant(Applicant applicant) {
        //TODO throw error if applicant not available
        return applicantRepository.save(applicant);
    }

    @Override
    public boolean deleteApplicant(Integer applicantId) {
        //TODO throw error if applicant not available
        if(applicantRepository.existsById(applicantId)) {
            applicantRepository.deleteById(applicantId);
            return true;
        }
        return false;
    }
}
