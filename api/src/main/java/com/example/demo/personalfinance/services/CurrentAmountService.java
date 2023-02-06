package com.example.demo.personalfinance.services;

import com.example.demo.personalfinance.mapper.UserMapper;
import com.example.demo.personalfinance.response.NewCurrentAmountResponse;

public class CurrentAmountService {
    private UserMapper userMap;
    public CurrentAmountService(UserMapper userMap){this.userMap=userMap;}

    public NewCurrentAmountResponse AddCurrentAmount(String uid){
        NewCurrentAmountResponse response = new NewCurrentAmountResponse();
        try{
            userMap.AddCurrentAmountDetails(uid);
            response.setStatus(200);
            response.setMessage("Success");
        }
        catch (Exception e){
            response.setMessage("Failure");
            response.setStatus(214);
        }
        return response;
    }

}
