package org.example.DriverController;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/driver")
public class DriverControllerApi {

    @GetMapping("/getall")
    public ResponseEntity<?> getallDrivers(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("test");
    }
}
