package com.rest.dao;

import org.springframework.data.repository.CrudRepository;

import com.rest.entities.User;

public interface Repository extends CrudRepository<User, Integer> {

}
