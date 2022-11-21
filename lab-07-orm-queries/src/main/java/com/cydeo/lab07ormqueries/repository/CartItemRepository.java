package com.cydeo.lab07ormqueries.repository;


import com.cydeo.lab07ormqueries.entity.CartItem;
import com.cydeo.lab07ormqueries.entity.Discount;
import com.cydeo.lab07ormqueries.entity.Product;
import com.cydeo.lab07ormqueries.enums.CartState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {

    //Write a derived query to get count cart items
    Integer countCartItemBy();//countAllBy

    //Write a derived query to get cart items for specific cart state
    List<CartItem> findByCartCartState(CartState state);

    //Write a native query to get cart items for specific cart state and product name
    @Query(value="SELECT*FROM cartItem ci JOIN cart c ON ci.cart_id=c.id " +
            "JOIN product p ON ci.product_id=p.id where c.cartState=?1 AND p.name=?2", nativeQuery = true)
    List<CartItem> retrieveItemsByCartState(@Param("cartState")String cartState,@Param("name") String name);

    //Write a native query to get cart items for specific cart state and without discount
    @Query(value="SELECT*FROM cartItem ci JOIN cart c ON ci.cart_id=c.id WHERE c.cartState =?1 AND " +
            "c.discount_id IS NULL", nativeQuery = true)
    List<CartItem> retrieveItemsByCartStateAndNoDiscount(@Param("cartState") String cartState);

    //Write a native query to get cart items for specific cart state and with specific Discount type
    @Query(value="SELECT*FROM cartItem ci JOIN cart c ON ci.cart_id=c.id" +
            "JOIN discount d ON c.discount_id=d.id WHERE c.cartState =?1 AND " +
            "d.discount_type=?2", nativeQuery = true)
    List<CartItem> retrieveItemsByCartStateAndDiscountType(@Param("cartState")String cartState,@Param("discountType") String discount);

    // WE DO NOT USE CART STATE & DISCOUNT ENUM AS PARAMETER, INSTEAD WE USE STRING BECAUSE ENUM TYPE WAS DEFINED AS STRING
}
