package com.cydeo.loosely;

import java.math.BigDecimal;

public class BalanceManager {
    public boolean checkout( Balance balance, BigDecimal amount) {
        // implement checkout business
        if(balance.getAmount().compareTo(amount)>=0){
           return true;
        }
        return false;
    }
}
