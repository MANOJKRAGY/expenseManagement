package com.example.expensemanagement.controller;

import com.example.expensemanagement.dto.ExpenseCategoryRequestDto;
import com.example.expensemanagement.dto.ExpenseCategoryResponseDto;
import com.example.expensemanagement.models.ExpenseCategory;
import com.example.expensemanagement.repository.ExpenseCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/expensecategory")
public class ExpenseCategoryController {

    @Autowired
    private ExpenseCategoryRepository expenseCategoryRepository;

    @PostMapping
    public ResponseEntity<ExpenseCategoryResponseDto> creatExpenseCategory(@RequestBody ExpenseCategoryRequestDto requestDto){
        ExpenseCategory expenseCategory = new ExpenseCategory();
        expenseCategory.setName(requestDto.getName());
        expenseCategory.setCode(requestDto.getCode());
        ExpenseCategory expenseCategory1 = expenseCategoryRepository.save(expenseCategory);
        ExpenseCategoryResponseDto responseDto = new ExpenseCategoryResponseDto();
        responseDto.setCode(expenseCategory1.getCode());
        responseDto.setName(expenseCategory1.getName());
        responseDto.setId(expenseCategory1.getId());
        return new ResponseEntity<>(responseDto , HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<ExpenseCategoryResponseDto>> getAllExpenseCategory(){
        List<ExpenseCategory> expenseCategoryList = expenseCategoryRepository.findAll();
        List<ExpenseCategoryResponseDto> returnList = new ArrayList<>();
        for(ExpenseCategory e : expenseCategoryList){
            returnList.add(toDto(e));
        }
        return new ResponseEntity<>(returnList,HttpStatus.OK);
    }
    private ExpenseCategoryResponseDto toDto(ExpenseCategory expenseCategory){
        ExpenseCategoryResponseDto responseDto = new ExpenseCategoryResponseDto();
        responseDto.setId(expenseCategory.getId());
        responseDto.setName(expenseCategory.getName());
        responseDto.setCode(expenseCategory.getCode());
        return responseDto;
    }

}
