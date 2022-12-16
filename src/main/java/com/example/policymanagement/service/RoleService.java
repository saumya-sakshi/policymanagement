package com.example.policymanagement.service;

import com.example.policymanagement.entity.Role;
import com.example.policymanagement.repository.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role createNewRole(Role role){
       return roleDao.save(role);
    }
}
