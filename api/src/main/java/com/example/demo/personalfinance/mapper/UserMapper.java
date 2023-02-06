package com.example.demo.personalfinance.mapper;

import com.example.demo.personalfinance.model.AccountDetails;
import com.example.demo.personalfinance.model.UserDetails;
import com.example.demo.personalfinance.request.NewTransactionRequest;
import com.example.demo.personalfinance.request.NewUserRequest;
import com.example.demo.personalfinance.request.UpdateAccountRequest;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

     @Insert("insert into account_details(uid,email,password) values(#{uid},#{email},#{password})")
     void AddAccountDetails(AccountDetails accountDetails);
     @Select("SELECT * FROM account_details WHERE (email = #{email})")
     String checkEmail(String email);
     @Select("SELECT * FROM account_details WHERE (email = #{email})")
     AccountDetails AccountLogin(String email);
     @Insert("insert into user_details(uid,name,age,expenditureLimit,investmentLimit,salary,phoneNumber,occupation) values(#{uid},#{name},#{age},#{expenditureLimit},#{investmentLimit},#{salary},#{phoneNumber},#{occupation})")
     void AddUserDetails(NewUserRequest userDetails);
     @Update("update user_details set name=#{name},age=#{age},expenditureLimit=#{expenditureLimit},investmentLimit=#{investmentLimit},phoneNumber=#{phoneNumber},salary=#{salary},occupation=#{occupation} where uid=#{uid}")
     void UpdateUserDetails(UpdateAccountRequest updateAccountRequest);
     @Insert("insert into current_amount_details(uid,currentExpenditure,currentInvestment) values(#{uid},0,0)")
     void AddCurrentAmountDetails(String uid);
}
