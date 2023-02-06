package com.example.demo.personalfinance.request;

import lombok.Data;

@Data
public class GetTransactionRequest {
    String uid;
    Integer id;
}
