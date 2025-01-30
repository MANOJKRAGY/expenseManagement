package com.example.expensemanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpenseRequestDto {
    private String expenseName;
    private String description;
    private Long expenseCategoryId;
    private String expenseCode;
    private String userId;
}
