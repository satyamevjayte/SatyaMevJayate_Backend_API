package com.satyamevjayate.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.satyamevjayate.api.entity.Complain;
import com.satyamevjayate.api.services.Complain_Services;

@RestController
@RequestMapping("/Complain")
public class Complain_Contoller {
	
	@Autowired
	private Complain_Services Complain_Service;
	
	@GetMapping("")
	public List<Complain> complain()
	{
		return Complain_Service.listComplain();
	}
	
	@GetMapping("/{id}")
	public Complain getLawAct(@PathVariable Long id)
	{
		Complain c =Complain_Service.get_Complain(id);
		return c;
				
	}
	
	@PostMapping("")
	public String addLawact(@RequestBody Complain c)
	{
		Complain_Service.save_Complain(c);
		return "Complain Add successfully";
	}
	
	@DeleteMapping("/{id}")
	public String deleteLawAct(@PathVariable Long id)
	{
		Complain_Service.delete_Complain(id);
		return "complain Delete successfully";
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> editLawAct(@RequestBody Complain complain , @PathVariable Long id)
	{
		complain.setComplainID(id);
		Complain_Service.save_Complain(complain);
		return ResponseEntity.noContent().build();
	}
	

}
