package com.satyamevjayate.api.repo;

import com.satyamevjayate.api.entity.PoliceStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface PoliceStation_Repository extends JpaRepository<PoliceStation, BigInteger> {
}
