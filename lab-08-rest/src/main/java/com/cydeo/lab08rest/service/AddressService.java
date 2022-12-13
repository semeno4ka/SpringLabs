package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.entity.Address;

import java.util.List;

public interface AddressService {

   List<AddressDTO> readAll();
   AddressDTO update(AddressDTO addressDTO);
   AddressDTO create(AddressDTO addressDTO);
   List<AddressDTO> readByStartsWith(String address);
   List<AddressDTO> findByCustomerId(Long id);
   List<AddressDTO> findByCustomerIdAndName(Long id, String name);
}
