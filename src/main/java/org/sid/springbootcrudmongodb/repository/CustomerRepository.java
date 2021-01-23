package org.sid.springbootcrudmongodb.repository;

import org.sid.springbootcrudmongodb.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CusromerRepository extends MongoRepository<Customer,Long> {
}
