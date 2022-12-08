package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.ProductDTO;
import com.cydeo.lab08rest.dto.ProductRequest;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

   ProductDTO createProduct(ProductDTO product);
    List<ProductDTO> retrieveProductList();
    ProductDTO updateProduct(ProductDTO product);
    List<ProductDTO> retrieveProductByCategoryPrice(List<Long> categoryList, BigDecimal price);
    ProductDTO retrieveProductByName(String productName);
    List<ProductDTO> retrieveTop3();
    Integer countProductByPrice(BigDecimal price);
    List<ProductDTO> retrieveProductByPriceQuantity(BigDecimal price, Integer quantity);
    List<ProductDTO> retrieveProductByCategoryId(Long categoryId);

}
