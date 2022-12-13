package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    CustomerDTO readByEmail(String email);
    CustomerDTO create(CustomerDTO customerDTO);
    CustomerDTO update(CustomerDTO customerDTO);
    List<CustomerDTO> readAll();
    CustomerDTO findById(Long id);
}
