package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Addresses;
import com.satyamevjayate.api.entity.Contact;
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
    	 Addresses address = address_repo.findById(PoliceStation.getPolicestationaddress().getAddressID()).orElse(null);
	        if (null == address) {
	            address = new Addresses();
	        }
	        address.setAddressLine1(PoliceStation.getPolicestationaddress().getAddressLine1());
	        address.setAddressLine2(PoliceStation.getPolicestationaddress().getAddressLine2());
	        address.setCity(PoliceStation.getPolicestationaddress().getCity());
	        address.setCountry(PoliceStation.getPolicestationaddress().getCountry());
	        address.setState(PoliceStation.getPolicestationaddress().getState());
	        address.setZipCode(PoliceStation.getPolicestationaddress().getZipCode());
	        PoliceStation.setPolicestationaddress(address);
	        
	    Contact contact=contact_repo.findById(PoliceStation.getPolicestationcontact().getContactId()).orElse(null);
	    	if(null==contact)
	    	{
	    		contact=new Contact();
	    	}
	    	contact.setContactNumber(PoliceStation.getPolicestationcontact().getContactNumber());
		    contact.setContactEmail(PoliceStation.getPolicestationcontact().getContactEmail());
		    PoliceStation.setPolicestationcontact(contact);
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
