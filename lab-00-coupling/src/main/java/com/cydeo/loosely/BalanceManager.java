package com.cydeo.loosely;

import java.math.BigDecimal;

public class BalanceManager {

    public boolean checkout(Balance balance, BigDecimal amount) {
        // implement checkout business
        BigDecimal balanceAmount = balance.getAmount();

        return balanceAmount.subtract(amount).compareTo(BigDecimal.ZERO)>0;
    }
}
