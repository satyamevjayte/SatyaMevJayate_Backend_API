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

import com.satyamevjayate.api.entity.Prisoners;
import com.satyamevjayate.api.services.Prisoners_Services;

@RestController
public class Prisoners_Controller {

	
	@Autowired
	private Prisoners_Services Prisoners_Service;
	
	@GetMapping("/Prisoners")
    public List<Prisoners> getAllPrisoners() {
        return Prisoners_Service.listAllPrisoners();
    }

    @GetMapping("/Prisoners/{id}")
    public Prisoners getPrisoners(@PathVariable Long id)
    {
    	Prisoners w= Prisoners_Service.getPrisoners(id);
        return w;
    }

    @PostMapping("/Prisoners")
    public String addPrisoners(@RequestBody Prisoners w)
    {
    	Prisoners_Service.savePrisoners(w);
        return "Prisoners Add successfully";

    }

    @DeleteMapping("/Prisoners/{id}")
    public String deletePrisoners(@PathVariable Long id)
    {
    	Prisoners_Service.deletePrisoners(id);
        return "Prisoners Delete successfully";
    }

    @PutMapping("/Prisoners/{id}")
    public ResponseEntity<Object> editPrisoners(@RequestBody Prisoners prisoners, @PathVariable Long id) {


    	prisoners.setPrisonerID(id);
    	Prisoners_Service.savePrisoners(prisoners);

        return ResponseEntity.noContent().build();
    }
}
