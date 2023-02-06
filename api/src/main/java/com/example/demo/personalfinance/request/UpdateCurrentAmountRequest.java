package com.example.demo.personalfinance.request;

import lombok.Data;

@Data

public class UpdateCurrentAmountRequest {
    Integer currentAmount;
    String uid;
}
