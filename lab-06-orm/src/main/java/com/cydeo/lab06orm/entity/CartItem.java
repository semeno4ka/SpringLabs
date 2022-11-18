package com.cydeo.lab06orm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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
