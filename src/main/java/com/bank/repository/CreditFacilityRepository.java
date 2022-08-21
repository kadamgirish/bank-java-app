package com.bank.repository;

import com.bank.entity.CreditFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditFacilityRepository extends JpaRepository<CreditFacility, Integer> {
}
