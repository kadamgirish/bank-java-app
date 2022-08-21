package com.bank.service;

import com.bank.entity.Applicant;

import java.util.List;

public interface ApplicantService {

    List<Applicant> gatAllApplicant();

    Applicant getApplicantById(Integer applicantId);

    Applicant createApplicant(Applicant applicant);

    Applicant updateApplicant(Applicant applicant);

    boolean deleteApplicant(Integer applicantId);
}
