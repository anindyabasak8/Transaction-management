package com.Transaction.Transactionmanagement.service;

import com.Transaction.Transactionmanagement.Utils.PaymentUtils;
import com.Transaction.Transactionmanagement.dto.BookingAcknowledgement;
import com.Transaction.Transactionmanagement.dto.BookingRequest;
import com.Transaction.Transactionmanagement.exceptions.PassengerPaymentsException;
import com.Transaction.Transactionmanagement.models.PassengerInfo;
import com.Transaction.Transactionmanagement.models.PaymentInfo;
import com.Transaction.Transactionmanagement.repos.PassengerRepository;
import com.Transaction.Transactionmanagement.repos.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
@Component
public class PaymentsServices {

   @Autowired
   private PassengerRepository passengerRepository;
   @Autowired
   private PaymentRepo paymentRepo;

   @Autowired
   private PaymentUtils paymentUtils;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    @Transactional
   public BookingAcknowledgement getBooking(BookingRequest bookingRequest) throws PassengerPaymentsException {
        //As transactional is there hence only after successful execution tables will be comitted in db..
       PassengerInfo passengerInfo = bookingRequest.getPassengerInfo();
       passengerInfo =  passengerRepository.save(passengerInfo);

       PaymentInfo paymentInfo = bookingRequest.getPaymentInfo();
       paymentUtils.validateLimit(paymentInfo.getAccountNo(),paymentInfo.getAmount());

       paymentInfo.setPassengerId(passengerInfo.getPId());
       LocalDateTime now = LocalDateTime.now();
       paymentInfo.setDate(dtf.format(now));
       paymentInfo.setPaymentStatus("SUCCESS");
       paymentRepo.save(paymentInfo);

       return new BookingAcknowledgement("SUCCESS",paymentInfo.getAmount(),paymentInfo.getAccountNo(),
               paymentInfo.getDate(),
               UUID.randomUUID().toString().split("-")[0]);
   }

}
