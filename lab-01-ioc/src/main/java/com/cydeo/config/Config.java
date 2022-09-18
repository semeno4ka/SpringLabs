package com.cydeo.config;

import com.cydeo.Currency;
import com.cydeo.account.Current;
import com.cydeo.account.Saving;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.UUID;

@Configuration
public class Config {

@Bean
    Saving saving(){
    Saving s= new Saving();
    s.setAccountId(UUID.randomUUID());
    s.setAmount(new BigDecimal("100"));
    s.setCurrency(new Currency("123","Euro"));
    return s;
}
@Bean
Currency currency(){
    return new Currency("123","Euro");
}

@Bean
    Current current(Currency currency){
    Current c = new Current();
    c.setAccountId(UUID.randomUUID());
    c.setAmount(new BigDecimal("100"));
    c.setCurrency(currency);//parameterized wiring or could be currency() as direct wiring without parameter
    return c;
}


}
