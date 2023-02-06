package com.example.demo.personalfinance.services;

import com.example.demo.personalfinance.mapper.UserMapper;
import com.example.demo.personalfinance.request.NewUserRequest;
import com.example.demo.personalfinance.response.NewUserResponse;
import org.springframework.http.ResponseEntity;

public class NewUserService {
    private UserMapper userMap;
    public NewUserService(UserMapper userMap){this.userMap=userMap;}
    public NewUserResponse AddUserDetails(NewUserRequest details){
        NewUserResponse response = new NewUserResponse();
        try{
            userMap.AddUserDetails(details);
            response.setStatus(200);
            response.setMessage("Success");
        }
        catch (Exception e){
            response.setMessage("Failure");
            response.setStatus(210);
        }
        return response;
    }

}
