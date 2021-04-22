package com.satyamevjayate.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyamevjayate.api.entity.Prisoners;
import com.satyamevjayate.api.repo.Prisoners_Repository;

@Service
public class Prisoners_Services {
	
	@Autowired
	
	private Prisoners_Repository Prisoners_Repo;
	
	public List<Prisoners> listAllPrisoners()
    {
        return Prisoners_Repo.findAll();
    }

    public void savePrisoners(Prisoners Prisoners)
    {
    	Prisoners_Repo.save(Prisoners);
    }

    public Prisoners getPrisoners(Long Id)
    {
        return Prisoners_Repo.findById(Id).get();
    }

    public void deletePrisoners(Long Id)
    {
    	Prisoners_Repo.deleteById(Id);
    }

}
