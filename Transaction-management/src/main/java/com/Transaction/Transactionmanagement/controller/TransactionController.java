package com.Transaction.Transactionmanagement.controller;

import com.Transaction.Transactionmanagement.dto.BookingAcknowledgement;
import com.Transaction.Transactionmanagement.dto.BookingRequest;
import com.Transaction.Transactionmanagement.exceptions.PassengerPaymentsException;
import com.Transaction.Transactionmanagement.service.PaymentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    private PaymentsServices paymentsServices;

    @PostMapping("/register/payment")
    public BookingAcknowledgement setData(@RequestBody BookingRequest request) throws PassengerPaymentsException {
        return paymentsServices.getBooking(request);
    }
}
