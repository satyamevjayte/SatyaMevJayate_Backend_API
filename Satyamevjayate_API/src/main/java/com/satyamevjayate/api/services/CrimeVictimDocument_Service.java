package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.CrimeSuspect;
import com.satyamevjayate.api.entity.CrimeVictim;
import com.satyamevjayate.api.entity.CrimeVictimDocument;
import com.satyamevjayate.api.repo.CrimeVictimDocument_Repository;
import com.satyamevjayate.api.repo.CrimeVictim_Repository;

import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;

public class CrimeVictimDocument_Service {
    @Autowired
    private CrimeVictimDocument_Repository CrimeVictimDocument_repo;
    
    @Autowired
    private CrimeVictim_Repository CrimeVictim_repo;

    public List<CrimeVictimDocument> listAllCrimeVictimDocument()
    {
        return CrimeVictimDocument_repo.findAll();
    }

    public CrimeVictimDocument saveCrimeVictimDocument(CrimeVictimDocument CrimeVictimDocument)
    {
    	CrimeVictim crimevictim = CrimeVictim_repo.findById(CrimeVictimDocument.getCrmvictimdocID().getCrimeVictimID()).orElse(null);
        if (null == crimevictim) {
        	crimevictim = new CrimeVictim();
        }
        crimevictim.setCrimeVictimID(CrimeVictimDocument.getCrmvictimdocID().getCrimeVictimID());
        CrimeVictimDocument.setCrmvictimdocID(crimevictim);
        return CrimeVictimDocument_repo.save(CrimeVictimDocument);
    }

    public CrimeVictimDocument getCrimeVictimDocument(BigInteger Id)
    {
        return CrimeVictimDocument_repo.findById(Id).get();
    }

    public void deleteCrimeVictimDocument(BigInteger Id)
    {
        CrimeVictimDocument_repo.deleteById(Id);
    }
}
