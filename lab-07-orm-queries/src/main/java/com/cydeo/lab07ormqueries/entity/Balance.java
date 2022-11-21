package com.cydeo.lab07ormqueries.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
