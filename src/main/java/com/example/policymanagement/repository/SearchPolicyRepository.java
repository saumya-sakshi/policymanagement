package com.example.policymanagement.repository;

import com.example.policymanagement.entity.PolicyRegistration;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchPolicyRepository extends JpaRepository<PolicyRegistration,String> {
    List<PolicyRegistration> findByYears(int years);
    List<PolicyRegistration> findByPolicyName(String policyName);
    List<PolicyRegistration> findByPolicyType(String policyType);
    List<PolicyRegistration> findByCompanyName(String companyName);

    List<PolicyRegistration> findByYearsAndPolicyName(int years,String policyName);
}
