package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.WorkerDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller_WorkerDocument {
    @Autowired
    private com.satyamevjayate.api.services.WorkerDocument_Services  WorkerDocument_Services;

    @GetMapping("/workerdocument")
    public List<WorkerDocument> getAllWorkerDocument() {
        return WorkerDocument_Services.listAllWorkerDocument();
    }

    @GetMapping("/workerdocument/{id}")
    public WorkerDocument getWorkerDocument(@PathVariable Long id)
    {

        WorkerDocument WorkerDocument= WorkerDocument_Services.getWorkerDocument(id);
        return WorkerDocument;



    }

    @PostMapping("/workerdocument")
    public String addWorkerDocument(@RequestBody WorkerDocument WorkerDocument)
    {
        WorkerDocument_Services.saveWorkerDocument(WorkerDocument);
        return "WorkerDocument Add Successfully";
    }


    @DeleteMapping("/workerdocument/{id}")
    public String deleteWorkerDocument(@PathVariable Long id)
    {
        WorkerDocument_Services.deleteWorkerDocument(id);;
        return "Delete WorkerDocument Successfully";
    }

    @PutMapping("/workerdocument/{id}")
    public ResponseEntity<Object> editWorkerDocument(@RequestBody WorkerDocument WorkerDocument, @PathVariable Long id) {

//        WorkerDocument.set
        WorkerDocument_Services.saveWorkerDocument(WorkerDocument);

        return ResponseEntity.noContent().build();
    }
}
