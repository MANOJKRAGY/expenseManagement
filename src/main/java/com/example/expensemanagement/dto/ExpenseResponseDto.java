package com.example.expensemanagement.dto;

import com.example.expensemanagement.models.BaseLocation;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class ExpenseResponseDto {
    private long id;
    private String expensePurpose;
    private long expenseCategoryId;
    private String expenseCode;
    private String employeeName;
    private long employeeId;
    private String baseLocation;
    private int expensePeriod;
    private LocalDate expenseStartDate;
    private LocalDate expenseEndDate;
    private LocalDate expenseSubmissionDate;
    private long reportingManagerId;
    private long projectId;
}
