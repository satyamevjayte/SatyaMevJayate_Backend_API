package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.*;
import com.satyamevjayate.api.repo.Addresses_Repository;
import com.satyamevjayate.api.repo.Contact_Repository;
import com.satyamevjayate.api.repo.CrimeVictim_Repository;
import com.satyamevjayate.api.repo.Crime_Repository;
import com.satyamevjayate.api.repo.Person_Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
@Service
public class CrimeVictim_Services {
    @Autowired
    private CrimeVictim_Repository CrimeVictim_repo;
    
    @Autowired
    private Addresses_Repository address_repo;
    
    @Autowired
    private Contact_Repository contact_repo;
    
    @Autowired
    private Person_Repository person_repo;
    
    @Autowired
    private Crime_Repository crime_repo;

    public List<CrimeVictim> listAllCrimeVictim()
    {
        return CrimeVictim_repo.findAll();
    }

    public CrimeVictim saveCrimeVictim(CrimeVictim CrimeVictim)
    {

		Addresses address =new Addresses();

		address.setAddressLine1(CrimeVictim.getVictimaddress().getAddressLine1());
		address.setAddressLine2(CrimeVictim.getVictimaddress().getAddressLine2());
		address.setCity(CrimeVictim.getVictimaddress().getCity());
		address.setCountry(CrimeVictim.getVictimaddress().getCountry());
		address.setState(CrimeVictim.getVictimaddress().getState());
		address.setZipCode(CrimeVictim.getVictimaddress().getZipCode());
		address_repo.save(address);
		CrimeVictim.setVictimaddress(address);

		Contact contact=new Contact();

		contact.setContactNumber(CrimeVictim.getCrmvictimecontact().getContactNumber());
		contact.setContactEmail(CrimeVictim.getCrmvictimecontact().getContactEmail());
		contact_repo.save(contact);
		CrimeVictim.setCrmvictimecontact(contact);

		Person person =  new Person();

		person.setFirst_Name(CrimeVictim.getVictimperson().getFirst_Name());
		person.setLast_Name(CrimeVictim.getVictimperson().getLast_Name());
		person.setGender(CrimeVictim.getVictimperson().getGender());
		person.setDate_of_birth(CrimeVictim.getVictimperson().getDate_of_birth());
		person.setPerson_Image(CrimeVictim.getVictimperson().getPerson_Image());
		person_repo.save(person);
		CrimeVictim.setVictimperson(person);



		return CrimeVictim_repo.save(CrimeVictim);
    }

    public CrimeVictim getCrimeVictim(BigInteger Id)
    {
        return CrimeVictim_repo.findById(Id).get();
    }

    public void deleteCrimeVictim(BigInteger Id)
    {
        CrimeVictim_repo.deleteById(Id);
    }
}
