package com.cydeo.lab07ormqueries.repository;


import com.cydeo.lab07ormqueries.entity.Balance;
import com.cydeo.lab07ormqueries.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long> {
    //Write a derived query to check balance exists for specific customer
    boolean existsByCustomerId(Long id);
    //Write a derived query to get balance for specific customer
    Balance findByCustomer(Customer customer);
    //Write a native query to get top 5 max balance
    @Query(value="SELECT*FROM balance ORDER BY amount DESC LIMIT 5", nativeQuery = true)
    Balance retrieveTop5Balance();
    //Write a derived query to get all balances greater than or equal specific balance amount
    List<Balance> findByAmountGreaterThanEqual(BigDecimal amount);
    //Write a native query to get all balances less than specific balance amount
    @Query(value="SELECT*FROM balance WHERE amount<?1", nativeQuery = true)
    List<Balance> retrieveBalanceLessThan(@Param("amount")BigDecimal amount);

}
