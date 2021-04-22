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


import com.satyamevjayate.api.entity.PrisoningType;
import com.satyamevjayate.api.services.PrisoningType_Services;

@RestController
public class Controller_PrisoningType {
	
	@Autowired
	private PrisoningType_Services prisoningtype_services;
	
	@GetMapping("/prisoningtype")
	public List<PrisoningType> getAllPrisoningType() {
		return prisoningtype_services.listAllPrisoningType();
	}
	
	@GetMapping("/prisoningtype/{id}")
	public PrisoningType getPrisoningType(@PathVariable BigInteger id)
	{
		PrisoningType p= prisoningtype_services.getPrisoningType(id);
		return p;
	}
	
	@PostMapping("/prisoningtype")
	public String addPrisoningType(@RequestBody PrisoningType p)
	{
		prisoningtype_services.savePrisoningType(p);
		return "PrisoningType Add successfully";
		
	}
	
	@DeleteMapping("/prisoningtype/{id}")
	public String deletePrisoningType(@PathVariable BigInteger id)
	{
		prisoningtype_services.deletePrisoningType(id);
		return "PrisoningType Delete successfully";
	}
	
	@PutMapping("/prisoningtype/{id}")
	public ResponseEntity<Object> editPrisoningType(@RequestBody PrisoningType prisoningtype, @PathVariable BigInteger id) {

		
		prisoningtype.setPrisoningTypeId(id);
		
		prisoningtype_services.savePrisoningType(prisoningtype);

		return ResponseEntity.noContent().build();
	}
	

}
