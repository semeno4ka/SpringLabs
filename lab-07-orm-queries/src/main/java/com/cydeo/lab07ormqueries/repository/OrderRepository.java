package com.cydeo.lab07ormqueries.repository;

import com.cydeo.lab07ormqueries.entity.Order;
import com.cydeo.lab07ormqueries.enums.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    //Write a derived query to get top 5 orders by order by total price desc
    List<Order> findTop5ByOrderByTotalPriceDesc();
    //Write a derived query to get all orders by customer email
    List<Order> findByCustomerEmail(String email);
    //Write a derived query to get all orders by specific payment method
    List<Order> findByPaymentPaymentMethod(PaymentMethod paymentMethod);
    //Write a derived query to check is there any orders by customer email
    boolean existsByCustomerEmail(String email);
    //Write a native query to get all orders by specific product name
    @Query(value="SELECT*FROM orders o JOIN cart c ON o.cart_id=c.id " +
            "JOIN cart_item ci ON c.id=ci.cart_id " +
            "JOIN product p ON ci.product_id=p.id WHERE p.name=?1 ", nativeQuery=true)
    List<Order> retrieveAllProductName(@Param("name")String name);
    //Write a native query to get all orders by specific categoryId
   /* @Query(value="SELECT*FROM orders o JOIN cart c ON o.cart_id=c.id " +
                        "JOIN cart_item ci ON c.id=ci.cart_id " +
                        "JOIN product p ON ci.product_id=p.id " +
            "JOIN product_category_rel pcr ON p.id=pcr.p_id " +
            "JOIN category ca ON ca.id=pcr.c_id WHERE ca.name=?1 ", nativeQuery = true)
            List<Order> retrieveByCategoryId(Long id);
    */
     @Query(value = "SELECT * FROM orders o JOIN cart c ON o.cart_id = c.id " +
            "JOIN cart_item ci ON ci.cart_id = c.id " +
            "JOIN product p ON ci.product_id= p.id " +
            "JOIN category ca ON ca.id = p.c_id WHERE ca.id = ?1", nativeQuery = true)
    List<Order> retrieveAllOrdersByCategoryId(@Param("id") Long id);


    //Write a JPQL query to get all orders by totalPrice and paidPrice are equals
    @Query("Select o from Order o where o.totalPrice=o.paidPrice")
    List<Order> retrieveTotalAndPaidEqual(BigDecimal totalPrice, BigDecimal paidPrice);
    //Write a JPQL query to get all orders by totalPrice and paidPrice are not equals and discount is not null
    @Query("Select o from Order o where o.paidPrice<>o.totalPrice and o.cart.discount IS NOT NULL")
    List<Order> retrieveByTotalPriceAndPaidPriceNotEqualsAndDiscountIdIsNull();

}
