package com.ecommerce.service;

import com.ecommerce.entity.Address;
import com.ecommerce.repository.AddressRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }


    public Address createAddress(Address address){
        return addressRepository.save(address);
    }
}
