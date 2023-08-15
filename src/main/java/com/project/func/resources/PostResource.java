package com.project.func.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.func.domain.Post;
import com.project.func.service.PostService;


@RestController
@RequestMapping("/posts")
public class PostResource {
	
@Autowired	
private PostService service ;	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById( @PathVariable String id){
		Post p  = service.findById(id);
		return ResponseEntity.ok().body(p);
		}
	








}
