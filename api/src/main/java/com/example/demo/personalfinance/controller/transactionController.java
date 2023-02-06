package com.example.demo.personalfinance.controller;

import com.example.demo.personalfinance.mapper.TransactionMapper;
import com.example.demo.personalfinance.request.DeleteTransactionRequest;
import com.example.demo.personalfinance.request.NewTransactionRequest;
import com.example.demo.personalfinance.request.UpdateTransactionRequest;
import com.example.demo.personalfinance.response.DeleteTransactionResponse;
import com.example.demo.personalfinance.response.NewTransactionResponse;
import com.example.demo.personalfinance.response.UpdateTransactionResponse;
import com.example.demo.personalfinance.services.DeleteTransactionService;
import com.example.demo.personalfinance.services.NewTransactionService;
import com.example.demo.personalfinance.services.UpdateTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class transactionController {
    private TransactionMapper transactionMap;
    public transactionController(TransactionMapper transactionMap){this.transactionMap=transactionMap;}

    @PostMapping("/transaction")
    public ResponseEntity<NewTransactionResponse> AddTransaction(@RequestBody NewTransactionRequest details){
        NewTransactionService service = new NewTransactionService(transactionMap);
        NewTransactionResponse responseBody = service.AddTransaction(details);
        if(responseBody.getStatus()==206){
            return ResponseEntity.status(206).body(responseBody);
        }
        return ResponseEntity.status(200).body(responseBody);

    }
    @DeleteMapping("/transaction")
    public ResponseEntity<DeleteTransactionResponse>DeleteTransaction(@RequestBody DeleteTransactionRequest details){
        DeleteTransactionService service = new DeleteTransactionService(transactionMap);
        DeleteTransactionResponse responseBody = service.DeleteTransaction(details);
        if(responseBody.getStatus()==211){
            return ResponseEntity.status(211).body(responseBody);
        }
        return ResponseEntity.status(200).body(responseBody);
    }

    @PutMapping("/transaction")
    public ResponseEntity<UpdateTransactionResponse>UpdateTransaction(@RequestBody UpdateTransactionRequest details){
        UpdateTransactionService service = new UpdateTransactionService(transactionMap);
        UpdateTransactionResponse response = service.UpdateTransaction(details);
        if(response.getStatus() == 212){
            return ResponseEntity.status(212).body(response);
        }
        else
            return ResponseEntity.status(200).body(response);
    }

}
