package com.example.demo.personalfinance.request;

import lombok.Data;

@Data
public class DeleteTransactionRequest {
    String uid;
    Integer id;
    String type;
    String category;
    String subcategory;
    String description;
    Integer amount;
}
