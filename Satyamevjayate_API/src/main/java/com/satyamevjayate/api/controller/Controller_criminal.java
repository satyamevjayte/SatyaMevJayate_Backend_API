package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.Criminal;
import com.satyamevjayate.api.services.Criminal_Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class Controller_criminal {
    @Autowired
    private Criminal_Services Criminal_Service;

    @GetMapping("/criminal")
    public List<Criminal> getAllCriminal() {
        return Criminal_Service.listAllCriminal();
    }

    @GetMapping("/criminal/{id}")
    public Criminal getCriminal(@PathVariable Long id)
    {
        Criminal w= Criminal_Service.getCriminal(id);
        return w;
    }

    @PostMapping("/criminal")
    public String addCriminal(@RequestBody Criminal w)
    {
        Criminal_Service.saveCriminal(w);
        return "Criminal Add successfully";

    }

    @DeleteMapping("/criminal/{id}")
    public String deleteCriminal(@PathVariable Long id)
    {
        Criminal_Service.deleteCriminal(id);
        return "Criminal Delete successfully";
    }

    @PutMapping("/criminal/{id}")
    public ResponseEntity<Object> editCriminal(@RequestBody Criminal Criminal, @PathVariable Long id) {


        Criminal.setCriminalID(id);

        Criminal_Service.editCriminal(Criminal);

        return ResponseEntity.noContent().build();
    }
    
//    @PutMapping("/criminal")
//    public ResponseEntity<Object> editCriminal(@RequestBody Criminal Criminal) {
//
//        Criminal_Service.saveCriminal(Criminal);
//
//        return ResponseEntity.noContent().build();
//    }

}
