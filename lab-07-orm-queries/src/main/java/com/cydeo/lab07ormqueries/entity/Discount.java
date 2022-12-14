package com.cydeo.lab07ormqueries.entity;


import com.cydeo.lab07ormqueries.enums.DiscountType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Discount extends BaseEntity {

    private Double discount;
    @Enumerated(EnumType.STRING)
    private DiscountType discountType;
    private String name;

}
