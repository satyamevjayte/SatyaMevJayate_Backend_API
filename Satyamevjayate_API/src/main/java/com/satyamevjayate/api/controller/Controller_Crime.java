package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.Crime;
import com.satyamevjayate.api.services.Crime_Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class Controller_Crime {
    @Autowired
    private Crime_Services Crime_Services;

    @GetMapping("/crime")
    public List<Crime> getAllCrime() {
        return Crime_Services.listAllCrime();
    }

    @GetMapping("/crime/{id}")
    public Crime getCrime(@PathVariable BigInteger id)
    {

        Crime Crime= Crime_Services.getCrime(id);
        return Crime;

    }

    @PostMapping("/crime")
    public String addCrime(@RequestBody Crime Crime)
    {
        Crime_Services.saveCrime(Crime);;
        return "Crime Add Successfully";
    }


    @DeleteMapping("/crime/{id}")
    public String deleteCrime(@PathVariable BigInteger id)
    {
        Crime_Services.deleteCrime(id);;
        return "Delete Crime Successfully";
    }

    @PutMapping("/crime/{id}")
    public ResponseEntity<Object> editCrime(@RequestBody Crime Crime, @PathVariable BigInteger id) {

        Crime.setCrimeID(id);

        Crime_Services.saveCrime(Crime);

        return ResponseEntity.noContent().build();
    }

}
