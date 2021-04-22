package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.CrimeSuspectDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

public class Controller_CrimeSuspectDocument {
    @Autowired
    private com.satyamevjayate.api.services.CrimeSuspectDocument_services  CrimeSuspectDocument_Services;

    @GetMapping("/crimesuspectdocument")
    public List<CrimeSuspectDocument> getAllCrimeSuspectDocument() {
        return CrimeSuspectDocument_Services.listAllCrimeSuspectDocument();
    }

    @GetMapping("/crimesuspectdocument/{id}")
    public CrimeSuspectDocument getCrimeSuspectDocument(@PathVariable BigInteger id)
    {

        CrimeSuspectDocument CrimeSuspectDocument= CrimeSuspectDocument_Services.getCrimeSuspectDocument(id);
        return CrimeSuspectDocument;



    }

    @PostMapping("/crimesuspectdocument")
    public String addCrimeSuspectDocument(@RequestBody CrimeSuspectDocument CrimeSuspectDocument)
    {
        CrimeSuspectDocument_Services.saveCrimeSuspectDocument(CrimeSuspectDocument);;
        return "CrimeSuspectDocument Add Successfully";
    }


    @DeleteMapping("/crimesuspectdocument/{id}")
    public String deleteCrimeSuspectDocument(@PathVariable BigInteger id)
    {
        CrimeSuspectDocument_Services.deleteCrimeSuspectDocument(id);;
        return "Delete CrimeSuspectDocument Successfully";
    }

    @PutMapping("/crimesuspectdocument/{id}")
    public ResponseEntity<Object> editCrimeSuspectDocument(@RequestBody CrimeSuspectDocument CrimeSuspectDocument, @PathVariable BigInteger id) {

        CrimeSuspectDocument.setDocumentID(id);
        CrimeSuspectDocument_Services.saveCrimeSuspectDocument(CrimeSuspectDocument);

        return ResponseEntity.noContent().build();
    }
}
