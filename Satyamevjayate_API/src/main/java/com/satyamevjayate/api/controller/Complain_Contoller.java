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

import com.satyamevjayate.api.entity.Complain;
import com.satyamevjayate.api.services.Complain_Services;

@RestController
public class Complain_Contoller {
	
	@Autowired
	private Complain_Services Complain_Service;
	
	@GetMapping("/Complain")
	public List<Complain> complain()
	{
		return Complain_Service.listComplain();
	}
	
	@GetMapping("/LawAct/{id}")
	public Complain getLawAct(@PathVariable Long id)
	{
		Complain c =Complain_Service.get_Complain(id);
		return c;
				
	}
	
	@PostMapping("/complain")
	public String addLawact(@RequestBody Complain c)
	{
		Complain_Service.save_Complain(c);
		return "Complain Add successfully";
	}
	
	@DeleteMapping("/complain/{id}")
	public String deleteLawAct(@PathVariable Long id)
	{
		Complain_Service.delete_Complain(id);
		return "complain Delete successfully";
		
	}
	
	@PutMapping("/complain/{id}")
	public ResponseEntity<Object> editLawAct(@RequestBody Complain complain , @PathVariable Long id)
	{
		complain.setComplainID(id);
		Complain_Service.save_Complain(complain);
		return ResponseEntity.noContent().build();
	}
	

}
