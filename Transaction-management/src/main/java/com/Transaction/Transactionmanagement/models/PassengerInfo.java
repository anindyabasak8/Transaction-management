package com.Transaction.Transactionmanagement.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Table(name = "Passenger_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Component
public class PassengerInfo {
    @Id
    @GeneratedValue
    private long pId;
    private String name;
    private String email;
    private String addr;
    private long mobile_no;

}
