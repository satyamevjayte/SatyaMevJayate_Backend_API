package com.satyamevjayate.api.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.satyamevjayate.api.entity.LawAct;
import com.satyamevjayate.api.services.LawAct_Services;

@RestController
@RequestMapping("/LawActs")
public class Contoller_LawAct {
	
	@Autowired
	private LawAct_Services LawAct_Service;

	@GetMapping("")
	public List<LawAct> lawActs()
	{
		return LawAct_Service.listAll_LawAct();
	}

	@GetMapping("/{id}")
	public LawAct getLawAct(@PathVariable BigInteger id)
	{
		LawAct l =LawAct_Service.get_Lawact(id);
		return l;

	}

	@PostMapping("")
	public String addLawact(@RequestBody LawAct l)
	{
		LawAct_Service.save_LawAct(l);
		return "LawAct Add successfully";
	}

	@DeleteMapping("/{id}")
	public String deleteLawAct(@PathVariable BigInteger id)
	{
		String res = LawAct_Service.delete_Lawact(id);
		return res;

	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> editLawAct(@RequestBody LawAct lawact , @PathVariable BigInteger id)
	{
		lawact.setLawID(id);
		LawAct_Service.save_LawAct(lawact);
		return ResponseEntity.noContent().build();
	}

	

}
