package com.example.expensemanagement.controller;


import com.example.expensemanagement.dto.ExceptionResponseDto;
import com.example.expensemanagement.dto.ExpenseResponseDto;
import com.example.expensemanagement.exception.ExpenseIdNotFound;
import com.example.expensemanagement.exception.ExpenseNotSavedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(ExpenseIdNotFound.class)
    public ResponseEntity<ExceptionResponseDto>  expenseIdNotFound(Exception exception){
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(exception.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exceptionResponseDto,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExpenseNotSavedException.class)
    public ResponseEntity<ExceptionResponseDto> expenseNotSaved(Exception exception){
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(exceptionResponseDto,HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
