package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.CrimeVictim;
import com.satyamevjayate.api.model.Crimevictimmodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
@RestController
@RequestMapping("/crimevictim")
public class Controller_CrimeVictim {
    @Autowired
    private com.satyamevjayate.api.services.CrimeVictim_Services CrimeVictim_Services;

    @GetMapping("")
    public Crimevictimmodel getAllCrimeVictim() {
        return CrimeVictim_Services.listAllCrimeVictim();
    }

    @GetMapping("/{id}")
    public Crimevictimmodel getCrimeVictim(@PathVariable BigInteger id)
    {
        Crimevictimmodel CrimeVictim= CrimeVictim_Services.getCrimeVictim(id);
        return CrimeVictim;
    }
    @PostMapping("")
    public String addCrimeVictim(@RequestBody CrimeVictim CrimeVictim)
    {
        CrimeVictim_Services.saveCrimeVictim(CrimeVictim);
        return "CrimeVictim Add Successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteCrimeVictim(@PathVariable BigInteger id)
    {
        String res=CrimeVictim_Services.deleteCrimeVictim(id);
        return res;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editCrimeVictim(@RequestBody CrimeVictim CrimeVictim, @PathVariable BigInteger id) {
        CrimeVictim.setCrimeVictimID(id);
        CrimeVictim_Services.saveCrimeVictim(CrimeVictim);
        return ResponseEntity.noContent().build();
    }

}
