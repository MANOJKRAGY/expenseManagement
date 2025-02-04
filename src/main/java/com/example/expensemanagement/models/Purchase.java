package com.example.expensemanagement.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Purchase extends BaseClass{

    private String purchaseItemName;
    private String itemCategory;
    private String vendor;
    private PaymentType paymentType;
    private Long amount;
    private String description;
    private String attachedBillName;
    private String attachedBillUrl;
    private LocalDate dateOfPurchase;
    private PurchaseApprovalStatus purchaseApprovalStatus;
    @ManyToOne
    @JoinColumn(name= "expense_id")
    private Expense expense;

}
