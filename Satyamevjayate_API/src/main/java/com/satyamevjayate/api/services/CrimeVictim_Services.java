package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.*;
import com.satyamevjayate.api.model.Crimesuspectmodel;
import com.satyamevjayate.api.model.Crimevictimmodel;
import com.satyamevjayate.api.repo.Addresses_Repository;
import com.satyamevjayate.api.repo.Contact_Repository;
import com.satyamevjayate.api.repo.CrimeVictim_Repository;
import com.satyamevjayate.api.repo.Crime_Repository;
import com.satyamevjayate.api.repo.Person_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Crimevictimmodel listAllCrimeVictim()
    {
        Crimevictimmodel crimevictimmodel=new Crimevictimmodel();
        if(!CrimeVictim_repo.findAll().isEmpty()){
            crimevictimmodel.setMessage("All Record fetched Successfully");
            crimevictimmodel.setCrimeVictims(CrimeVictim_repo.findAll());
        }
        else{
            crimevictimmodel.setMessage("No Record in Crime Suspect");
        }
        return crimevictimmodel;
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

    public Crimevictimmodel getCrimeVictim(BigInteger Id)
    {
        Crimevictimmodel crimevictimmodel	=new Crimevictimmodel();
        Optional<CrimeVictim> crimeVictim=CrimeVictim_repo.findById(Id);
        if(crimeVictim.isPresent()){
            CrimeVictim crimeVictim1=new CrimeVictim();
            crimeVictim1=crimeVictim.get();
            List <CrimeVictim>cs=new ArrayList<>();
            cs.add(crimeVictim1);
            crimevictimmodel.setMessage("Record fetched Successfully!!");
            crimevictimmodel.setCrimeVictims(cs);
        }
        else{
            crimevictimmodel.setMessage("No Record in Crime Suspect");
        }
        return crimevictimmodel;
    }

    public String deleteCrimeVictim(BigInteger Id)
    {
        String res="";
        if (CrimeVictim_repo.findById(Id).isPresent()){
            CrimeVictim_repo.deleteById(Id);
            res="Record with "+Id+" id Deleted Successfully!!";
        }
        else{
            res="Record with "+Id+" id Does not exists!!";
        }
        return res;

    }
}
