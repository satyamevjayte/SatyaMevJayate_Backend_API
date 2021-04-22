package com.satyamevjayate.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyamevjayate.api.entity.Complainer;
import com.satyamevjayate.api.repo.Complainer_Repository;

@Service
public class Complainer_Services {
	
	
	 @Autowired
	    private Complainer_Repository Complainer_Repo;
	 
	 
	 public List<Complainer> listAllComplainer()
	    {
	        return Complainer_Repo.findAll();
	    }

	    public void saveComplainer(Complainer complainer)
	    {
	    	Complainer_Repo.save(complainer);
	    }

	    public Complainer getComplainer(Long Id)
	    {
	        return Complainer_Repo.findById(Id).get();
	    }

	    public void deleteComplainer(Long Id)
	    {
	    	Complainer_Repo.deleteById(Id);
	    }

}
