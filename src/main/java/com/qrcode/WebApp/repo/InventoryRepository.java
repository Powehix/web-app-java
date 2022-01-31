package com.qrcode.WebApp.repo;

import com.qrcode.WebApp.models.Inventory;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<Inventory, Long> {
}
