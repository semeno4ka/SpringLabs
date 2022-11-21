package com.cydeo.lab07ormqueries.repository;

import com.cydeo.lab07ormqueries.entity.Category;
import com.cydeo.lab07ormqueries.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    //Write a derived query to get top 3 product order by price desc
    List<Product> findTop3ByOrderByPriceDesc();
    //Write a derived query to get product by specific name
    Product findByName(String name);
    //Write a derived query to get product by specific category
    List<Product> findAllByCategoryListContaining(Category category);
    //Write a derived query to get count by price greater than specific amount
    Integer countByPriceGreaterThan(Double amount);
    //Write a derived query to get all product by quantity greater than or equal specific count
    List<Product> findByQuantityGreaterThanEqual(Integer quantity);
    //Write a native query to get all product by price greater than specific amount and quantity lower than specific count
    @Query(value="Select*from product where price>?1 and quantity<?2", nativeQuery=true)
    List<Product> retrieveByPriceGreaterQuantityLess(@Param("price")BigDecimal price, @Param("quantity")Integer quantity);
    //Write a native query to get all product by specific categoryId
    @Query(value="Select*from product p JOIN category c ON p.id=c.p_id where c.id=?1",nativeQuery = true)
    List<Product> retrieveByCategoryId(@Param("id")Long id);
    //Write a native query to get all product by specific categoryId and price greater than specific amount
    @Query(value="Select*from product p JOIN category c ON c.id=p.c_id where c.id=?1 and p.price>?2",nativeQuery = true)
    List<Product> retrieveByCatIdAndPriceGreaterThan(@Param("id")Long id,@Param("price") BigDecimal price);

}
