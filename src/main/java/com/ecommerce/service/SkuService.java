package com.ecommerce.service;

import com.ecommerce.entity.Sku;
import com.ecommerce.repository.SkuRepository;
import org.springframework.stereotype.Service;

@Service
public class SkuService {
    private final SkuRepository skuRepository;

    public SkuService(SkuRepository skuRepository){
        this.skuRepository = skuRepository;
    }

    public Sku createSku(Sku sku){
       // if (!sku.getSkuCode())
        return skuRepository.save(sku);
    }
}
