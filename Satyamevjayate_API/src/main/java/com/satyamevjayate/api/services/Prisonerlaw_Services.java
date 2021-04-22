package com.satyamevjayate.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyamevjayate.api.entity.Prisonerlaw;
import com.satyamevjayate.api.repo.Prisonerlaw_Repository;

@Service
public class Prisonerlaw_Services {
	
	@Autowired
	private Prisonerlaw_Repository Prisonerlaw_Repo;
	
	
	public List<Prisonerlaw> listAllPrisonerlaw()
    {
        return Prisonerlaw_Repo.findAll();
    }

    public void savePrisonerlaw(Prisonerlaw prisonerlaw)
    {
    	Prisonerlaw_Repo.save(prisonerlaw);
    }

    public Prisonerlaw getPrisonerlaw(Long Id)
    {
        return Prisonerlaw_Repo.findById(Id).get();
    }

    public void deletePrisonerlaw(Long Id)
    {
    	Prisonerlaw_Repo.deleteById(Id);
    }

}
