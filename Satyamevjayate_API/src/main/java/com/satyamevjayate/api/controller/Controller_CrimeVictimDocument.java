package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.CrimeVictimDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

public class Controller_CrimeVictimDocument {
    @Autowired
    private com.satyamevjayate.api.services.CrimeVictimDocument_Service CrimeVictimDocument_Services;

    @GetMapping("/crimevictimdocument")
    public List<CrimeVictimDocument> getAllCrimeVictimDocument() {
        return CrimeVictimDocument_Services.listAllCrimeVictimDocument();
    }

    @GetMapping("/crimevictimdocument/{id}")
    public CrimeVictimDocument getCrimeVictimDocument(@PathVariable BigInteger id)
    {

        CrimeVictimDocument CrimeVictimDocument= CrimeVictimDocument_Services.getCrimeVictimDocument(id);
        return CrimeVictimDocument;



    }

    @PostMapping("/crimevictimdocument")
    public String addCrimeVictimDocument(@RequestBody CrimeVictimDocument CrimeVictimDocument)
    {
        CrimeVictimDocument_Services.saveCrimeVictimDocument(CrimeVictimDocument);;
        return "CrimeVictimDocument Add Successfully";
    }


    @DeleteMapping("/crimevictimdocument/{id}")
    public String deleteCrimeVictimDocument(@PathVariable BigInteger id)
    {
        CrimeVictimDocument_Services.deleteCrimeVictimDocument(id);;
        return "Delete CrimeVictimDocument Successfully";
    }

    @PutMapping("/crimevictimdocument/{id}")
    public ResponseEntity<Object> editCrimeVictimDocument(@RequestBody CrimeVictimDocument CrimeVictimDocument, @PathVariable BigInteger id) {

        CrimeVictimDocument.setDocumentID(id);

        CrimeVictimDocument_Services.saveCrimeVictimDocument(CrimeVictimDocument);

        return ResponseEntity.noContent().build();
    }
}
