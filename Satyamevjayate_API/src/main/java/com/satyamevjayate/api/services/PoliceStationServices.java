package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.PoliceStation;
import com.satyamevjayate.api.repo.PoliceStation_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
@Service
public class PoliceStationServices {
    @Autowired
    private PoliceStation_Repository PoliceStation_Repo;

    public List<PoliceStation> listAll_PoliceStation()
    {
        System.out.println(PoliceStation_Repo.findAll());
        return PoliceStation_Repo.findAll();
    }

    public void save_PoliceStation(PoliceStation PoliceStation)
    {
        PoliceStation_Repo.save(PoliceStation);
    }

    public PoliceStation getPoliceStation(BigInteger Id)
    {
        return PoliceStation_Repo.findById(Id).get();
    }

    public void delete_PoliceStation(BigInteger Id)
    {
        PoliceStation_Repo.deleteById(Id);
    }

}
