package com.example.demo.personalfinance.services;

import com.example.demo.personalfinance.mapper.TransactionMapper;
import com.example.demo.personalfinance.model.CurrentAmountDetails;
import com.example.demo.personalfinance.request.NewTransactionRequest;
import com.example.demo.personalfinance.request.UpdateCurrentAmountRequest;

public class UpdateCurrentAmountService {
    private TransactionMapper transactionMap;
    public UpdateCurrentAmountService(TransactionMapper transactionMap){this.transactionMap = transactionMap;}
    public void UpdateCurrentAmount(NewTransactionRequest oldTransaction, NewTransactionRequest newTransaction){
        UpdateCurrentAmountRequest request = new UpdateCurrentAmountRequest();
        CurrentAmountDetails details = transactionMap.GetCurrentAmountDetails(oldTransaction.getUid());
        if(oldTransaction.getCategory().equals("investment")){
            request.setCurrentAmount(details.getCurrentInvestment() + newTransaction.getAmount()-oldTransaction.getAmount());
            request.setUid(newTransaction.getUid());
            transactionMap.UpdateInvestment(request);
        }
        else{
            request.setCurrentAmount(details.getCurrentExpenditure() + newTransaction.getAmount()-oldTransaction.getAmount());
            request.setUid(newTransaction.getUid());
            transactionMap.UpdateExpenditure(request);
        }

    }
    public void UpdateCurrentAmountWhenTransactionEdit(NewTransactionRequest oldTransaction, NewTransactionRequest newTransaction){
        CurrentAmountDetails details = transactionMap.GetCurrentAmountDetails(oldTransaction.getUid());
        UpdateCurrentAmountRequest request = new UpdateCurrentAmountRequest();
        UpdateCurrentAmountService service = new UpdateCurrentAmountService(transactionMap);
        if(oldTransaction.getCategory().equals(newTransaction.getCategory())){
            service.UpdateCurrentAmount(oldTransaction,newTransaction);
        }
        else{
            if(newTransaction.getCategory().equals("investment")){
                request.setCurrentAmount(details.getCurrentInvestment()+ newTransaction.getAmount());
                request.setUid(newTransaction.getUid());

                transactionMap.UpdateInvestment(request);
                request.setCurrentAmount(details.getCurrentExpenditure()-oldTransaction.getAmount());
                transactionMap.UpdateExpenditure(request);
            }
            else{
                request.setCurrentAmount(details.getCurrentInvestment()-oldTransaction.getAmount());
                request.setUid(newTransaction.getUid());
                transactionMap.UpdateInvestment(request);
                request.setCurrentAmount(details.getCurrentExpenditure()+ newTransaction.getAmount());
                transactionMap.UpdateExpenditure(request);
            }
        }
    }
}
