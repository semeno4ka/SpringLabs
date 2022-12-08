package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.OrderDTO;
import com.cydeo.lab08rest.enums.PaymentMethod;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> retrieveOrderList(){
        return ResponseEntity.ok(new ResponseWrapper("Order list retrieved", orderService.retrieveOrderList(), HttpStatus.OK));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateOrder(@RequestBody OrderDTO orderDTO){
        return ResponseEntity.ok(new ResponseWrapper("Order updated", orderService.updateOrder(orderDTO),HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createOrder(@RequestBody OrderDTO orderDTO){
      return ResponseEntity.ok(new ResponseWrapper("Order created", orderService.createOrder(orderDTO),HttpStatus.OK));
    }

    @GetMapping("/paymentMethod/{paymentMethod}")
    public ResponseEntity<ResponseWrapper> retrieveListByPaymentMethod(@PathVariable("paymentMethod")PaymentMethod paymentMethod){
        return ResponseEntity.ok(new ResponseWrapper("Payment method retrieved", orderService.retrieveOrderByPaymentMethod(paymentMethod), HttpStatus.OK));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ResponseWrapper> retrieveOrderByEmail(@PathVariable("email")String email){
        return ResponseEntity.ok(new ResponseWrapper("Order by email retrieved", orderService.retrieveOrderByEmail(email), HttpStatus.OK));
    }
}

