package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.OrderDTO;
import com.cydeo.lab08rest.dto.PaymentDTO;
import com.cydeo.lab08rest.enums.PaymentMethod;

import java.util.List;

public interface OrderService {

    List<OrderDTO> retrieveOrderList();
    OrderDTO updateOrder(OrderDTO order);
    OrderDTO createOrder(OrderDTO order);
    List<OrderDTO> retrieveOrderByPaymentMethod(PaymentMethod paymentMethod);
    List<OrderDTO> retrieveOrderByEmail(String email);
}
