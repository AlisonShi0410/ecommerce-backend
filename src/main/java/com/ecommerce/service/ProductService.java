package com.ecommerce.service;

import com.ecommerce.entity.Product;
import com.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository produceRepository;

    public ProductService(ProductRepository produceRepository){
        this.produceRepository = produceRepository;
    }

    public Product createProduct(Product product){
        return produceRepository.save(product);
    }
}
