package com.satyamevjayate.api.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyamevjayate.api.entity.Complain;
import com.satyamevjayate.api.repo.Complain_Respository;

@Service
public class Complain_Services {

	@Autowired
	private Complain_Respository Complain_Respo;
	
	 public List<Complain> listComplain()
     {
   	  return Complain_Respo.findAll();
     }
     
     public void save_Complain(Complain complain)
     {
    	 Complain_Respo.save(complain);
     }
     
     public Complain get_Complain(Long Id) 
     {
   	    return Complain_Respo.findById(Id).get();
     }
     
     public void  delete_Complain(Long Id) 
     {
    	 Complain_Respo.deleteById(Id);
     }
}
