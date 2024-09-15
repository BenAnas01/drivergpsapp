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
    public ResponseEntity<?> SaveNewDriver(@RequestBody SignupRequest signupRequest){

        Courrier courrier = new Courrier();
        GpsCoordinates gpsCoordinates = new GpsCoordinates();

        gpsCoordinates.setLatitude(signupRequest.getGpsCoordinates().getLatitude());
        gpsCoordinates.setLongtitue(signupRequest.getGpsCoordinates().getLongtitue());
        courrier.setName(signupRequest.getName());
        courrier.setDriverid(signupRequest.getDriverid());
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
        System.out.println("request received");
        return courrierServices.fetchallCourrierdetails();
    }

    @GetMapping("/find")
    public ResponseEntity<?> findbyId(@RequestParam String id){

        return courrierServices.findbyId(id);
    }
}
