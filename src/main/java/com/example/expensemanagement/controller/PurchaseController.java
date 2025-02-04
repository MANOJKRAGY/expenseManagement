package com.example.expensemanagement.controller;

import com.example.expensemanagement.dto.PurchaseRequestDto;
import com.example.expensemanagement.dto.PurchaseResponseDto;
import com.example.expensemanagement.exception.PurchasesNotCreatedException;
import com.example.expensemanagement.models.PaymentType;
import com.example.expensemanagement.models.Purchase;
import com.example.expensemanagement.service.IPurchaseService;
import com.example.expensemanagement.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/purchases")
@RestController
public class PurchaseController {

     @Autowired
     private IPurchaseService purchaseService;

     @PostMapping
     public ResponseEntity<List<PurchaseResponseDto>> createPurchases(@RequestBody List<PurchaseRequestDto> purchaseList){
          if(purchaseList.size() == 0){
               throw new PurchasesNotCreatedException("Purchases Not Created");
          }
         List<Purchase> purchaseList1 = purchaseService.savePurchases(purchaseList);
          List<PurchaseResponseDto> purchaseResponseDtoList = new ArrayList<>();
         if(purchaseList1 != null){
              for(Purchase purchase : purchaseList1){
                 PurchaseResponseDto dto = toDto(purchase);
                  purchaseResponseDtoList.add(dto);
              }
              return new ResponseEntity<>(purchaseResponseDtoList, HttpStatus.OK);
         }else{
              throw new PurchasesNotCreatedException("Purchases Not Created");
         }
     }
     @GetMapping("/{expenseId}")
     public ResponseEntity<List<PurchaseResponseDto>> getAllPurchases(@PathVariable Long expenseId){
          List<Purchase> purchaseList = purchaseService.getPurchases(expenseId);
         List<PurchaseResponseDto> purchaseResponseDtoList = new ArrayList<>();
         for(Purchase purchase : purchaseList){
             PurchaseResponseDto purchaseResponseDto = toDto(purchase);
             purchaseResponseDtoList.add(purchaseResponseDto);
         }
          return new ResponseEntity<>(purchaseResponseDtoList,HttpStatus.OK);
     }

     private PurchaseResponseDto toDto(Purchase purchase){

         PurchaseResponseDto purchaseDto = new PurchaseResponseDto();
         purchaseDto.setId(purchase.getId());
         purchaseDto.setPurchaseItemName(purchase.getPurchaseItemName());
         purchaseDto.setItemCategory(purchase.getItemCategory());
         purchaseDto.setVendor(purchase.getVendor());
         purchaseDto.setPaymentType(String.valueOf(purchase.getPaymentType()));
         purchaseDto.setAmount(purchase.getAmount());
         purchaseDto.setDescription(purchase.getDescription());
         purchaseDto.setAttachedBillName(purchase.getAttachedBillName());
         purchaseDto.setAttachedBillUrl(purchase.getAttachedBillUrl());
         purchaseDto.setDateOfPurchase(purchase.getDateOfPurchase());
         purchaseDto.setExpenseId(purchase.getExpense().getId());
         return purchaseDto;
     }

}
