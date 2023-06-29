package com.Transaction.Transactionmanagement.dto;

import com.Transaction.Transactionmanagement.models.PassengerInfo;
import com.Transaction.Transactionmanagement.models.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class BookingRequest {
    private PassengerInfo passengerInfo;
    private PaymentInfo paymentInfo;
}
