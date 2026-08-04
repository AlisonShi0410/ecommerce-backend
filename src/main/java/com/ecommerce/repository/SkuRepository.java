package com.ecommerce.repository;

import com.ecommerce.entity.Sku;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkuRepository extends JpaRepository<Sku,Long> {
   // List<Sku> findByProductId(Long productId);

   // Boolean existsBySkuCode(String skuCode);
}
