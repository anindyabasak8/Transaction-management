package com.Transaction.Transactionmanagement.repos;

import com.Transaction.Transactionmanagement.models.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PassengerRepository extends JpaRepository<PassengerInfo,Long> {
}
