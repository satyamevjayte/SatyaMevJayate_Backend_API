package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Crime;
import com.satyamevjayate.api.entity.CrimeImage;
import com.satyamevjayate.api.entity.CrimeType;
import com.satyamevjayate.api.repo.CrimeImage_Repository;
import com.satyamevjayate.api.repo.Crime_Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CrimeImage_Services {
    @Autowired
    private CrimeImage_Repository CrimeImage_repo;
    
    @Autowired
    private Crime_Repository crime_repo;

    public List<CrimeImage> listAllCrimeImage()
    {
        return CrimeImage_repo.findAll();
    }

    public CrimeImage saveCrimeImage(CrimeImage CrimeImage)
    {
    	 Crime crime = crime_repo.findById(CrimeImage.getCrmImage().getCrimeID()).orElse(null);
	        if (null == crime) {
	            crime = new Crime();
	        }
	        crime.setCrimeID(CrimeImage.getCrmImage().getCrimeID());
	        CrimeImage.setCrmImage(crime);
	       
	     return CrimeImage_repo.save(CrimeImage);
    }

    public CrimeImage getCrimeImage(BigInteger Id)
    {
        return CrimeImage_repo.findById(Id).get();
    }

    public void deleteCrimeImage(BigInteger Id)
    {
        CrimeImage_repo.deleteById(Id);
    }
}
