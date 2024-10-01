package org.example.DriverController;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.DriverModel.Courrier;
import org.example.DriverModel.CourrierServices;
import org.example.DriverModel.GpsCoordinates;
import org.example.Trips.model.DriverTrips;
import org.example.Trips.model.Status;
import org.example.Trips.model.Trip;
import org.example.Trips.model.TripServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/api/driver")
@AllArgsConstructor
public class DriverControllerApi {

    CourrierServices courrierServices;

    TripServices tripServices;

    @PostMapping("/save")
    public ResponseEntity<?> SaveNewDriver(@RequestBody SignupRequest signupRequest){

        Courrier courrier = new Courrier();
        GpsCoordinates gpsCoordinates = new GpsCoordinates();


        gpsCoordinates.setLatitude(signupRequest.getGpsCoordinates().getLatitude());
        gpsCoordinates.setLongtitue(signupRequest.getGpsCoordinates().getLongtitue());
        courrier.setName(signupRequest.getName());
        courrier.setDriverid(signupRequest.getDriverid());
        courrier.setGpsCoordinates(gpsCoordinates);

        DriverTrips driverTrips = new DriverTrips();
        driverTrips.setDriverid(signupRequest.getDriverid());

        List<Trip> tripslist =  new ArrayList<>();

        driverTrips.setTripList(tripslist);



        try{
            courrierServices.SaveDriver(courrier);
            tripServices.SaveNewTrip(driverTrips);

            return ResponseEntity.status(HttpStatus.ACCEPTED).build();


        }
        catch (Exception e){
            System.out.println(e);

            return ResponseEntity.status(HttpStatus.CONFLICT).build();

        }


    }


    @PostMapping("/trip/save")
    public ResponseEntity<?> saveAtrip(@RequestBody TripRequest tripRequest){

        DriverTrips driverTrips = new DriverTrips();

        Trip trip = new Trip();
        trip.setTripid(UUID.randomUUID().toString());
        trip.setTripStartedAt(LocalDateTime.now());

        trip.setTripendedAt(LocalDateTime.now().plusHours(1));
        trip.setStatus(Status.CREATED);
        trip.setDeparture(tripRequest.getDeparture());
        trip.setArrival(tripRequest.getArrival());

        List<Trip> tripslist = new ArrayList<>();

        tripslist.add(trip);

        driverTrips.setTripList(tripslist);
        driverTrips.setDriverid("1");

        try{
            tripServices.SaveNewTrip(driverTrips);

            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        catch (Exception e){
            System.out.println(e);
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();



    }


    @PostMapping("/trip/addnew")
    public ResponseEntity<?> addnewTrip(@RequestBody TripRequest tripRequest){


        Trip trip = new Trip();
        trip.setTripid(UUID.randomUUID().toString());
        trip.setTripStartedAt(LocalDateTime.now());

        trip.setTripendedAt(LocalDateTime.now().plusHours(1));
        trip.setStatus(Status.CREATED);
        trip.setDeparture(tripRequest.getDeparture());
        trip.setArrival(tripRequest.getArrival());

        try {

            return tripServices.AddTriptoDriver("1", trip);

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }


    }




    @GetMapping("/all")
    public ResponseEntity<?> getallDrivers(){
        System.out.println("request received");
        return courrierServices.fetchallCourrierdetails();
    }

    // find drivers by id

    @GetMapping("/find")
    public ResponseEntity<?> findbyId(@RequestParam String id){

        return courrierServices.findbyId(id); // real time coordinate of driver
    }



    // find driver trips by driver id
    // trips associated with the driver using driver id

    @GetMapping("/find/trips")
    public ResponseEntity<?> findalltrips(@RequestParam String id){

        return tripServices.findBy(id);
    }




    @PutMapping("/update")
    public ResponseEntity<?> updatecoordinates(

            @RequestParam String driverid,
            @RequestParam String langtitude,
            @RequestParam String latitude
    )
    {

        GpsCoordinates gpsCoordinates = new GpsCoordinates();
        gpsCoordinates.setLongtitue(langtitude);
        gpsCoordinates.setLatitude(latitude);

        try{
            return  courrierServices.UppdateCoordinateByDriverId(gpsCoordinates, driverid);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }

    @GetMapping("/healthy")
    public ResponseEntity<?> healthyapi(){

            return ResponseEntity.status(HttpStatus.ACCEPTED).body("ok : v1");
    }


}
