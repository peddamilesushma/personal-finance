package com.example.demo.personalfinance.services;

import com.example.demo.personalfinance.mapper.TransactionMapper;
import com.example.demo.personalfinance.model.TransactionDetails;
import com.example.demo.personalfinance.request.DeleteTransactionRequest;
import com.example.demo.personalfinance.request.NewTransactionRequest;
import com.example.demo.personalfinance.response.DeleteTransactionResponse;

public class DeleteTransactionService {
    private TransactionMapper transactionMap;

    public DeleteTransactionService(TransactionMapper transactionMap){this.transactionMap=transactionMap;}

    public DeleteTransactionResponse DeleteTransaction(DeleteTransactionRequest details){
        DeleteTransactionResponse response = new DeleteTransactionResponse();
        UpdateCurrentAmountService service = new UpdateCurrentAmountService(transactionMap);
        NewTransactionRequest requestNew = new NewTransactionRequest();
        NewTransactionRequest requestOld = new NewTransactionRequest();
        try{
            transactionMap.DeleteTransaction(details);
            requestOld.setAmount(details.getAmount());
            requestOld.setCategory(details.getCategory());
            requestOld.setSubcategory(details.getSubcategory());
            requestOld.setDescription(details.getDescription());
            requestOld.setUid(details.getUid());
            requestOld.setType(details.getType());
            requestNew.setAmount(0);
            requestNew.setCategory(details.getCategory());
            requestNew.setSubcategory(details.getSubcategory());
            requestNew.setUid(details.getUid());
            requestNew.setType(details.getType());
            requestNew.setDescription(details.getDescription());
            service.UpdateCurrentAmount(requestOld,requestNew);
            response.setStatus(200);
            response.setMessage("Success");
        }
        catch (Exception e){
            response.setStatus(211);
            response.setMessage("Failure");
        }
        return response;
    }

}
