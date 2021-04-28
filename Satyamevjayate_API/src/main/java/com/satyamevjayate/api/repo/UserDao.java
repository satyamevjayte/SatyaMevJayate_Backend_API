package com.satyamevjayate.api.repo;

import com.satyamevjayate.api.entity.DAOUser;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<DAOUser,Long> {
    DAOUser findByUsername(String username);
}