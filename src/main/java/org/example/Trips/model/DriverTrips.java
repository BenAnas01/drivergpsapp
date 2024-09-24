package org.example.Trips.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "driverTrips")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DriverTrips {

    @Id
    private String driverid;
    private List<Trip> tripList;


}
