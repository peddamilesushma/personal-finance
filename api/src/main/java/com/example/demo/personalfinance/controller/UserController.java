package com.example.demo.personalfinance.controller;

import com.example.demo.personalfinance.mapper.UserMapper;
import com.example.demo.personalfinance.request.NewUserRequest;
import com.example.demo.personalfinance.request.UpdateAccountRequest;
import com.example.demo.personalfinance.response.NewCurrentAmountResponse;
import com.example.demo.personalfinance.response.NewUserResponse;
import com.example.demo.personalfinance.response.UpdateAccountResponse;
import com.example.demo.personalfinance.services.CurrentAmountService;
import com.example.demo.personalfinance.services.NewUserService;
import com.example.demo.personalfinance.services.UpdateAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserMapper userMap;
    public UserController(UserMapper userMap){this.userMap=userMap;}

    @PostMapping("/details")
    public ResponseEntity<NewUserResponse> AddUserDetails(@RequestBody NewUserRequest details){
        NewUserService service = new NewUserService(userMap);
        CurrentAmountService currentAmountService = new CurrentAmountService(userMap);
        NewCurrentAmountResponse currentAmountResponse = currentAmountService.AddCurrentAmount(details.getUid());
        NewUserResponse response = service.AddUserDetails(details);
        if(response.getStatus() == 210){
            return ResponseEntity.status(210).body(response);
        }
        return ResponseEntity.status(200).body(response);
    }

    @PutMapping("/details")
    public ResponseEntity<UpdateAccountResponse> UpdateAccountDetails(@RequestBody UpdateAccountRequest details){
        UpdateAccountService service = new UpdateAccountService(userMap);
        UpdateAccountResponse response = service.UpdateAccount(details);
        if(response.getStatus() == 213){
            return ResponseEntity.status(213).body(response);
        }
        return ResponseEntity.status(200).body(response);
    }
}
