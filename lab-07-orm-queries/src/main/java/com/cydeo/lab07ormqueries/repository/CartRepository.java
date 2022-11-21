package com.cydeo.lab07ormqueries.repository;
import com.cydeo.lab07ormqueries.entity.Cart;
import com.cydeo.lab07ormqueries.entity.Customer;
import com.cydeo.lab07ormqueries.enums.CartState;
import com.cydeo.lab07ormqueries.enums.DiscountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    //Write a derived query to get all cart by specific discount type
    List<Cart> findByDiscount_DiscountType(DiscountType discountType);
    //Write a JPQL query to get all cart by customer
    @Query("Select c from Cart c where c.customer.id=?1")
    List<Cart> retrieveCartByCustomer_Id(@Param("id")Long id);
    //Write a derived query to get all cart by customer and cart state
    List<Cart> findAllByCustomerIdAndCartState(Long id, CartState cartState);
    //Write a derived query to get all cart by customer and cart state and discount is null condition
    List<Cart> findByCustomer_IdAndCartStateAndDiscountIsNull(Long customerId, CartState cartState);
    //Write a native query to get all cart by customer and cart state and discount is not null condition
    @Query(value="SELECT*FROM cart c JOIN customer cus ON c.customer_id=cus.id " +
            "where cus.id=?1 and c.cart_state=?2 and c.discount <> NULL", nativeQuery=true)
    List<Cart> retrieveByCustomerAndStateAndHasDiscount(@Param("id")Long id,@Param("name") String cartState);
}
