package com.qrcode.WebApp.repo;

import com.qrcode.WebApp.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
