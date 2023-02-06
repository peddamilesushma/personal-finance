package com.example.demo.personalfinance.services;

import com.example.demo.personalfinance.mapper.UserMapper;
import com.example.demo.personalfinance.request.UpdateAccountRequest;
import com.example.demo.personalfinance.response.UpdateAccountResponse;

public class UpdateAccountService {
    private UserMapper userMap;
    public UpdateAccountService(UserMapper userMap){this.userMap = userMap;}

    public UpdateAccountResponse UpdateAccount(UpdateAccountRequest details){
        UpdateAccountResponse response = new UpdateAccountResponse();
        try{
            userMap.UpdateUserDetails(details);
            response.setMessage("Success");
            response.setStatus(200);
        }
        catch (Exception e){
            response.setStatus(213);
            response.setMessage("Failure");
        }
        return response;
    }
}
