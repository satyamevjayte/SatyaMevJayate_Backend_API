package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.CrimeImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
@RestController
public class Controller_CrimeImage{
    @Autowired
    private com.satyamevjayate.api.services.CrimeImage_Services CrimeImage_Services;

    @GetMapping("/crimeImage")
    public List<CrimeImage> getAllCrimeImage() {
        return CrimeImage_Services.listAllCrimeImage();
    }

    @GetMapping("/crimeImage/{id}")
    public CrimeImage getCrimeImage(@PathVariable BigInteger id)
    {

        CrimeImage CrimeImage= CrimeImage_Services.getCrimeImage(id);
        return CrimeImage;



    }

    @PostMapping("/crimeImage")
    public String addCrimeImage(@RequestBody CrimeImage CrimeImage)
    {
        CrimeImage_Services.saveCrimeImage(CrimeImage);;
        return "CrimeImage Add Successfully";
    }


    @DeleteMapping("/crimeImage/{id}")
    public String deleteCrimeImage(@PathVariable BigInteger id)
    {
        CrimeImage_Services.deleteCrimeImage(id);;
        return "Delete CrimeImage Successfully";
    }

    @PutMapping("/crimeImage/{id}")
    public ResponseEntity<Object> editCrimeImage(@RequestBody CrimeImage CrimeImage, @PathVariable BigInteger id) {

        CrimeImage.setCrimeImageID(id);

        CrimeImage_Services.saveCrimeImage(CrimeImage);

        return ResponseEntity.noContent().build();
    }
}
