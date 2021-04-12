package com.satyamevjayate.api.repo;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satyamevjayate.api.entity.PrisoningType;

public interface PrisoningType_Repository extends JpaRepository<PrisoningType, BigInteger> {

}
