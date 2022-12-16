package com.example.policymanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name="PolicyRegistration")
@AllArgsConstructor
@NoArgsConstructor
@Data


public class PolicyRegistration {
    @Id
    private String id;
    private String policyName;
    private Date startDate;
    private Integer years;
    private String companyName;
    private Double initialAmount;
    private String policyType;
    private String userType;
    private Integer termsPerYear;
    private Double termAmount;
    private Double interest;
}
