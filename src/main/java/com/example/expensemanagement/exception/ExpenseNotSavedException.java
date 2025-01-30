package com.example.expensemanagement.exception;

public class ExpenseNotSavedException extends RuntimeException{
    public ExpenseNotSavedException(String msg){
        super(msg);
    }
}
