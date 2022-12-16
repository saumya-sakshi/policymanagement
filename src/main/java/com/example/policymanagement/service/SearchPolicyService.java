package com.example.policymanagement.service;

import com.example.policymanagement.entity.PolicyRegistration;
import com.example.policymanagement.repository.SearchPolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchPolicyService {
    @Autowired
    private SearchPolicyRepository searchPolicyRepository;
    public List<PolicyRegistration> getAllPolicy(PolicyRegistration search)
    {
        //System.out.println(search.getYears());
        List<PolicyRegistration> policy = new ArrayList<PolicyRegistration>();
        if(search.getPolicyName()!=null)
        {
            searchPolicyRepository.findByPolicyName(search.getPolicyName()).forEach(policyName -> policy.add(policyName));
        }
        else if(search.getId()!=null)
        {
           policy.add(searchPolicyRepository.findById(search.getId()).get());
        }
        else if(search.getPolicyType()!=null)
        {
            searchPolicyRepository.findByPolicyType(search.getPolicyType()).forEach(policyType -> policy.add(policyType));
        }
        else if(search.getYears()!=null)
        {
            searchPolicyRepository.findByYears(search.getYears()).forEach(years -> policy.add(years));
          //  searchPolicyRepository.findByYearsAndPolicyName(search.getYears(),search.getPolicyName()).forEach(years -> policy.add(years));

        }
        else if(search.getCompanyName()!=null)
        {
            searchPolicyRepository.findByCompanyName(search.getCompanyName()).forEach(companyName -> policy.add(companyName));
        }
        else{
            System.out.println("Data is not coming");
        }
        return policy;
    }


    public List<PolicyRegistration> search(String keyword){
        List<PolicyRegistration> policy = new ArrayList<PolicyRegistration>();
        policy.add(searchPolicyRepository.findById(keyword).get());
        return policy;
    }



}
