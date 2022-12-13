package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.entity.Address;
import com.cydeo.lab08rest.entity.Customer;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.AddressRepository;
import com.cydeo.lab08rest.service.AddressService;
import com.cydeo.lab08rest.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    public final MapperUtil mapperUtil;

    private final CustomerService customerService;

    public AddressServiceImpl(AddressRepository addressRepository, MapperUtil mapperUtil, CustomerService customerService) {
        this.addressRepository = addressRepository;
        this.mapperUtil = mapperUtil;
        this.customerService = customerService;
    }

    @Override
    public List<AddressDTO> readAll() {
        return addressRepository.findAll().stream().map(address -> mapperUtil.convert(address, new AddressDTO())).collect(Collectors.toList());
    }

    @Override
    public AddressDTO update(AddressDTO addressDTO) {//model mapper can assign id but itself and map its path to it, however, the rest of the fields will be set null, that is why it is better to assign customer manually
        Address address=mapperUtil.convert(addressDTO,new Address());
        address.setCustomer(mapperUtil.convert(customerService.findById(addressDTO.getCustomerId()), new Customer()));
        Address updated = addressRepository.save(address);
        return mapperUtil.convert(updated, new AddressDTO());
    }

    @Override
    public AddressDTO create(AddressDTO addressDTO) {
        Address address=mapperUtil.convert(addressDTO,new Address());
        address.setCustomer(mapperUtil.convert(customerService.findById(addressDTO.getCustomerId()), new Customer()));
        Address saved = addressRepository.save(address);
        return mapperUtil.convert(saved, new AddressDTO());
    }

    @Override
    public List<AddressDTO> readByStartsWith(String address) {
        return addressRepository.findAllByStreetStartingWith(address).
                stream().map(address1 -> mapperUtil.convert(address, new AddressDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public List<AddressDTO> findByCustomerId(Long id) {
        return addressRepository.retrieveByCustomerId(id).stream()
                .map(address -> mapperUtil.convert(address, new AddressDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public List<AddressDTO> findByCustomerIdAndName(Long id, String name) {
        return addressRepository.findAllByCustomerIdAndName(id, name).stream().map(address -> mapperUtil.convert(address, new AddressDTO())).collect(Collectors.toList());
    }
}