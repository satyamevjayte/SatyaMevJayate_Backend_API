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

import com.satyamevjayate.api.entity.Prisonerlaw;
import com.satyamevjayate.api.services.Prisonerlaw_Services;

@RestController
public class Prisonerlaw_Controller {

	
	@Autowired
	private Prisonerlaw_Services Prisonerlaw_Service;
	
	  @GetMapping("/Prisonerlaw")
	    public List<Prisonerlaw> getAllPrisonerlaw() {
	        return Prisonerlaw_Service.listAllPrisonerlaw();
	    }

	    @GetMapping("/Prisonerlaw/{id}")
	    public Prisonerlaw getPrisonerlaw(@PathVariable Long id)
	    {
	    	Prisonerlaw w= Prisonerlaw_Service.getPrisonerlaw(id);
	        return w;
	    }

	    @PostMapping("/Prisonerlaw")
	    public String addPrisonerlaw(@RequestBody Prisonerlaw w)
	    {
	    	Prisonerlaw_Service.savePrisonerlaw(w);
	        return "Prisonerlaw Add successfully";

	    }

	    @DeleteMapping("/Prisonerlaw/{id}")
	    public String deletePrisonerlaw(@PathVariable Long id)
	    {
	    	Prisonerlaw_Service.deletePrisonerlaw(id);
	        return "Prisonerlaw Delete successfully";
	    }

	    @PutMapping("/Prisonerlaw/{id}")
	    public ResponseEntity<Object> editPrisonerlaw(@RequestBody Prisonerlaw prisonerlaw, @PathVariable Long id) {


	    	prisonerlaw.setPrisonerLawID(id);

	        Prisonerlaw_Service.savePrisonerlaw(prisonerlaw);

	        return ResponseEntity.noContent().build();
	    }
}
