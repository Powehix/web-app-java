package com.qrcode.WebApp.repositories;

import com.qrcode.WebApp.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
