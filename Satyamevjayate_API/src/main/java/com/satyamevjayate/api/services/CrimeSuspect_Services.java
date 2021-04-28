package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Addresses;
import com.satyamevjayate.api.entity.Contact;
import com.satyamevjayate.api.entity.Crime;
import com.satyamevjayate.api.entity.CrimeSuspect;
import com.satyamevjayate.api.entity.Person;
import com.satyamevjayate.api.repo.Addresses_Repository;
import com.satyamevjayate.api.repo.Contact_Repository;
import com.satyamevjayate.api.repo.CrimeSuspect_Repository;
import com.satyamevjayate.api.repo.Crime_Repository;
import com.satyamevjayate.api.repo.Person_Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CrimeSuspect_Services {
    @Autowired
    private CrimeSuspect_Repository CrimeSuspect_repo;
    
    @Autowired
    private Addresses_Repository address_repo;
    
    @Autowired
    private Contact_Repository contact_repo;
    
    @Autowired
    private Person_Repository person_repo;
    
    @Autowired
    private Crime_Repository crime_repo;
    

    public List<CrimeSuspect> listAllCrimeSuspect()
    {
        return CrimeSuspect_repo.findAll();
    }

    public CrimeSuspect saveCrimeSuspect(CrimeSuspect CrimeSuspect)
    {
    	
    	 Addresses address = address_repo.findById(CrimeSuspect.getSusaddress().getAddressID()).orElse(null);
	        if (null == address) {
	            address = new Addresses();
	        }
	        address.setAddressLine1(CrimeSuspect.getSusaddress().getAddressLine1());
	        address.setAddressLine2(CrimeSuspect.getSusaddress().getAddressLine2());
	        address.setCity(CrimeSuspect.getSusaddress().getCity());
	        address.setCountry(CrimeSuspect.getSusaddress().getCountry());
	        address.setState(CrimeSuspect.getSusaddress().getState());
	        address.setZipCode(CrimeSuspect.getSusaddress().getZipCode());
	        CrimeSuspect.setSusaddress(address);
	        
	    Contact contact=contact_repo.findById(CrimeSuspect.getSuscontact().getContactId()).orElse(null);
	    	if(null==contact)
	    	{
	    		contact=new Contact();
	    	}
	    	contact.setContactNumber(CrimeSuspect.getSuscontact().getContactNumber());
		    contact.setContactEmail(CrimeSuspect.getSuscontact().getContactEmail());
		    CrimeSuspect.setSuscontact(contact);
		    
		Person person = person_repo.findById(CrimeSuspect.getSusperson().getPerson_Id()).orElse(null);
	        if (null == person) {
	            person = new Person();
	        }
	        person.setFirst_Name(CrimeSuspect.getSusperson().getFirst_Name());
	        person.setLast_Name(CrimeSuspect.getSusperson().getLast_Name());
	        person.setGender(CrimeSuspect.getSusperson().getGender());
	        person.setDate_of_birth(CrimeSuspect.getSusperson().getDate_of_birth());
	        person.setPerson_Image(CrimeSuspect.getSusperson().getPerson_Image());
	        CrimeSuspect.setSusperson(person);
	           
	    Crime crime = crime_repo.findById(CrimeSuspect.getCrimeid().getCrimeID()).orElse(null);
	        if (null == crime) {
	            crime = new Crime();
	        }
	        crime.setCrimeID(CrimeSuspect.getCrimeid().getCrimeID());
	        CrimeSuspect.setCrimeid(crime);
	        
	    return CrimeSuspect_repo.save(CrimeSuspect);
    }
    public CrimeSuspect getCrimeSuspect(BigInteger Id)
    {
        return CrimeSuspect_repo.findById(Id).get();
    }

    public void deleteCrimeSuspect(BigInteger Id)
    {
        CrimeSuspect_repo.deleteById(Id);
    }
}
