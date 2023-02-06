package com.example.demo.personalfinance.services;

import com.example.demo.personalfinance.mapper.TransactionMapper;
import com.example.demo.personalfinance.model.TransactionDetails;
import com.example.demo.personalfinance.request.GetTransactionRequest;
import com.example.demo.personalfinance.request.NewTransactionRequest;
import com.example.demo.personalfinance.request.UpdateTransactionRequest;
import com.example.demo.personalfinance.response.UpdateTransactionResponse;

public class UpdateTransactionService {
    private TransactionMapper transactionMap;
    public UpdateTransactionService(TransactionMapper transactionMap){this.transactionMap=transactionMap;}

    public UpdateTransactionResponse UpdateTransaction(UpdateTransactionRequest details){
        GetTransactionRequest request = new GetTransactionRequest();
        UpdateTransactionResponse responseBody = new UpdateTransactionResponse();
        NewTransactionRequest oldTransaction = new NewTransactionRequest();
        NewTransactionRequest newTransaction = new NewTransactionRequest();
        UpdateCurrentAmountService service = new UpdateCurrentAmountService(transactionMap);
        try{
            request.setId(details.getId());
            request.setUid(details.getUid());
            TransactionDetails oldDetails = transactionMap.GetTransactionDetails(request);
            transactionMap.UpdateTransaction(details);
            newTransaction.setType(details.getType());
            newTransaction.setUid(details.getUid());
            newTransaction.setDescription(details.getDescription());
            newTransaction.setSubcategory(details.getSubcategory());
            newTransaction.setCategory(details.getCategory());
            newTransaction.setAmount(details.getAmount());
            oldTransaction.setAmount(oldDetails.getAmount());
            oldTransaction.setType(oldDetails.getType());
            oldTransaction.setUid(oldDetails.getUid());
            oldTransaction.setDescription(oldDetails.getDescription());
            oldTransaction.setSubcategory(oldDetails.getSubcategory());
            oldTransaction.setCategory(oldDetails.getCategory());
            service.UpdateCurrentAmountWhenTransactionEdit(oldTransaction,newTransaction);
            responseBody.setMessage("Success");
            responseBody.setStatus(200);
        }
        catch (Exception e){
            responseBody.setStatus(212);
            responseBody.setMessage("Failure");
        }
        return responseBody;
    }
}
