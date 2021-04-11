package com.satyamevjayate.api.services;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.satyamevjayate.api.entity.CrimeType;
import com.satyamevjayate.api.repo.CrimeType_Repository;

@Service
public class CrimeType_Services {
	
	@Autowired
	private CrimeType_Repository crimetype_repo;
	
	public List<CrimeType> listAllCrimeType()
	{
		return crimetype_repo.findAll();
	}
	
	public void saveCrimeType(CrimeType crimetype)
	{
		crimetype_repo.save(crimetype);
	}
	
	public CrimeType getCrimeType(BigInteger Id)
	{
		return crimetype_repo.findById(Id).get();
	}
	
	public void deleteCrimeType(BigInteger Id)
	{
		crimetype_repo.deleteById(Id);
	}
	
	
	

}
