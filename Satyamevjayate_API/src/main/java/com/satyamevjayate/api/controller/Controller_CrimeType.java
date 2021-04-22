package com.satyamevjayate.api.controller;

import java.math.BigInteger;
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


import com.satyamevjayate.api.entity.CrimeType;
import com.satyamevjayate.api.services.CrimeType_Services;

@RestController
public class Controller_CrimeType {

	@Autowired
	private CrimeType_Services crimetype_Services;
	
	@GetMapping("/crimetype")
	public List<CrimeType> getAllCrimeType() {
		return crimetype_Services.listAllCrimeType();
	}
	
	@GetMapping("/crimetype/{id}")
	public CrimeType getCrimeType(@PathVariable BigInteger id)
	{
		
			CrimeType crimetype= crimetype_Services.getCrimeType(id);
			return crimetype;
	
		
		
	}
	
	@PostMapping("/crimetype")
	public String addCrimeType(@RequestBody CrimeType crimetype)
	{
		crimetype_Services.saveCrimeType(crimetype);;
		return "CrimeType Add Successfully";
	}	
	
	
	@DeleteMapping("/crimetype/{id}")
	public String deleteCrimeType(@PathVariable BigInteger id)
	{
		crimetype_Services.deleteCrimeType(id);;
	    return "Delete CrimeType Successfully";
	}
	
	@PutMapping("/crimetype/{id}")
	public ResponseEntity<Object> editCrimeType(@RequestBody CrimeType crimetype, @PathVariable BigInteger id) {

		crimetype.setCrimeTypeId(id);
		
		crimetype_Services.saveCrimeType(crimetype);

		return ResponseEntity.noContent().build();
	}

}
