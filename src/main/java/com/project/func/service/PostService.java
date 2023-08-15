package com.project.func.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.func.domain.Post;
import com.project.func.repositories.PostRepository;
import com.project.func.service.exceptions.ObjectNotFoundException;

@Service
public class PostService {
@Autowired
private PostRepository postRepository ; 	
	
public Post findById(String id) {
	
Optional<Post> post = postRepository.findById(id);
return post.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
}


}

