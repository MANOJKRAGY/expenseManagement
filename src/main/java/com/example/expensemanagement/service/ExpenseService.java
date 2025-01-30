package com.example.expensemanagement.service;

import com.example.expensemanagement.dto.ExpenseRequestDto;
import com.example.expensemanagement.models.Expense;
import com.example.expensemanagement.models.ExpenseCategory;
import com.example.expensemanagement.repository.ExpenseCategoryRepository;
import com.example.expensemanagement.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService implements IExpenseService{


    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private ExpenseCategoryRepository expenseCategoryRepository;

    @Override
    public Expense createExpense(ExpenseRequestDto expenseRequestDto) {
        Expense expense = new Expense();
        expense.setExpenseName(expenseRequestDto.getExpenseName());
        expense.setDescription(expenseRequestDto.getDescription());
        expense.setUserId(expenseRequestDto.getUserId());
        ExpenseCategory expenseCategory = expenseCategoryRepository.findById(expenseRequestDto.getExpenseCategoryId()).get();
        expense.setExpenseCategory(expenseCategory);
        return expenseRepository.save(expense);
    }

    @Override
    public List<Expense> getAllExpense() {
        return  expenseRepository.findAll();
    }

    @Override
    public Optional<Expense> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }
}
