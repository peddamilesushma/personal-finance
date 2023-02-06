package com.example.demo.personalfinance.services;

import com.example.demo.personalfinance.mapper.TransactionMapper;
import com.example.demo.personalfinance.mapper.UserMapper;
import com.example.demo.personalfinance.request.NewTransactionRequest;
import com.example.demo.personalfinance.response.NewTransactionResponse;


public class NewTransactionService {

    private TransactionMapper transactionMap;
    public NewTransactionService(TransactionMapper transactionMap){this.transactionMap=transactionMap;}

    public NewTransactionResponse AddTransaction( NewTransactionRequest details) {
        NewTransactionResponse responseBody = new NewTransactionResponse();
        UpdateCurrentAmountService service = new UpdateCurrentAmountService(transactionMap);
        NewTransactionRequest request = new NewTransactionRequest();
        try{
            transactionMap.AddTransactionDetails(details);
            request.setAmount(0);
            request.setCategory(details.getCategory());
            request.setSubcategory(details.getSubcategory());
            request.setUid(details.getUid());
            request.setType(details.getType());
            request.setDescription(details.getDescription());
            service.UpdateCurrentAmount(request,details);
            responseBody.setStatus(200);
            responseBody.setMessage("success");
        }
        catch (Exception e){
            responseBody.setStatus(206);
            responseBody.setMessage("failure");
        }
        return responseBody;
    }
}
