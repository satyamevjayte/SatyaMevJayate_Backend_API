package com.satyamevjayate.api.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyamevjayate.api.entity.Addresses;
import com.satyamevjayate.api.entity.Contact;
import com.satyamevjayate.api.entity.Person;
import com.satyamevjayate.api.entity.Police;
import com.satyamevjayate.api.entity.PoliceRole;
import com.satyamevjayate.api.entity.PoliceStation;
import com.satyamevjayate.api.model.policeModel;
import com.satyamevjayate.api.repo.Addresses_Repository;
import com.satyamevjayate.api.repo.Contact_Repository;
import com.satyamevjayate.api.repo.Person_Repository;
import com.satyamevjayate.api.repo.PoliceStation_Repository;
import com.satyamevjayate.api.repo.Police_Repository;
import com.satyamevjayate.api.repo.Police_Role_Repository;

@Service
public class Police_Services {
	
	@Autowired
	private Police_Repository police_repo;
	
	@Autowired
	private Addresses_Repository address_repo;
	
	@Autowired
	private Contact_Repository contact_repo;
	
	@Autowired
	private Person_Repository person_repo;
	
	@Autowired
	private Police_Role_Repository policerole_repo;
	
	@Autowired
	private PoliceStation_Repository policestation_repo;
	
	
	public List<Police> listAllPolice()
	{
		return police_repo.findAll();
	}
	
	public Police editPolice(Police police)
	{
		
		 Addresses address = address_repo.findById(police.getPoliceaddress().getAddressID()).orElse(null);
	        if (null == address) {
	            address = new Addresses();
	        }
	        address.setAddressLine1(police.getPoliceaddress().getAddressLine1());
	        address.setAddressLine2(police.getPoliceaddress().getAddressLine2());
	        address.setCity(police.getPoliceaddress().getCity());
	        address.setCountry(police.getPoliceaddress().getCountry());
	        address.setState(police.getPoliceaddress().getState());
	        address.setZipCode(police.getPoliceaddress().getZipCode());
	        
	     
	        police.setPoliceaddress(address);
	        
	    Contact contact=contact_repo.findById(police.getPolicecontact().getContactId()).orElse(null);
	    	if(null==contact)
	    	{
	    		contact=new Contact();
	    	}
	    	contact.setContactNumber(police.getPolicecontact().getContactNumber());
		    contact.setContactEmail(police.getPolicecontact().getContactEmail());
		
		    police.setPolicecontact(contact);
		    
		Person person = person_repo.findById(police.getPerson().getPerson_Id()).orElse(null);
	        if (null == person) {
	        	person = new Person();
	        }
	        person.setFirst_Name(police.getPerson().getFirst_Name());
	        person.setLast_Name(police.getPerson().getLast_Name());
	        person.setGender(police.getPerson().getGender());
	        person.setDate_of_birth(police.getPerson().getDate_of_birth());
	        person.setPerson_Image(police.getPerson().getPerson_Image());
	        
	       
	        police.setPerson(person);
	        PoliceStation policestation = policestation_repo.findById(police.getPolicestation().getPoliceStationID()).orElse(null);
	        if (null == policestation) {
	        	policestation=new PoliceStation();
	        }   
		    
		    
		    policestation.setPolicestationaddress(police.getPolicestation().getPolicestationaddress());
		    policestation.setPolicestationcontact(police.getPolicestation().getPolicestationcontact());
		    policestation.setStationName(police.getPolicestation().getStationName());
		    
		  
		    police.setPolicestation(policestation);

		    PoliceRole policerole = policerole_repo.findById(police.getPoliceRole().getRoleID()).orElse(null);
	        if (null == policerole) {
	        	  policerole=new PoliceRole();
	        }  
	        
		   
		    policerole.setRoleName(police.getPoliceRole().getRoleName());
		   
		    police.setPoliceRole(policerole);
		    
	        
	        return police_repo.save(police);
		
		
		
	}
	
	public policeModel getPolice(BigInteger Id)
	{
		
		
		policeModel policemodel =new policeModel();
		Optional<Police> police=police_repo.findById(Id);
		if(police.isPresent()){
		   Police police1=new Police();
		   police1=police.get();
		   List <Police>ps=new ArrayList<>();
		   ps.add(police1);
		   policemodel.setMessage("Record fetched Successfully!!");
		   policemodel.setPolice(ps);
		}
		else{
		   policemodel.setMessage("No Record in Police");
		}
		return policemodel;
		
//		return police_repo.findById(Id).get();
	}
	
	public Police savePolice(Police police)
	{
		
//		 Addresses address = address_repo.findById(police.getAddress().getAddressID()).orElse(null);
//	        if (null == address) {
	          Addresses  address = new Addresses();
//	        }
	        address.setAddressLine1(police.getPoliceaddress().getAddressLine1());
	        address.setAddressLine2(police.getPoliceaddress().getAddressLine2());
	        address.setCity(police.getPoliceaddress().getCity());
	        address.setCountry(police.getPoliceaddress().getCountry());
	        address.setState(police.getPoliceaddress().getState());
	        address.setZipCode(police.getPoliceaddress().getZipCode());
	        
	        address_repo.save(address);
	        police.setPoliceaddress(address);
	        
//	    Contact contact=contact_repo.findById(police.getContact().getContactId()).orElse(null);
//	    	if(null==contact)
//	    	{
	    	Contact	contact=new Contact();
//	    	}
	    	contact.setContactNumber(police.getPolicecontact().getContactNumber());
		    contact.setContactEmail(police.getPolicecontact().getContactEmail());
		    contact_repo.save(contact);
		    police.setPolicecontact(contact);
		    
//		Person person = person_repo.findById(police.getPerson().getPerson_Id()).orElse(null);
//	        if (null == person) {
	         Person person = new Person();
//	        }
	        person.setFirst_Name(police.getPerson().getFirst_Name());
	        person.setLast_Name(police.getPerson().getLast_Name());
	        person.setGender(police.getPerson().getGender());
	        person.setDate_of_birth(police.getPerson().getDate_of_birth());
	        person.setPerson_Image(police.getPerson().getPerson_Image());
	        
	        person_repo.save(person);
	        police.setPerson(person);
	           
		    PoliceStation policestation=new PoliceStation();
		    
		    policestation.setPolicestationaddress(police.getPolicestation().getPolicestationaddress());
		    policestation.setPolicestationcontact(police.getPolicestation().getPolicestationcontact());
		    policestation.setStationName(police.getPolicestation().getStationName());
		    
		    policestation_repo.save(policestation);
		    police.setPolicestation(policestation);

		    PoliceRole policerole=new PoliceRole();
		    policerole.setRoleName(police.getPoliceRole().getRoleName());
		    policerole_repo.save(policerole);
		    police.setPoliceRole(policerole);
		    
	        
	        return police_repo.save(police);
		
		
		
	}
		
	public void deletePolice(BigInteger Id)
	{
		police_repo.deleteById(Id);
	}
	

}
