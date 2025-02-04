package com.example.expensemanagement.dto;

import com.example.expensemanagement.models.PaymentType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class PurchaseRequestDto {

    private String purchaseItemName;
    private String itemCategory;
    private String vendor;
    private String paymentType;
    private Long amount;
    private String description;
    private String attachedBillName;
    private String attachedBillUrl;
    private LocalDate dateOfPurchase;
    private long expenseId;

}
