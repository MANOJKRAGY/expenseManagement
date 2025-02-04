package com.example.expensemanagement.dto;

import com.example.expensemanagement.models.BaseLocation;
import com.example.expensemanagement.models.ExpenseApprovalStatus;
import com.example.expensemanagement.models.ExpenseCategory;
import com.example.expensemanagement.models.Purchase;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ExpenseRequestDto {
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


