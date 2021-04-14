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

import com.satyamevjayate.api.entity.LawAct;
import com.satyamevjayate.api.services.LawAct_Services;

@RestController
public class Contoller_LawAct {
	
	@Autowired
	private LawAct_Services LawAct_Service;
	
	@GetMapping("/LawActs")
	public List<LawAct> lawActs()
	{
		return LawAct_Service.listAll_LawAct();
	}
	
	@GetMapping("/LawAct/{id}")
	public LawAct getLawAct(@PathVariable BigInteger id)
	{
		LawAct l =LawAct_Service.get_Lawact(id);
		return l;
				
	}
	
	@PostMapping("/LawAct")
	public String addLawact(@RequestBody LawAct l)
	{
		LawAct_Service.save_LawAct(l);
		return "LawAct Add successfully";
	}
	
	@DeleteMapping("/DeleteLawAct/{id}")
	public String deleteLawAct(@PathVariable BigInteger id)
	{
		LawAct_Service.delete_Lawact(id);
		return "LawAct Delete successfully";
		
	}
	
	@PutMapping("/EditLawAct/{id}")
	public ResponseEntity<Object> editLawAct(@RequestBody LawAct lawact , @PathVariable BigInteger id)
	{
		lawact.setLawID(id);
		LawAct_Service.save_LawAct(lawact);
		return ResponseEntity.noContent().build();
	}
	
	

}
