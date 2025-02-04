package com.example.expensemanagement.repository;

import com.example.expensemanagement.models.ExpenseCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExpenseCategoryRepositoryTest {

    @Autowired
    private ExpenseCategoryRepository expenseCategoryRepository;

    @Test
    public void saveSomeCategories(){
        ExpenseCategory expenseCategory = new ExpenseCategory();
        expenseCategory.setName("Travel");
        expenseCategory.setCode("AAA");
        expenseCategoryRepository.save(expenseCategory);

        ExpenseCategory expenseCategory1 = new ExpenseCategory();
        expenseCategory1.setName("Hotel Booking");
        expenseCategory1.setCode("HHH");
        expenseCategoryRepository.save(expenseCategory1);
    }

}