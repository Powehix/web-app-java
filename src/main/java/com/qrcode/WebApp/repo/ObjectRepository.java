package com.qrcode.WebApp.repo;

import com.qrcode.WebApp.models.Object;
import org.springframework.data.repository.CrudRepository;

public interface ObjectRepository extends CrudRepository<Object, Long> {
}
