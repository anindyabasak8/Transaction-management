package com.Transaction.Transactionmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class BookingAcknowledgement {
    private String Status;
    private Double amount;
    private String accountId;
    private String date;
    private String PnrNo;

}
