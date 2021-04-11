package com.satyamevjayate.api.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.satyamevjayate.api.entity.PoliceRole;
import com.satyamevjayate.api.services.Police_Role_Services;

@RestController
public class Contoller_Police_Role {

	@Autowired
	private Police_Role_Services Police_Role_Service;

	@GetMapping("/GetAllPoliceRole")
	public List<PoliceRole> getAllPolice_Role() {
		return Police_Role_Service.listAll_Police_Role();
	}
	
	@GetMapping("/GetPoliceRole/{id}")
	public PoliceRole getPoliceRole(@PathVariable BigInteger id)
	{
		PoliceRole p= Police_Role_Service.getPolice_Role(id);
		return p;
	}
	
	@PostMapping("/AddPoliceRole")
	public String addPoliceRole(@RequestBody PoliceRole p)
	{
		Police_Role_Service.save_Police_Role(p);
		return "PoliceRole Add successfully";
		
	}
	
	@DeleteMapping("/DeletePoliceRole/{id}")
	public String deletePoliceRole(@PathVariable BigInteger id)
	{
		Police_Role_Service.delete_Police_Role(id);
		return "PoliceRole Delete successfully";
	}

}
