package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Addresses;
import com.satyamevjayate.api.entity.Contact;
import com.satyamevjayate.api.entity.Criminal;
import com.satyamevjayate.api.entity.Person;
import com.satyamevjayate.api.repo.Addresses_Repository;
import com.satyamevjayate.api.repo.Contact_Repository;
import com.satyamevjayate.api.repo.Criminal_Repository;
import com.satyamevjayate.api.repo.Person_Repository;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public class Criminal_Services {
    @Autowired
    private Criminal_Repository Criminal_repo;
    
    @Autowired
    private Addresses_Repository address_repo;
    
    @Autowired
    private Contact_Repository contact_repo;
    
    @Autowired
    private Person_Repository person_repo;

    public List<Criminal> listAllCriminal()
    {
        return Criminal_repo.findAll();
    }

    public Criminal saveCriminal(Criminal Criminal)
    {
    	 Addresses address = address_repo.findById(Criminal.getCriminaladdress().getAddressID()).orElse(null);
	        if (null == address) {
	            address = new Addresses();
	        }
	        address.setAddressLine1(Criminal.getCriminaladdress().getAddressLine1());
	        address.setAddressLine2(Criminal.getCriminaladdress().getAddressLine2());
	        address.setCity(Criminal.getCriminaladdress().getCity());
	        address.setCountry(Criminal.getCriminaladdress().getCountry());
	        address.setState(Criminal.getCriminaladdress().getState());
	        address.setZipCode(Criminal.getCriminaladdress().getZipCode());
	        Criminal.setCriminaladdress(address);
	        
	    Contact contact=contact_repo.findById(Criminal.getCriminalcontact().getContactId()).orElse(null);
	    	if(null==contact)
	    	{
	    		contact=new Contact();
	    	}
	    	contact.setContactNumber(Criminal.getCriminalcontact().getContactNumber());
		    contact.setContactEmail(Criminal.getCriminalcontact().getContactEmail());
		    Criminal.setCriminalcontact(contact);
		    
		Person person = person_repo.findById(Criminal.getCriminalperson().getPerson_Id()).orElse(null);
	        if (null == person) {
	            person = new Person();
	        }
	        person.setFirst_Name(Criminal.getCriminalperson().getFirst_Name());
	        person.setLast_Name(Criminal.getCriminalperson().getLast_Name());
	        person.setGender(Criminal.getCriminalperson().getGender());
	        person.setDate_of_birth(Criminal.getCriminalperson().getDate_of_birth());
	        person.setPerson_Image(Criminal.getCriminalperson().getPerson_Image());
	        Criminal.setCriminalperson(person);
        
	     return Criminal_repo.save(Criminal);
    }

    public Criminal getCriminal(Long Id)
    {
        return Criminal_repo.findById(Id).get();
    }

    public void deleteCriminal(Long Id)
    {
        Criminal_repo.deleteById(Id);
    }
}
