package com.example.policymanagement;

import com.example.policymanagement.entity.CustomerRegistration;
import com.example.policymanagement.repository.CustomerRegistrationRepository;
import com.example.policymanagement.service.CustomerRegistrationService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
@SpringBootTest
public class CustomerRegistrationTests {
    @Mock
    private CustomerRegistrationRepository repository;

    @InjectMocks
    CustomerRegistrationService service;



    @Test
    @Order(1)
    void testCreateCustomer() throws ParseException {
        CustomerRegistration customer = new CustomerRegistration();
        customer.setFirstName("Saumya");
        customer.setLastName("Sakshi");
        customer.setAddress("Patna");
        customer.setContactNumber(9798898990l);
        customer.setEmployerType("Admin");
        customer.setPanNumber("QWERT0987U");
        customer.setEmail("sakshi@gmail.com");
        customer.setSalary(89798l);
        Date d2 = new Date(2000,11,9);
        customer.setDob(d2);


        when(repository.save(customer)).thenReturn(customer);
        assertEquals(customer,service.register(customer));
        System.out.println("Customer data saved!");

    }







}

