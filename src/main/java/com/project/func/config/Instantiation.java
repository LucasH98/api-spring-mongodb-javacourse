package com.project.func.config;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.project.func.domain.Post;
import com.project.func.domain.User;
import com.project.func.dto.AuthorDTO;
import com.project.func.repositories.PostRepository;
import com.project.func.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository Userrepository;
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Userrepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Userrepository.saveAll(Arrays.asList(maria,alex,bob));

		
		Post post1 = new Post(null,new Date(),"Partiu viagem ","vou viajar para sao paulo ,abraços",new AuthorDTO(maria));
		Post post2 = new Post(null,new Date(),"Bom dia","acordei feliz hoje ! ",new AuthorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(post1,post2));

		
		
		
		
	}

}
