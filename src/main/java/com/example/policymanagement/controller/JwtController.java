package com.example.policymanagement.controller;

import com.example.policymanagement.entity.JwtRequest;
import com.example.policymanagement.entity.JwtResponse;
import com.example.policymanagement.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @PostMapping("/authenticate")
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }

    @GetMapping("/welcome")
        public String welcome(){
            return "Welcome";

    }
}
