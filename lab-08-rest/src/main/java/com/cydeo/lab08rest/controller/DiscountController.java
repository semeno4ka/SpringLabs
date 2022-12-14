package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.DiscountDTO;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.DiscountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/discount")
public class DiscountController {

    private final DiscountService discountService;

    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> listAllDiscounts(){
        return ResponseEntity.ok(new ResponseWrapper("Discounts are retrieved", discountService.readAll(), HttpStatus.OK));
    }
    @PutMapping
    public ResponseEntity<ResponseWrapper> updateDiscounts(@RequestBody DiscountDTO discount){
        return ResponseEntity.ok(new ResponseWrapper("Discount updated", discountService.update(discount), HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createDiscount(@RequestBody DiscountDTO discount){
        return ResponseEntity.ok(new ResponseWrapper("Discount created", discountService.create(discount), HttpStatus.CREATED));
    }

    @GetMapping("/{name}")
    public ResponseEntity<ResponseWrapper> findByNameDiscount(@PathVariable("name") String name){
        return ResponseEntity.ok(new ResponseWrapper("Discount is retrieved", discountService.readByName(name), HttpStatus.OK));
    }

}
