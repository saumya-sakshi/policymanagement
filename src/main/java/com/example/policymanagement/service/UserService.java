package com.example.policymanagement.service;

import com.example.policymanagement.entity.Role;
import com.example.policymanagement.entity.User;
import com.example.policymanagement.repository.RoleDao;
import com.example.policymanagement.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public User createNewUser(User user){
        Role role = roleDao.findById("user").get();
        Set<Role> roles= new HashSet<>();
        roles.add(role);
        user.setRole(roles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        return userDao.save(user);
    }
    public void initRolesAndUser(){
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin Role for Policy Management System");
        roleDao.save(adminRole);
        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("User Role for Policy Management System");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUserName("admin123");
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setUserPassword(getEncodedPassword("admin@123"));
        Set<Role> adminRoles = new HashSet<>();
        adminUser.setRole(adminRoles);
        adminRoles.add(adminRole);
        userDao.save(adminUser);
        User user = new User();
        user.setUserName("saumya123");
        user.setUserFirstName("saumya");
        user.setUserLastName("sakshi");
        user.setUserPassword(getEncodedPassword("saumya@123"));
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userDao.save(user);
    }
    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }
}
