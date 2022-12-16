package com.example.policymanagement.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="CustomerRegistration")
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class CustomerRegistration {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private int ID;
        private String firstName;
        private String lastName;
        private Date dob;
        private String address;
        private Long contactNumber;

        private String email;
        private Long salary;

    public String getEmployerType() {
        return employerType;
    }

    public void setEmployerType(String employerType) {
        this.employerType = employerType;
    }

    private String panNumber;
        private String employerType;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public Date getDob() {
            return dob;
        }

        public void setDob(Date dob) {
            this.dob = dob;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Long getContactNumber() {
            return contactNumber;
        }

        public void setContactNumber(Long contactNumber) {
            this.contactNumber = contactNumber;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Long getSalary() {
            return salary;
        }

        public void setSalary(Long salary) {
            this.salary = salary;
        }

        public String getPanNumber() {
            return panNumber;
        }

        public void setPanNumber(String panNumber) {
            this.panNumber = panNumber;
        }
    }


