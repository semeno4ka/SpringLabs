package com.cydeo.lab07ormqueries.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class CartItem  extends BaseEntity{

    private int quantity;

    @ManyToOne
    private Cart cart;
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
}
