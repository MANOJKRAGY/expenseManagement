package com.example.expensemanagement.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expense extends BaseClass{

    private String expenseName;
    private String description;
    private String userId;
    @ManyToOne(cascade = CascadeType.ALL)
    private ExpenseCategory expenseCategory;

}
