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

import com.satyamevjayate.api.entity.Prison;
import com.satyamevjayate.api.services.PrisonServices;

@RestController
public class Prison_Contorller {

	
	@Autowired
	private PrisonServices PrisonService;
	
	 @GetMapping("/Prison")
	    public List<Prison> getAllPrison() {
	        return PrisonService.listAllPrison();
	    }

	    @GetMapping("/Prison/{id}")
	    public Prison getPrison(@PathVariable Long id)
	    {
	    	Prison w= PrisonService.getPrison(id);
	        return w;
	    }

	    @PostMapping("/Prison")
	    public String addPrison(@RequestBody Prison w)
	    {
	    	PrisonService.savePrison(w);
	        return "Prison Add successfully";

	    }

	    @DeleteMapping("/Prison/{id}")
	    public String deletePrison(@PathVariable Long id)
	    {
	    	PrisonService.deletePrison(id);
	        return "Prison Delete successfully";
	    }

	    @PutMapping("/Prison/{id}")
	    public ResponseEntity<Object> editprison(@RequestBody Prison prison, @PathVariable Long id) {


	    	prison.setPrisonID(id);

	    	PrisonService.savePrison(prison);

	        return ResponseEntity.noContent().build();
	    }
}
