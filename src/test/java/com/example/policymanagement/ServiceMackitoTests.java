package com.example.policymanagement;


import com.example.policymanagement.entity.PolicyRegistration;
import com.example.policymanagement.repository.PolicyRegistrationRepository;
import com.example.policymanagement.repository.SearchPolicyRepository;
import com.example.policymanagement.service.PolicyRegistrationService;
import com.example.policymanagement.service.SearchPolicyService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(classes={ServiceMackitoTests.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServiceMackitoTests {

    //by mocking the data
    @Mock
    PolicyRegistrationRepository policyRepository;

    @Mock
    SearchPolicyRepository searchPolicyRepository;

    public List<PolicyRegistration> myPolicies;
    @InjectMocks
    PolicyRegistrationService policyRegistrationService;

    @InjectMocks
    SearchPolicyService searchPolicyService;



    @Test
    @Order(1)
    public void test_getAllPolicy(){
        List<PolicyRegistration> myPolicies=new ArrayList<>();
        Date d = new Date(2022,8,16);
        Date d2 = new Date(2021,9,9);
        myPolicies.add(new PolicyRegistration("cp-2022-09","New Policy",d,8,"All india company",897d,"Child plans","Parent",2,89764d,9d));
        myPolicies.add(new PolicyRegistration("vi-2021-06"," Policy2",d2,4," Abc company",786d,"Vehicle Insurance","Parent",3,76567d,7.8));
        when(policyRepository.findAll()).thenReturn(myPolicies);// Mocking Statement
        assertEquals(2, policyRegistrationService.getAllPolicy().size());
    }

    @Test
    @Order(3)
    public void test_delete(){
        Date d2 = new Date(2021,9,9);
        PolicyRegistration policy =new PolicyRegistration("Rp-2021-06"," Policy3",d2,4," def company",567d,"Retirement Plans","Parent",1,56473d,8.6);
        String id = "Rp-2021-06";

        policyRegistrationService.delete(id);
        verify(policyRepository,times(1)).deleteById(id); //Mocking
    }
    @Test
     @Order(2)
    public  void test_register(){
        Date d2 = new Date(2021,9,9);
     PolicyRegistration policy =new PolicyRegistration("Rp-2021-06"," Policy3",d2,4," def company",567d,"Retirement Plans","Parent",1,56473d,8.6);
     when(policyRepository.save(policy)).thenReturn(policy);
     assertEquals(policy,policyRegistrationService.register(policy));
    }

//    @Test
//    @Order(3)
//    public  void test_update(){
//        Date d2 = new Date(2021,9,9);
//        PolicyRegistration policy =new PolicyRegistration("Rp-2021-06"," Policy3",d2,4," def company",567d,"Retirement Plans","Parent",1,56473d,8.6);
//        when(policyRepository.save(policy)).thenReturn(policy);
//        assertEquals(policy,policyRegistrationService.update(policy));
//    }
//@Test
//@Order(4)
//public  void searchgetAll(){
//    List<PolicyRegistration> myPolicies=new ArrayList<>();
//    Date d = new Date(2022,8,16);
//    Date d2 = new Date(2021,9,9);
//    myPolicies.add(new PolicyRegistration("cp-2022-09","New Policy",d,8,"All india company",897d,"Child plans","Parent",2,89764d,9d));
//    myPolicies.add(new PolicyRegistration("vi-2021-06"," Policy2",d2,4," Abc company",786d,"Vehicle Insurance","Parent",3,76567d,7.8));
//
//    Date d3 = new Date(2021,9,9);
//    myPolicies.add(new PolicyRegistration("Rp-2021-06"," Policy3",d3,4," def company",567d,"Retirement Plans","Parent",1,56473d,8.6));
//    PolicyRegistration policy =new PolicyRegistration("Rp-2021-06"," Policy3",d3,4," def company",567d,"Retirement Plans","Parent",1,56473d,8.6);
//    when(searchPolicyRepository.findByPolicyType(policy.getPolicyType())).thenReturn(myPolicies);
//    when(searchPolicyRepository.findByCompanyName(policy.getCompanyName())).thenReturn(myPolicies);
//    when(searchPolicyRepository.findByYears(policy.getYears())).thenReturn(myPolicies);
//    when(searchPolicyRepository.findByPolicyName(policy.getPolicyName())).thenReturn(myPolicies);
//    when(searchPolicyRepository.findById(policy.getId()).get()).thenReturn(policy);
//
//    assertEquals(policy,searchPolicyService.getAllPolicy(policy));
//}


}
