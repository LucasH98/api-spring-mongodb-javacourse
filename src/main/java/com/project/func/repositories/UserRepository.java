package com.project.func.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.func.domain.User;

public interface UserRepository extends MongoRepository<User, String> {	

}
