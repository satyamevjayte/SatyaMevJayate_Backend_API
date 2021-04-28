package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.CrimeSuspect;
import com.satyamevjayate.api.model.Crimesuspectmodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class Controller_CrimeSuspect {  
    @Autowired
private com.satyamevjayate.api.services.CrimeSuspect_Services CrimeSuspect_Services;

    @GetMapping("/crimesuspect")
    public Crimesuspectmodel getAllCrimeSuspect() {
        return CrimeSuspect_Services.listAllCrimeSuspect();
    }

    @GetMapping("/crimesuspect/{id}")
    public Crimesuspectmodel getCrimeSuspect(@PathVariable BigInteger id)
    {
        Crimesuspectmodel CrimeSuspect= CrimeSuspect_Services.getCrimeSuspect(id);
        return CrimeSuspect;



    }

    @PostMapping("/crimesuspect")
    public String addCrimeSuspect(@RequestBody CrimeSuspect CrimeSuspect)
    {
        CrimeSuspect_Services.saveCrimeSuspect(CrimeSuspect);;
        return "CrimeSuspect Add Successfully";
    }


    @DeleteMapping("/crimesuspect/{id}")
    public String deleteCrimeSuspect(@PathVariable BigInteger id)
    {
        String res= CrimeSuspect_Services.deleteCrimeSuspect(id);;
        return res;
    }

    @PutMapping("/crimesuspect/{id}")
    public ResponseEntity<Object> editCrimeSuspect(@RequestBody CrimeSuspect CrimeSuspect, @PathVariable BigInteger id) {

        CrimeSuspect.setCrimeSuspectID(id);

        CrimeSuspect_Services.saveCrimeSuspect(CrimeSuspect);

        return ResponseEntity.noContent().build();
    }

}
