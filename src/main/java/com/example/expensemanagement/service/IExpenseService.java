package com.example.expensemanagement.service;

import com.example.expensemanagement.dto.ExpenseRequestDto;
import com.example.expensemanagement.models.Expense;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface IExpenseService {
    public Expense createExpense(@RequestBody ExpenseRequestDto expenseRequestDto);
    public List<Expense> getAllExpense();
    public Optional<Expense> getExpenseById(Long id);

}
