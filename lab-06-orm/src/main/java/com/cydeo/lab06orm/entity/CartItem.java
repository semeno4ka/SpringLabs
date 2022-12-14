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

    private Integer quantity;

    @ManyToOne
    private Cart cart;
    @ManyToOne(fetch = FetchType.LAZY)// do not bring this data from db until requested
    private Product product;
}
