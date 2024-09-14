package org.example.DriverController;


import lombok.AllArgsConstructor;
import org.example.DriverModel.Courrier;
import org.example.DriverModel.CourrierServices;
import org.example.DriverModel.GpsCoordinates;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/driver")
@AllArgsConstructor
public class DriverControllerApi {


    CourrierServices courrierServices;


    @PostMapping("/save")
    public ResponseEntity<?> SaveNewDriver(){

        Courrier courrier = new Courrier();
        GpsCoordinates gpsCoordinates = new GpsCoordinates();

        gpsCoordinates.setLatitude("33.4383932");
        gpsCoordinates.setLongtitue("94.489493");

        courrier.setDriverid("1");
        courrier.setName("BEN BEN");
        courrier.setGpsCoordinates(gpsCoordinates);


        try{
            return  courrierServices.SaveDriver(courrier);

        }
        catch (Exception e){

            return ResponseEntity.status(HttpStatus.CONFLICT).build();

        }


    }

    @GetMapping("/all")
    public ResponseEntity<?> getallDrivers(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(courrierServices.fetchallCourrierdetails());
    }

    @GetMapping("/find")
    public ResponseEntity<?> findbyId(@RequestParam String id){

        return courrierServices.findbyId(id);
    }
}
