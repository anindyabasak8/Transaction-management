package com.Transaction.Transactionmanagement.Utils;

import com.Transaction.Transactionmanagement.exceptions.PassengerPaymentsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PaymentUtils {
    Logger logger = LoggerFactory.getLogger(PaymentUtils.class);


    public static  Map<String, Double> validationMap = new HashMap<>();

        public PaymentUtils(){
            validationMap.put("acc1",20000.0);
            validationMap.put("acc2",30000.0);
            validationMap.put("acc3",20000.0);
            validationMap.put("acc4",50000.0);
            validationMap.put("acc5",80000.0);
            validationMap.put("acc6",100000.0);

        }

        public void validateLimit(String accountName,double amount) throws PassengerPaymentsException {
            logger.info("amount :"+amount);
            logger.info("Amount in map :"+validationMap.get(accountName));
            if(amount>validationMap.get(accountName)) {
                throw new PassengerPaymentsException("Amount is greater than allowed limit..");
            }
        }

}
