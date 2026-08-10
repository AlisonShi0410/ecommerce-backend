package com.ecommerce.controller;

import com.ecommerce.entity.Inventory;
import com.ecommerce.repository.InventoryRepository;
import com.ecommerce.service.InventoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventories")
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }

    @PostMapping
    public Inventory createInventory(@RequestBody Inventory inventory){
        return inventoryService.createInventory(inventory);
    }
}
