package org.example.DriverController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.DriverModel.GpsCoordinates;
import org.springframework.stereotype.Service;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {

    private String driverid;
    private String name;
    private GpsCoordinates gpsCoordinates;

}
