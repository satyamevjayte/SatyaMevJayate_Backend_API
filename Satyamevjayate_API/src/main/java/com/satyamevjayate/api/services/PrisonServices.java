package com.satyamevjayate.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyamevjayate.api.entity.Prison;
import com.satyamevjayate.api.repo.Prison_Respository;

@Service
public class PrisonServices {
	
	@Autowired
	private Prison_Respository Prison_Respo;
	
	
	public List<Prison> listAllPrison()
    {
        return Prison_Respo.findAll();
    }

    public void savePrison(Prison prison)
    {
    	Prison_Respo.save(prison);
    }

    public Prison getPrison(Long Id)
    {
        return Prison_Respo.findById(Id).get();
    }

    public void deletePrison(Long Id)
    {
    	Prison_Respo.deleteById(Id);
    }
	

}
