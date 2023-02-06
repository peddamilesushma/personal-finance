package com.example.demo.personalfinance.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class TransactionDetails {
    String uid;
    Integer id;
    String type;
    String category;
    String subcategory;
    String description;
    Integer amount;
    Timestamp createdAt;
    Timestamp editedAt;
}
