package com.ecommerce.controller;

import com.ecommerce.entity.Address;
import com.ecommerce.service.AddressService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addresses")
public class AddressController {

   private final AddressService addressService;
   public AddressController(AddressService addressService){
       this.addressService = addressService;
   }

    @PostMapping
    public Address createAddress(@RequestBody Address address){
        return addressService.createAddress(address);
    }
}
