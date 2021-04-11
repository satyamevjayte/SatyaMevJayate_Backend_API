package com.satyamevjayate.api.repo;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satyamevjayate.api.entity.Addresses;

public interface Addresses_Repository extends JpaRepository<Addresses, BigInteger> {

}
