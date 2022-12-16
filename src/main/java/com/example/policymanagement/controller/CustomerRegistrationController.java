package com.example.policymanagement.controller;

import com.example.policymanagement.entity.CustomerRegistration;
import com.example.policymanagement.service.CustomerRegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1.0/customer")
@CrossOrigin(allowedHeaders ="*",origins = "*")
public class CustomerRegistrationController {
    @Autowired
    private CustomerRegistrationService userService;

    @CrossOrigin(allowedHeaders ="*",origins = "*")
    @PostMapping("/register")
    public CustomerRegistration Register(@RequestBody CustomerRegistration user){
        log.info("Inside the register method of Customer Controller");
        return  userService.register(user);
    }
    @CrossOrigin(allowedHeaders ="*",origins = "*")
    @PostMapping("/login")

    public int login(@RequestBody CustomerRegistration user) throws Exception {
        log.info("Inside the login method of Customer Controller");
        return userService.login(user);
    }


}
