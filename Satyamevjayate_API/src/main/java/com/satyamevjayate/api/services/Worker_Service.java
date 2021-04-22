package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Addresses;
import com.satyamevjayate.api.entity.Contact;
import com.satyamevjayate.api.entity.Person;
import com.satyamevjayate.api.entity.Worker;
import com.satyamevjayate.api.repo.Addresses_Repository;
import com.satyamevjayate.api.repo.Contact_Repository;
import com.satyamevjayate.api.repo.Person_Repository;
import com.satyamevjayate.api.repo.Worker_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
@Service
public class Worker_Service {
    @Autowired
    private Worker_Repository Worker_repo;
    
    @Autowired
    private Addresses_Repository address_repo;
    
    @Autowired
    private Contact_Repository contact_repo;
    
    @Autowired
    private Person_Repository person_repo;
    

    public List<Worker> listAllWorker()
    {
        return Worker_repo.findAll();
    }

    public Worker saveWorker(Worker worker)
    {
    	Addresses address = address_repo.findById(worker.getWorkeraddress().getAddressID()).orElse(null);
        if (null == address) {
            address = new Addresses();
        }
        address.setAddressLine1(worker.getWorkeraddress().getAddressLine1());
        address.setAddressLine2(worker.getWorkeraddress().getAddressLine2());
        address.setCity(worker.getWorkeraddress().getCity());
        address.setCountry(worker.getWorkeraddress().getCountry());
        address.setState(worker.getWorkeraddress().getState());
        address.setZipCode(worker.getWorkeraddress().getZipCode());
        worker.setWorkeraddress(address);
        
    Contact contact=contact_repo.findById(worker.getWorkercontact().getContactID()).orElse(null);
    	if(null==contact)
    	{
    		contact=new Contact();
    	}
    	contact.setContactNumber(worker.getWorkercontact().getContactNumber());
	    contact.setContactEmail(worker.getWorkercontact().getContactEmail());
	    worker.setWorkercontact(contact);
	    
	Person person = person_repo.findById(worker.getWorkerperson().getPerson_Id()).orElse(null);
        if (null == person) {
            person = new Person();
        }
        person.setFirst_Name(worker.getWorkerperson().getFirst_Name());
        person.setLast_Name(worker.getWorkerperson().getLast_Name());
        person.setGender(worker.getWorkerperson().getGender());
        person.setDate_of_birth(worker.getWorkerperson().getDate_of_birth());
        person.setPerson_Image(worker.getWorkerperson().getPerson_Image());
        worker.setWorkerperson(person);
       return Worker_repo.save(worker);
    }

    public Worker getWorker(BigInteger Id)
    {
        return Worker_repo.findById(Id).get();
    }

    public void deleteWorker(BigInteger Id)
    {
        Worker_repo.deleteById(Id);
    }
}
