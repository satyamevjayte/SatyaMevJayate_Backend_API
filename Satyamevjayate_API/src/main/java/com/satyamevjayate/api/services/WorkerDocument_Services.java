package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Criminal;
import com.satyamevjayate.api.entity.Worker;
import com.satyamevjayate.api.entity.WorkerDocument;
import com.satyamevjayate.api.repo.WorkerDocument_Repository;
import com.satyamevjayate.api.repo.Worker_Repository;

import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;

public class WorkerDocument_Services {
    @Autowired
    private WorkerDocument_Repository WorkerDocument_repo;

    @Autowired
    private Worker_Repository Worker_repo;
    public List<WorkerDocument> listAllWorkerDocument()
    {
        return WorkerDocument_repo.findAll();
    }

    public WorkerDocument saveWorkerDocument(WorkerDocument WorkerDocument)
    {
    	Worker worker = Worker_repo.findById(WorkerDocument.getWorkerdoc().getWorkerID()).orElse(null);
        if (null == worker) {
        	worker = new Worker();
        }
        worker.setWorkerID(WorkerDocument.getWorkerdoc().getWorkerID());
        WorkerDocument.setWorkerdoc(worker);
       return WorkerDocument_repo.save(WorkerDocument);
    }

    public WorkerDocument getWorkerDocument(Long Id)
    {
        return WorkerDocument_repo.findById(Id).get();
    }

    public void deleteWorkerDocument(Long Id)
    {
        WorkerDocument_repo.deleteById(Id);
    }
}
