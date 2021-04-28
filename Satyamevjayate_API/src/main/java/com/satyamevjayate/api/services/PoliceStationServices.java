package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Addresses;
import com.satyamevjayate.api.entity.Contact;
import com.satyamevjayate.api.entity.CrimeType;
import com.satyamevjayate.api.entity.PoliceStation;
import com.satyamevjayate.api.repo.Addresses_Repository;
import com.satyamevjayate.api.repo.Contact_Repository;
import com.satyamevjayate.api.repo.PoliceStation_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
@Service
public class PoliceStationServices {
    @Autowired
    private PoliceStation_Repository PoliceStation_Repo;
    
    @Autowired
    private Addresses_Repository address_repo;
    @Autowired
    private Contact_Repository contact_repo;

    public List<PoliceStation> listAll_PoliceStation()
    {
        System.out.println(PoliceStation_Repo.findAll());
        return PoliceStation_Repo.findAll();
    }

    public PoliceStation save_PoliceStation(PoliceStation PoliceStation)
    {
	
    	  Addresses address = new Addresses();
    	  address.setAddressLine1(PoliceStation.getPsAddress().getAddressLine1());
	        address.setAddressLine2(PoliceStation.getPsAddress().getAddressLine2());
	        address.setCity(PoliceStation.getPsAddress().getCity());
	        address.setCountry(PoliceStation.getPsAddress().getCountry());
	        address.setState(PoliceStation.getPsAddress().getState());
	        address.setZipCode(PoliceStation.getPsAddress().getZipCode());
	        address_repo.save(address);
	        PoliceStation.setPsAddress(address);
	        
	        Contact contact = new Contact();
	        
	        contact.setContactNumber(PoliceStation.getPscontact().getContactNumber());
	        contact.setContactEmail(PoliceStation.getPscontact().getContactEmail());
	        contact_repo.save(contact);
	        PoliceStation.setPscontact(contact);
		 
       return PoliceStation_Repo.save(PoliceStation);
    }

    public PoliceStation getPoliceStation(BigInteger Id)
    {
        return PoliceStation_Repo.findById(Id).get();
    }

    public void delete_PoliceStation(BigInteger Id)
    {
        PoliceStation_Repo.deleteById(Id);
    }

}
