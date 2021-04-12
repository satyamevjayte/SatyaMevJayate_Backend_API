package com.satyamevjayate.api.services;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.satyamevjayate.api.entity.PrisoningType;
import com.satyamevjayate.api.repo.PrisoningType_Repository;

@Service
public class PrisoningType_Services {
	
	@Autowired
	private PrisoningType_Repository prisoningtype_repo;
	
	public List<PrisoningType> listAllPrisoningType()
	{
		return prisoningtype_repo.findAll();
	}
	
	public void savePrisoningType(PrisoningType prisoningtype)
	{
		prisoningtype_repo.save(prisoningtype);
	}
	
	public PrisoningType getPrisoningType(BigInteger Id)
	{
		return prisoningtype_repo.findById(Id).get();
	}
	
	public void deletePrisoningType(BigInteger Id)
	{
		prisoningtype_repo.deleteById(Id);
	}
	
	

}
