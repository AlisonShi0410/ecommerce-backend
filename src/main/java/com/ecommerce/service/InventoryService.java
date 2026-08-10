package com.ecommerce.service;

import com.ecommerce.entity.Inventory;
import com.ecommerce.repository.InventoryRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    public Inventory createInventory(Inventory inventory){
        return inventoryRepository.save(inventory);
    }
}
