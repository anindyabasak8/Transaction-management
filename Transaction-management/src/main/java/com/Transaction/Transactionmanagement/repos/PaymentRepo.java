package com.Transaction.Transactionmanagement.repos;

import com.Transaction.Transactionmanagement.models.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PaymentRepo extends JpaRepository<PaymentInfo,String> {
}
