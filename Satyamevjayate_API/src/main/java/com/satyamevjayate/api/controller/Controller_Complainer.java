package com.satyamevjayate.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.satyamevjayate.api.entity.Complainer;
import com.satyamevjayate.api.services.Complainer_Services;

@RestController
public class Controller_Complainer {
	
	@Autowired
	 private Complainer_Services  Complainer_Service;
	
	@GetMapping("/Complainers")
    public List<Complainer> getAllComplainer() {
        return Complainer_Service.listAllComplainer();
    }

    @GetMapping("/Complainer/{id}")
    public Complainer getComplainer(@PathVariable Long id)
    {

    	Complainer complainer= Complainer_Service.getComplainer(id);
        return complainer;

    }

    @PostMapping("/Complainer")
    public String addComplainer(@RequestBody Complainer complainer)
    {
    	Complainer_Service.saveComplainer(complainer);
        return "Complainer Add Successfully";
    }


    @DeleteMapping("/Complainer/{id}")
    public String deleteComplainer(@PathVariable Long id)
    {
    	Complainer_Service.deleteComplainer(id);
        return "Delete Complainer Successfully";
    }
    @PutMapping("/Complainer/{id}")
    public ResponseEntity<Object> editWorkerDocument(@RequestBody Complainer complainer, @PathVariable Long id) {

    	complainer.setComplainerID(id);
    	Complainer_Service.saveComplainer(complainer);

        return ResponseEntity.noContent().build();
}
 
	 

}
