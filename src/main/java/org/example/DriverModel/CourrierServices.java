package org.example.DriverModel;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourrierServices {

    Repository repository;

    public ResponseEntity<?> SaveDriver(Courrier courrier){

        try {

            repository.save(courrier);

            return  ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }

        catch (Exception e){
            throw e;
        }

    }


    public ResponseEntity<?> fetchallCourrierdetails(){

        List<Courrier> courrierList
                = repository.findAll();

       return ResponseEntity.status(HttpStatus.ACCEPTED).body(courrierList);
    }

    // find By id

    public  ResponseEntity<?> findbyId(String id){

        Optional<Courrier> C = repository.findById(id);

        if (C.isPresent()){

           return ResponseEntity.status(HttpStatus.ACCEPTED).body(C);
        }

       return ResponseEntity.status(HttpStatus.NOT_FOUND).build();



    }
}
