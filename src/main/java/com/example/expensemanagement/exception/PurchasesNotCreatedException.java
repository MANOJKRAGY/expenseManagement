package com.example.expensemanagement.exception;

public class PurchasesNotCreatedException extends RuntimeException{
    public PurchasesNotCreatedException(String msg){
        super(msg);
    }
}
