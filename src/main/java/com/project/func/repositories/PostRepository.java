package com.project.func.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.func.domain.Post;

public interface PostRepository  extends MongoRepository<Post, String> {

}
