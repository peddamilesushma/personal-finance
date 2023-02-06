package com.example.demo.personalfinance.request;

import lombok.Data;

@Data
public class UpdateTransactionRequest {
    Integer id;
    String uid;
    String type;
    String category;
    String subcategory;
    String description;
    Integer amount;
}
