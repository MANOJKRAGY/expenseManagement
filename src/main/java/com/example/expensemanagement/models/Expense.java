package com.example.expensemanagement.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expense extends BaseClass{
    private String expensepurpose;
    @ManyToOne(cascade = CascadeType.ALL)
    private ExpenseCategory expenseCategory;
    private String expenseCode;
    private String employeeName;
    private Long employeeId;
    private BaseLocation baseLocation;
    private int expensePeriod;
    private LocalDate expenseStartDate;
    private LocalDate expenseEndDate;
    private LocalDate expenseSubmissionDate;
    private Long reportingManagerId;
    private Long projectId;
    private ExpenseApprovalStatus expenseApprovalStatus;
    private long totalExpenseAmount;
    private long totalReimbursedAmount;
    @OneToMany(mappedBy = "expense")
    private List<Purchase> purchaseList;

}
