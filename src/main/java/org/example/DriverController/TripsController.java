package org.example.DriverController;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.Trips.model.TripServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trips")
@AllArgsConstructor
public class TripsController {


    TripServices tripServices;

    @GetMapping("/check")
    public ResponseEntity<?> check(){

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("ok");
    }
}
