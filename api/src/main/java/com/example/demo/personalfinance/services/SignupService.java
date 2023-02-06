package com.example.demo.personalfinance.services;

import com.example.demo.personalfinance.mapper.UserMapper;
import com.example.demo.personalfinance.model.AccountDetails;
import com.example.demo.personalfinance.request.SignupRequest;
import com.example.demo.personalfinance.response.SignupResponse;
import com.example.demo.personalfinance.utils.Hashing;

import java.util.UUID;

public class SignupService {
    private UserMapper userMap;
    public SignupService(UserMapper userMap){this.userMap=userMap;}
    public SignupResponse createAccount(SignupRequest details) {
        SignupService service = new SignupService(userMap);
        SignupResponse responseBody = new SignupResponse();
        if(service.CheckingEmail(details.getEmail()) != null){
            responseBody.setUid(null);
            responseBody.setStatus(209);
            return responseBody;
        }
        String uniqueKey = UUID.randomUUID().toString();
        Hashing hashing = new Hashing();
        AccountDetails accountDetails = new AccountDetails();
        accountDetails.setEmail(details.getEmail());
        accountDetails.setUid(uniqueKey);
        accountDetails.setPassword(hashing.hashingString(details.getPassword()));
        try{
            userMap.AddAccountDetails(accountDetails);
            responseBody.setUid(uniqueKey);
            responseBody.setStatus(200);
        }
        catch (Exception e){
            responseBody.setUid(null);
            responseBody.setStatus(205);
        }
        return responseBody;
    }
    public String CheckingEmail(String email){
        return userMap.checkEmail(email);
    }
}
