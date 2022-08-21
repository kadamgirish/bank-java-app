package com.bank.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Applicant {

    @Id
    @GeneratedValue
    @Column(name = "applicant_id")
    private Integer applicantId;

    @NotBlank(message = "First Name should not blank")
    private String firstName;

    @NotNull(message = "Last Name should not blank")
    private String lastName;

    @Email(message = "Please provide valid email id")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_account_id")
    private Account account;

}
