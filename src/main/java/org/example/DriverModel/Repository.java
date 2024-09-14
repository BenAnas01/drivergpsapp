package org.example.DriverModel;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repository extends MongoRepository<Courrier,String> {
}
