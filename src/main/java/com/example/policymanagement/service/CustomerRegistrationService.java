package com.example.policymanagement.service;


import com.example.policymanagement.entity.CustomerRegistration;
import com.example.policymanagement.repository.CustomerRegistrationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerRegistrationService {
    @Autowired
    private CustomerRegistrationRepository userRepository;

    public CustomerRegistration register(CustomerRegistration user) {
        log.info("Inside the register method of the customer Service");
        return userRepository.save(user);
    }


    public int login(CustomerRegistration user) throws Exception{
        try{CustomerRegistration customer =userRepository.findByEmail(user.getEmail());
        if(customer.getLastName().equals(user.getLastName())){
            String type= customer.getEmployerType();
            if(type.equalsIgnoreCase("CUSTOMER")) return 1;
            else if(type.equalsIgnoreCase("ADMIN")) return 2;
        }
        return 0;}
        catch(Exception e){
            throw new Exception("Invalid UserName or Password");

        }

    }
}
