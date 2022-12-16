package com.example.policymanagement.repository;


import com.example.policymanagement.entity.CustomerRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRegistrationRepository extends JpaRepository<CustomerRegistration,String> {
    CustomerRegistration findByEmail(String email);
}
