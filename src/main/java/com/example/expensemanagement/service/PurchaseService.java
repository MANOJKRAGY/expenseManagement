package com.example.expensemanagement.service;

import com.example.expensemanagement.dto.PurchaseRequestDto;
import com.example.expensemanagement.models.Expense;
import com.example.expensemanagement.models.PaymentType;
import com.example.expensemanagement.models.Purchase;
import com.example.expensemanagement.repository.ExpenseRepository;
import com.example.expensemanagement.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService implements IPurchaseService{

    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public List<Purchase> savePurchases(  List<PurchaseRequestDto> purchaseList) {

        Expense expense ;
         if(purchaseList.size() > 0){
             PurchaseRequestDto purchaseDto = purchaseList.get(0);
             expense = expenseRepository.findById(purchaseDto.getExpenseId()).get();
             List<Purchase> purchaseList1 = new ArrayList<>();
             for(PurchaseRequestDto purchaseDtoTemp : purchaseList){
                 //long expenseId = purchaseDtoTemp.getExpenseId();
                 //Expense expense = expenseRepository.findById(expenseId).get();
                 Purchase purchase = toPurchase(purchaseDtoTemp);
                 purchase.setExpense(expense);
                 Purchase purchase1 = purchaseRepository.save(purchase);
                 //expense.getPurchaseList().add(purchase);
                 //expenseRepository.save(expense);
                 purchaseList1.add(purchase1);
             }
             return purchaseList1;
         }
         return null;
    }

    @Override
    public List<Purchase> getPurchases(long expenseId) {
        Optional<List<Purchase>> purchaseList  = purchaseRepository.findByExpenseId(expenseId);
        if(!purchaseList.isEmpty()){
            return purchaseList.get();
        }
        return null;
    }

    private Purchase toPurchase(PurchaseRequestDto purchaseDto){

        Purchase purchase = new Purchase();
        purchase.setPurchaseItemName(purchaseDto.getPurchaseItemName());
        purchase.setItemCategory(purchaseDto.getItemCategory());
        purchase.setVendor(purchaseDto.getVendor());
        purchase.setPaymentType(PaymentType.valueOf(purchaseDto.getPaymentType()));
        purchase.setAmount(purchaseDto.getAmount());
        purchase.setDescription(purchaseDto.getDescription());
        purchase.setAttachedBillName(purchaseDto.getAttachedBillName());
        purchase.setAttachedBillUrl(purchaseDto.getAttachedBillUrl());
        purchase.setDateOfPurchase(purchaseDto.getDateOfPurchase());
      //  Expense expense = expenseRepository.findById(purchaseDto.getExpenseId()).get();
      //  purchase.setExpense(expense);
        return purchase;
        //purchase.setExpense(purchaseDto.getExpenseId());
    }
}
