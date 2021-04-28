package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.CrimeVictim;
import com.satyamevjayate.api.entity.Criminal;
import com.satyamevjayate.api.entity.CriminalDocument;
import com.satyamevjayate.api.repo.CriminalDocument_Repository;
import com.satyamevjayate.api.repo.Criminal_Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CriminalDocument_services {
    @Autowired
    private CriminalDocument_Repository CriminalDocument_repo;
    
    @Autowired
    private Criminal_Repository Criminal_repo;

    public List<CriminalDocument> listAllCriminalDocument()
    {
        return CriminalDocument_repo.findAll();
    }

    public CriminalDocument saveCriminalDocument(CriminalDocument CriminalDocument)
    {
//    	Criminal criminal = Criminal_repo.findById(CriminalDocument.getCriminaldoc().getCriminalID()).orElse(null);
//        if (null == criminal) {
        Criminal criminal = new Criminal();
//       }
        criminal.setCriminalID(CriminalDocument.getCriminaldoc().getCriminalID());
        Criminal_repo.save(criminal);
        CriminalDocument.setCriminaldoc(criminal);
        return CriminalDocument_repo.save(CriminalDocument);
    }

    public CriminalDocument getCriminalDocument(Long Id)
    {
        return CriminalDocument_repo.findById(Id).get();
    }

    public void deleteCriminalDocument(Long Id)
    {
        CriminalDocument_repo.deleteById(Id);
    }
}
