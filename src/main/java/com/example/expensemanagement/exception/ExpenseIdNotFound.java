package com.example.expensemanagement.exception;

public class ExpenseIdNotFound extends RuntimeException{
    public ExpenseIdNotFound(String msg){
        super(msg);
    }
}
