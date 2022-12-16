package com.example.policymanagement.controller;

import com.example.policymanagement.entity.PolicyRegistration;
import com.example.policymanagement.service.PolicyRegistrationService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/policy")
@CrossOrigin
@Slf4j
public class PolicyRegistrationController {

    @Autowired
    private PolicyRegistrationService policyService;

    @CrossOrigin()
    @PostMapping("/register")
    @PreAuthorize("hasRole('Admin')")
    public PolicyRegistration register(@RequestBody PolicyRegistration policy) {
        log.info("Inside the register method of Policy Controller");
        return policyService.register(policy);
    }

    @CrossOrigin
    @GetMapping("getall")

    public List<PolicyRegistration> getAllPolicy() {
        return policyService.getAllPolicy();
    }

    @PutMapping("update")
    @PreAuthorize("hasRole('Admin')")
    public PolicyRegistration update(@RequestBody PolicyRegistration policy) {
        log.info("Inside the update method of Policy Controller");
        return policyService.update(policy);

    }
    @DeleteMapping("delete")
    @PreAuthorize("hasRole('Admin')")
    public void delete(@RequestParam String id){

        log.info("Inside the delete method of Policy Controller");
        policyService.delete(id);
    }


}
