package com.satyamevjayate.api.services;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyamevjayate.api.entity.Addresses;

import com.satyamevjayate.api.repo.Addresses_Repository;

@Service
public class Addresses_Services {
	
	@Autowired
	private Addresses_Repository Address_repo;
	
	public List<Addresses> listAllAddresses()
	{
		return Address_repo.findAll();
	}
	
	public void saveAddress(Addresses address)
	{
		Address_repo.save(address);
	}
	
	public Addresses getAddress(BigInteger Id)
	{
		return Address_repo.findById(Id).get();
	}
	
	public void deleteAddress(BigInteger Id)
	{
		Address_repo.deleteById(Id);
	}

}
