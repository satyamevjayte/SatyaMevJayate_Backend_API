package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Addresses;
import com.satyamevjayate.api.entity.Crime;
import com.satyamevjayate.api.entity.CrimeType;
import com.satyamevjayate.api.repo.Addresses_Repository;
import com.satyamevjayate.api.repo.CrimeType_Repository;
import com.satyamevjayate.api.repo.Crime_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class Crime_Services {
    @Autowired
    private Crime_Repository Crime_repo;
    
    @Autowired
    private Addresses_Repository address_repo;
    
    @Autowired
    private CrimeType_Repository crimetype_repo;

    public List<Crime> listAllCrime()
    {
        return Crime_repo.findAll();
    }

    public Crime saveCrime(Crime Crime)
    {
//    	 Addresses address = address_repo.findById(Crime.getCrmaddress().getAddressID()).orElse(null);
//	        if (null == address) {
	          
	           Addresses address = new Addresses();
//	        }
	        address.setAddressLine1(Crime.getCrmaddress().getAddressLine1());
	        address.setAddressLine2(Crime.getCrmaddress().getAddressLine2());
	        address.setCity(Crime.getCrmaddress().getCity());
	        address.setCountry(Crime.getCrmaddress().getCountry());
	        address.setState(Crime.getCrmaddress().getState());
	        address.setZipCode(Crime.getCrmaddress().getZipCode());
	        address_repo.save(address);
	        Crime.setCrmaddress(address);
//    	System.out.println(Crime.getCrmtype().getCrimeTypeId());
//	      CrimeType crimetype = crimetype_repo.findById(Crime.getCrmtype().getCrimeTypeId()).orElse(new CrimeType());
//	        if (null == crimetype) {
	           CrimeType crimetype = new CrimeType();
//	        }
//	           crimetype.setCrimeType(Crime.getCrmtype().getCrimeType());
	        crimetype.setCrimeType(Crime.getCrmtype().getCrimeType());
	        crimetype_repo.save(crimetype);
	        Crime.setCrmtype(crimetype);
	        return Crime_repo.save(Crime);
    }

    public Crime getCrime(BigInteger Id)
    {
        return Crime_repo.findById(Id).get();
    }

    public void deleteCrime(BigInteger Id)
    {
        Crime_repo.deleteById(Id);
    }

}
