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

import com.satyamevjayate.api.entity.Addresses;

import com.satyamevjayate.api.services.Addresses_Services;

@RestController
public class Controller_Addresses {
	
	@Autowired
	private Addresses_Services address_Services;
	
	@GetMapping("/address")
	public List<Addresses> getAllAddress() {
		return address_Services.listAllAddresses();
	}
	
	@GetMapping("/address/{id}")
	public Addresses getAddresses(@PathVariable BigInteger id)
	{
		Addresses address= address_Services.getAddress(id);
		return address;
	}
	
	@PostMapping("/address")
	public String addAddress(@RequestBody Addresses address)
	{
		address_Services.saveAddress(address);
		return "Address Add Successfully";
	}	
	
	
	@DeleteMapping("/address/{id}")
	public String deleteAddress(@PathVariable BigInteger id)
	{
		address_Services.deleteAddress(id);
	    return "Delete Address Successfully";
	}
	
	@PutMapping("/address/{id}")
	public ResponseEntity<Object> editAddress(@RequestBody Addresses address, @PathVariable BigInteger id) {

	

		address.setAddressID(id);;
		
		address_Services.saveAddress(address);

		return ResponseEntity.noContent().build();
	}
	

}
