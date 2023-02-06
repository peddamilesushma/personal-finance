package com.example.demo.personalfinance.model;
import lombok.Data;

@Data
public class UserDetails {
    String uid;
    String email;
    String name;
    Integer age;
    Integer expenditureLimit;
    Integer investmentLimit;
    String phoneNumber;
    String occupation;
    Integer salary;

}
