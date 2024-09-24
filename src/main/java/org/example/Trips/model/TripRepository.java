package org.example.Trips.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface TripRepository extends MongoRepository<DriverTrips, String> {




}
