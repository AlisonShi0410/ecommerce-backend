package com.ecommerce.controller;

import com.ecommerce.entity.Sku;
import com.ecommerce.service.SkuService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skus")
public class SkuController {
    private final SkuService skuService;

    public SkuController(SkuService skuService){
        this.skuService = skuService;
    }

    @PostMapping
    public Sku createSku(@RequestBody Sku sku){
        return skuService.createSku(sku);
    }
}
