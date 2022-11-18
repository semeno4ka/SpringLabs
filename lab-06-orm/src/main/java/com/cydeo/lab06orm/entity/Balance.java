package com.cydeo.lab06orm.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Balance extends BaseEntity {

    private BigDecimal amount;
    @OneToOne// we have made it oneDirectional, according to the diagram we have
    private Customer customer;

}
