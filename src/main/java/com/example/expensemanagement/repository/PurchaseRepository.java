package com.example.expensemanagement.repository;

import com.example.expensemanagement.models.Expense;
import com.example.expensemanagement.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase,Long> {
   public Optional<List<Purchase>> findByExpenseId(long expenseId);
}
