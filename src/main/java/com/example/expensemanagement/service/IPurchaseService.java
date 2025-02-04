package com.example.expensemanagement.service;

import com.example.expensemanagement.dto.PurchaseRequestDto;
import com.example.expensemanagement.models.Purchase;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IPurchaseService {

     public List<Purchase> savePurchases(List<PurchaseRequestDto> purchaseList);
     public List<Purchase> getPurchases(long expenseId);
}
