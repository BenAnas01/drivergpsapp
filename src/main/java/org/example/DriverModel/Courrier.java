package org.example.DriverModel;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("drivers")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Courrier {

    @Id
    private String driverid;
    private String name;
    private GpsCoordinates gpsCoordinates;
}
