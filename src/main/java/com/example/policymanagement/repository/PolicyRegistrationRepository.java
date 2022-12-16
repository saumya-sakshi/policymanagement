package com.example.policymanagement.repository;

import com.example.policymanagement.entity.PolicyRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRegistrationRepository extends JpaRepository<PolicyRegistration,String> {
}
