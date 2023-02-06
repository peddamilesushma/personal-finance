package com.example.demo.personalfinance.services;

import com.example.demo.personalfinance.mapper.UserMapper;
import com.example.demo.personalfinance.model.AccountDetails;
import com.example.demo.personalfinance.request.LoginRequest;
import com.example.demo.personalfinance.response.LoginResponse;
import com.example.demo.personalfinance.utils.Hashing;

public class LoginService {

    private UserMapper userMap;
    public LoginService(UserMapper userMap){this.userMap=userMap;}
    public LoginResponse AccountLogin(LoginRequest details){
        Hashing hashing = new Hashing();
        LoginResponse response = new LoginResponse();
        try{
            AccountDetails loginDetails = userMap.AccountLogin(details.getEmail());
            if(hashing.hashingString(details.getPassword()).equals(loginDetails.getPassword())){
                response.setStatus(200);
                response.setUid(loginDetails.getUid());
            }
            else{
                response.setStatus(208);
                response.setUid(null);
            }
            System.out.println(response);
        }
        catch (Exception e){
            response.setStatus(207);
            response.setUid(null);
        }
        return response;
    }
}
