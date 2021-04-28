package com.satyamevjayate.api.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.satyamevjayate.api.dto.PoliceRequest;
import com.satyamevjayate.api.entity.Crime;
import com.satyamevjayate.api.entity.Person;
import com.satyamevjayate.api.entity.Police;
import com.satyamevjayate.api.model.policeModel;
import com.satyamevjayate.api.repo.Addresses_Repository;
import com.satyamevjayate.api.repo.Police_Repository;
import com.satyamevjayate.api.services.Addresses_Services;
import com.satyamevjayate.api.services.Police_Services;


@RestController
public class Controller_Police {
	
	@Autowired
	private Police_Services police_services;
	
	@Autowired
	private Addresses_Repository address_repo;
	
	 @PostMapping("/police")
	 public String savePolice(@RequestBody Police police)
	 {
	 
	     police_services.savePolice(police);
	     return "police inserted";
	 }
	
	@GetMapping("/police")
	public List<Police> findAllPolice()
	{
		 return police_services.listAllPolice();
	}
	
	@GetMapping("/police/{id}")
	public policeModel getPolice(@PathVariable BigInteger id)
	{
	     policeModel policemodel= police_services.getPolice(id);
	     return policemodel;
	}
	
	@PutMapping("/police/{id}")
	public ResponseEntity<Object> editPolice(@RequestBody Police police, @PathVariable BigInteger id) 
	{

	     police.setPoliceID(id);

	     police_services.editPolice(police);

	     return ResponseEntity.noContent().build();
	}
	@DeleteMapping("/police/{id}")
    public String deletePolice(@PathVariable BigInteger id)
    {
        police_services.deletePolice(id);
        return "Delete Person Successfully";
    }


}
