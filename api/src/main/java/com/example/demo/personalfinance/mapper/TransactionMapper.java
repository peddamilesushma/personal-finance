package com.example.demo.personalfinance.mapper;

import com.example.demo.personalfinance.model.CurrentAmountDetails;
import com.example.demo.personalfinance.model.TransactionDetails;
import com.example.demo.personalfinance.request.*;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TransactionMapper {
    @Insert("insert into transaction_details(uid,type,category,subcategory,description,amount) values(#{uid},#{type},#{category},#{subcategory},#{description},#{amount})")
    void AddTransactionDetails(NewTransactionRequest transactionDetails);
    @Delete("delete from transaction_details where id=#{id} and uid = #{uid}")
    void DeleteTransaction(DeleteTransactionRequest transactionRequest);

    @Update("update transaction_details set category=#{category},subcategory=#{subcategory},type=#{type},amount=#{amount},description=#{description} where id=#{id} and uid=#{uid}")
    void UpdateTransaction(UpdateTransactionRequest transactionRequest);

    @Update("update current_amount_details set currentInvestment=#{currentAmount} where uid=#{uid}")
    void UpdateInvestment(UpdateCurrentAmountRequest currentAmountRequest);

    @Select("select * from current_amount_details where uid=#{uid}")
    CurrentAmountDetails GetCurrentAmountDetails(String uid);

    @Select("select * from transaction_details where uid=#{uid} and id=#{id}")
     TransactionDetails GetTransactionDetails(GetTransactionRequest details);

    @Update("update current_amount_details set currentExpenditure=#{currentAmount} where uid=#{uid}")
    void UpdateExpenditure(UpdateCurrentAmountRequest currentAmountRequest);

}
