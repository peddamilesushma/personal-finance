package com.example.demo.personalfinance.request;

import lombok.Data;

@Data
public class NewUserRequest {
    String uid;
    String name;
    Integer age;
    Integer expenditureLimit;
    Integer investmentLimit;
    String phoneNumber;
    String occupation;
    Integer salary;
}
