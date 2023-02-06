package com.example.demo.personalfinance.controller;

import com.example.demo.personalfinance.request.LoginRequest;
import com.example.demo.personalfinance.request.SignupRequest;
import com.example.demo.personalfinance.response.LoginResponse;
import com.example.demo.personalfinance.response.SignupResponse;
import com.example.demo.personalfinance.services.LoginService;
import com.example.demo.personalfinance.services.SignupService;
import org.springframework.http.ResponseEntity;
import com.example.demo.personalfinance.mapper.UserMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private UserMapper userMap;
    public AuthController(UserMapper userMap){this.userMap=userMap;}
    @PostMapping("/signup")
    public ResponseEntity<SignupResponse> createAccount(@RequestBody SignupRequest details){
        SignupService service = new SignupService(userMap);
        SignupResponse responseBody= service.createAccount(details);
        if(responseBody.getStatus() == 205){
            return ResponseEntity.status(205).body(responseBody);
        }
        else if(responseBody.getStatus() == 209){
            return ResponseEntity.status(209).body(responseBody);
        }
        return ResponseEntity.status(200).body(responseBody);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse>loginAccount(@RequestBody LoginRequest details){
        LoginService service = new LoginService(userMap);
        LoginResponse responseBody = service.AccountLogin(details);
        if(responseBody.getStatus() == 207) {
            return ResponseEntity.status(207).body(responseBody);
        }
        else if(responseBody.getStatus() == 208) {
            return ResponseEntity.status(208).body(responseBody);
        }
        return ResponseEntity.status(200).body(responseBody);
    }



}
