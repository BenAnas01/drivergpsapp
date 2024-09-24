package org.example.Trips.model;


import ch.qos.logback.core.encoder.EchoEncoder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.ResourceBundle;

@Service
@AllArgsConstructor
public class TripServices {

    TripRepository tripRepository;

    MongoTemplate mongoTemplate;

    public void  SaveNewTrip(DriverTrips driverTrips){

        try{
            tripRepository.save(driverTrips);
        }
        catch (Exception e){
            throw e;
        }

    }


    public ResponseEntity<?> findBy(String drivertrips){

        Optional<DriverTrips> mydriver = tripRepository.findById(drivertrips);

        if(mydriver.isPresent()){

            DriverTrips driverTrips = mydriver.get();

            return  ResponseEntity.status(HttpStatusCode.valueOf(200)).body(driverTrips);

        }

        return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();

    }


    public ResponseEntity<?> AddTriptoDriver(String driverid, Trip newtrip){

        Optional<DriverTrips> driverTrips = tripRepository.findById(driverid);

        if (driverTrips.isPresent()){


            try {
                DriverTrips driverupdatedList = driverTrips.get();
                driverupdatedList.getTripList().add(newtrip);
                tripRepository.save(driverupdatedList);
                return ResponseEntity.status(HttpStatus.ACCEPTED).build();

            } catch (Exception e) {
                throw new RuntimeException(e);

            }


        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }





}
