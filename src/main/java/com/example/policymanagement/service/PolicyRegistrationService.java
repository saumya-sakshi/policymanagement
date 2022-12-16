package com.example.policymanagement.service;


import com.example.policymanagement.entity.PolicyRegistration;
import com.example.policymanagement.repository.PolicyRegistrationRepository;
import com.example.policymanagement.util.EmailUtil;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PolicyRegistrationService {
    @Autowired
    private PolicyRegistrationRepository policyRepository;

    @Autowired
    private EmailUtil emailUtil;

    public PolicyRegistration register(PolicyRegistration policy) {
        log.info("Inside the register method of Policy Service");

       // emailUtil.sendMail(policy.getId(),policy.getStartDate());
        return policyRepository.save(policy);
    }

    public List<PolicyRegistration> getAllPolicy() {
        return policyRepository.findAll();
    }

    public PolicyRegistration update(PolicyRegistration policy) {
        log.info("Inside the update method of service class");
        PolicyRegistration poc = policyRepository.findById(policy.getId()).get();

        poc.setPolicyName(policy.getPolicyName());
        poc.setPolicyType(policy.getPolicyType());
        poc.setYears(policy.getYears());
        poc.setInterest(policy.getInterest());
        poc.setTermAmount(policy.getTermAmount());
        poc.setStartDate(policy.getStartDate());
        poc.setInitialAmount(policy.getInitialAmount());
        poc.setTermsPerYear(policy.getTermsPerYear());
        poc.setUserType(policy.getUserType());
        poc.setCompanyName(policy.getCompanyName());
        return policyRepository.save(poc);
    }

    public void delete(String id){
        policyRepository.deleteById(id);
    }
}
