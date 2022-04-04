package com.qrcode.WebApp.repositories;

import com.qrcode.WebApp.models.Object;
import org.springframework.data.repository.CrudRepository;

public interface ObjectRepository extends CrudRepository<Object, Long> {
}
