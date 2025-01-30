package com.example.expensemanagement.dto;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseCategoryRequestDto {
    private String code;
    private String name;
}
