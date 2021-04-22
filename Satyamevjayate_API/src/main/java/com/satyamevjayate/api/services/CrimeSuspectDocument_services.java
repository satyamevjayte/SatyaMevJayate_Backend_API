package com.satyamevjayate.api.services;


import com.satyamevjayate.api.entity.CrimeSuspect;
import com.satyamevjayate.api.entity.CrimeSuspectDocument;
import com.satyamevjayate.api.repo.CrimeSuspectDocument_Repository;
import com.satyamevjayate.api.repo.CrimeSuspect_Repository;

import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;

public class CrimeSuspectDocument_services {
    @Autowired
    private CrimeSuspectDocument_Repository CrimeSuspectDocument_repo;
    
    @Autowired
    private CrimeSuspect_Repository crimesuspect_repo;

    public List<CrimeSuspectDocument> listAllCrimeSuspectDocument()
    {
        return CrimeSuspectDocument_repo.findAll();
    }

    public CrimeSuspectDocument saveCrimeSuspectDocument(CrimeSuspectDocument CrimeSuspectDocument)
    {
    	CrimeSuspect crimesuspect = crimesuspect_repo.findById(CrimeSuspectDocument.getCrimesusdoc().getCrimeSuspectID()).orElse(null);
        if (null == crimesuspect) {
            crimesuspect = new CrimeSuspect();
        }
        crimesuspect.setCrimeSuspectID(CrimeSuspectDocument.getCrimesusdoc().getCrimeSuspectID());
        CrimeSuspectDocument.setCrimesusdoc(crimesuspect);
    	return CrimeSuspectDocument_repo.save(CrimeSuspectDocument);
    }

    public CrimeSuspectDocument getCrimeSuspectDocument(BigInteger Id)
    {
        return CrimeSuspectDocument_repo.findById(Id).get();
    }

    public void deleteCrimeSuspectDocument(BigInteger Id)
    {
        CrimeSuspectDocument_repo.deleteById(Id);
    }
}
