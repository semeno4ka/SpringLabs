package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.ProductDTO;
import com.cydeo.lab08rest.dto.ProductRequest;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> listProduct(){
        return ResponseEntity.ok(new ResponseWrapper("Products retrieved", productService.retrieveProductList(), HttpStatus.OK));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateProduct(@RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(new ResponseWrapper("Product is updated", productService.updateProduct(productDTO),HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createProduct(@RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(new ResponseWrapper("Product is created", productService.createProduct(productDTO), HttpStatus.CREATED));
    }

    @PostMapping("/categoryandprice")
    public ResponseEntity<ResponseWrapper> retrieveProductByCategoryPrice(@RequestBody ProductRequest request){
        return ResponseEntity.ok(new ResponseWrapper("Products are retrieved", productService.retrieveProductByCategoryPrice(request.getCategoryList(),request.getPrice()), HttpStatus.CREATED));
    }

    @GetMapping("/{name}")
    public ResponseEntity<ResponseWrapper> retrieveProductByName(@PathVariable("name") String name){
        return ResponseEntity.ok(new ResponseWrapper("Product retrieved by name", productService.retrieveProductByName(name), HttpStatus.OK));
    }

    @GetMapping("/top3")
    public ResponseEntity<ResponseWrapper> getTop3(){
        return ResponseEntity.ok(new ResponseWrapper("Top 3 products by price", productService.retrieveTop3(),HttpStatus.OK));
    }

    @GetMapping("/price/{price}")
    public ResponseEntity<ResponseWrapper> countProductByPrice(@PathVariable("price")BigDecimal price){
        return ResponseEntity.ok(new ResponseWrapper("Number of products with the specified price", productService.countProductByPrice(price),HttpStatus.OK));
    }

    @GetMapping("/price/{price}/quantity/{quantity}")
    public ResponseEntity<ResponseWrapper> retrieveProductByPriceQuantity(@PathVariable("price")BigDecimal price, @PathVariable("quantity") Integer quantity){
        return ResponseEntity.ok(new ResponseWrapper("Products retrieved", productService.retrieveProductByPriceQuantity(price, quantity),HttpStatus.OK));
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<ResponseWrapper> retrieveProductByCategoryId(@PathVariable("id")Long id){
        return ResponseEntity.ok(new ResponseWrapper("Retrieved by id", productService.retrieveProductByCategoryId(id),HttpStatus.OK));
    }



}
