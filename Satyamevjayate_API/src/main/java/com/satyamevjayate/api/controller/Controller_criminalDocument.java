package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.CriminalDocument;
import com.satyamevjayate.api.services.CriminalDocument_services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class Controller_criminalDocument {
    @Autowired
    private CriminalDocument_services  CriminalDocument_Services;

    @GetMapping("/criminaldocument")
    public List<CriminalDocument> getAllCriminalDocument() {
        return CriminalDocument_Services.listAllCriminalDocument();
    }

    @GetMapping("/criminaldocument/{id}")
    public CriminalDocument getCriminalDocument(@PathVariable Long id)
    {

        CriminalDocument CriminalDocument= CriminalDocument_Services.getCriminalDocument(id);
        return CriminalDocument;



    }

    @PostMapping("/criminaldocument")
    public String addCriminalDocument(@RequestBody CriminalDocument CriminalDocument)
    {
        CriminalDocument_Services.saveCriminalDocument(CriminalDocument);;
        return "CriminalDocument Add Successfully";
    }


    @DeleteMapping("/criminaldocument/{id}")
    public String deleteCriminalDocument(@PathVariable Long id)
    {
        CriminalDocument_Services.deleteCriminalDocument(id);;
        return "Delete CriminalDocument Successfully";
    }

    @PutMapping("/criminaldocument/{id}")
    public ResponseEntity<Object> editCriminalDocument(@RequestBody CriminalDocument CriminalDocument, @PathVariable Long id) {

        CriminalDocument.setDocumentID(id);
        CriminalDocument_Services.saveCriminalDocument(CriminalDocument);

        return ResponseEntity.noContent().build();
    }
}
