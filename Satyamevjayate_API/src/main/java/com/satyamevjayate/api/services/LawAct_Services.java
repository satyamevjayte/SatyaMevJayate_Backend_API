package com.satyamevjayate.api.services;
import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyamevjayate.api.entity.LawAct;

import com.satyamevjayate.api.repo.LawAct_Repository;

@Service
public class LawAct_Services {
	@Autowired
	private LawAct_Repository LawAct_Repo;
	
      public List<LawAct> listAll_LawAct()
      {
    	  return LawAct_Repo.findAll();
      }
      
      public void save_LawAct(LawAct lawact)
      {
    	  LawAct_Repo.save(lawact);
      }
      
      public LawAct get_Lawact(BigInteger Id) 
      {
    	  return LawAct_Repo.findById(Id).get();
      }
      
      public String  delete_Lawact(BigInteger Id)
      {
          String res="";
          if(!LawAct_Repo.findAllById((Iterable<BigInteger>) Id).isEmpty()){
              LawAct_Repo.deleteById(Id);
              res="LawAct with "+Id+" is Delete successfully";
          }
          else{
              res="LawAct with "+Id+" is does not exists";
          }
    	   return res;
      }
      

}
