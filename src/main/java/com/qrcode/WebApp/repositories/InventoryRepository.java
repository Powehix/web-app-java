package com.qrcode.WebApp.repositories;

import com.qrcode.WebApp.models.Inventory;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<Inventory, Long> {
}
