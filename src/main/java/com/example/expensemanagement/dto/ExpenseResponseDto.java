package com.example.expensemanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpenseResponseDto {
    private String itemName;
    private String description;
    private String userId;
}
