package com.example.expensemanagement.controller;

import com.example.expensemanagement.dto.ExpenseRequestDto;
import com.example.expensemanagement.dto.ExpenseResponseDto;
import com.example.expensemanagement.exception.ExpenseIdNotFound;
import com.example.expensemanagement.exception.ExpenseNotSavedException;
import com.example.expensemanagement.models.BaseLocation;
import com.example.expensemanagement.models.Expense;
import com.example.expensemanagement.models.ExpenseCategory;
import com.example.expensemanagement.service.IExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private IExpenseService expenseService;

    @PostMapping
    public ResponseEntity<ExpenseResponseDto> createExpense(@RequestBody  ExpenseRequestDto expenseRequestDto){
         try{
             Expense expense = expenseService.createExpense(expenseRequestDto);
             return new ResponseEntity<>(toDto(expense), HttpStatus.CREATED);
         }catch (Exception exception){
             throw new ExpenseNotSavedException("Expense not saved");
         }
    }
    @GetMapping("/{id}")
    public ResponseEntity<ExpenseResponseDto> getExpense(@PathVariable Long id){
            Optional<Expense> expense = expenseService.getExpenseById(id);
            if(expense.isEmpty()){
                throw new ExpenseIdNotFound("Expense Id is not found");
            }
            return new ResponseEntity<>(toDto(expense.get()),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ExpenseResponseDto>> getAllExpenses(){
        List<Expense> expenseList =  expenseService.getAllExpense();
        List<ExpenseResponseDto> expenseResponseDtoList =  new ArrayList<>();
        for(Expense expense : expenseList){
            expenseResponseDtoList.add(toDto(expense));
        }
        return new ResponseEntity<>(expenseResponseDtoList,HttpStatus.OK);
    }

    private ExpenseResponseDto toDto(Expense expense){
        ExpenseResponseDto expenseResponseDto = new ExpenseResponseDto();
        expenseResponseDto.setId(expense.getId());
        expenseResponseDto.setExpensePurpose(expense.getExpensepurpose());
        expenseResponseDto.setExpenseCode(expense.getExpenseCode());
        expenseResponseDto.setEmployeeName(expense.getEmployeeName());
        expenseResponseDto.setEmployeeId(expense.getEmployeeId());
        expenseResponseDto.setBaseLocation(String.valueOf(expense.getBaseLocation()));
        expenseResponseDto.setExpensePeriod(expense.getExpensePeriod());
        expenseResponseDto.setExpenseStartDate(expense.getExpenseStartDate());
        expenseResponseDto.setExpenseEndDate(expense.getExpenseEndDate());
        expenseResponseDto.setExpenseSubmissionDate(expense.getExpenseSubmissionDate());
        expenseResponseDto.setReportingManagerId(expense.getReportingManagerId());
        expenseResponseDto.setProjectId(expense.getProjectId());
        long expenseCategoryId = expense.getExpenseCategory().getId();
        expenseResponseDto.setExpenseCategoryId(expenseCategoryId);
        return expenseResponseDto;
    }


}
