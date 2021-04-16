package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.PoliceStation;
import com.satyamevjayate.api.services.PoliceStationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
@RestController
public class Controller_PoliceStation {
    @Autowired
    private PoliceStationServices PoliceStationService;

    @GetMapping("/GetAllPoliceStation")
    public List<PoliceStation> getAllPolice_Role() {
        return PoliceStationService.listAll_PoliceStation();
    }

    @GetMapping("/GetPoliceStation/{id}")
    public PoliceStation getPoliceStation(@PathVariable BigInteger id)
    {
        PoliceStation p= PoliceStationService.getPoliceStation(id);
        return p;
    }

    @PostMapping("/AddPoliceStation")
    public String addPoliceStation(@RequestBody PoliceStation p)
    {
        PoliceStationService.save_PoliceStation(p);
        return "PoliceStation Add successfully";

    }

    @DeleteMapping("/DeletePoliceStation/{id}")
    public String deletePoliceStation(@PathVariable BigInteger id)
    {
        PoliceStationService.delete_PoliceStation(id);
        return "PoliceStation Delete successfully";
    }

    @PutMapping("/EditPoliceStation/{id}")
    public ResponseEntity<Object> editPoliceStation(@RequestBody PoliceStation PoliceStation, @PathVariable BigInteger id) {


        PoliceStation.setPoliceStationID(id);

        PoliceStationService.save_PoliceStation(PoliceStation);

        return ResponseEntity.noContent().build();
    }
}
