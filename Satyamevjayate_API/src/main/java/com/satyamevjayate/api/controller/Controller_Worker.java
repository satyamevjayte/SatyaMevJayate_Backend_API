package com.satyamevjayate.api.controller;
import com.satyamevjayate.api.entity.Worker;
import com.satyamevjayate.api.services.Worker_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class Controller_Worker {
    @Autowired
    private Worker_Service Worker_Service;

    @GetMapping("/worker")
    public List<Worker> getAllWorker() {
        return Worker_Service.listAllWorker();
    }

    @GetMapping("/worker/{id}")
    public Worker getWorker(@PathVariable BigInteger id)
    {
        Worker w= Worker_Service.getWorker(id);
        return w;
    }

    @PostMapping("/worker")
    public String addWorker(@RequestBody Worker w)
    {
        Worker_Service.saveWorker(w);
        return "Worker Add successfully";

    }

    @DeleteMapping("/worker/{id}")
    public String deleteWorker(@PathVariable BigInteger id)
    {
        Worker_Service.deleteWorker(id);
        return "Worker Delete successfully";
    }

    @PutMapping("/worker/{id}")
    public ResponseEntity<Object> editWorker(@RequestBody Worker Worker, @PathVariable BigInteger id) {


        Worker.setWorkerID(id);

        Worker_Service.editWorker(Worker);

        return ResponseEntity.noContent().build();
    }

}
