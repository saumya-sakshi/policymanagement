package com.example.policymanagement.controller;

import com.example.policymanagement.entity.PolicyRegistration;
import com.example.policymanagement.service.SearchPolicyService;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/api/v1.0/policy/")
@CrossOrigin
public class SearchPolicyController {

    @Autowired
    private SearchPolicyService service;


    @GetMapping("searches")
    @PreAuthorize("hasRole('User')")
    public List<PolicyRegistration> getAllPolicy(@RequestBody PolicyRegistration policy){

        log.info("Inside search Policy");
        return service.getAllPolicy(policy);


    }


}
