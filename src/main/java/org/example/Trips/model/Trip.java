package org.example.Trips.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Trip {

    private String tripid = UUID.randomUUID().toString();
    private  Status status;
    private  Location departure; // gps coordinates for pick up
    private Location arrival; // gps coordinates for arrival
    private LocalDateTime tripStartedAt;
    private LocalDateTime tripendedAt;




}
