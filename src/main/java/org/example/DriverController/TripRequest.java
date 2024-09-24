package org.example.DriverController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.Trips.model.Location;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TripRequest {

    private Location departure;
    private Location arrival;
}
