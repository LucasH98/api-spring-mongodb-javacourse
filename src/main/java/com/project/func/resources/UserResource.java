package com.project.func.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.func.domain.User;
import com.project.func.dto.UserDTO;
import com.project.func.service.UserService;


@RestController
@RequestMapping("/users")
public class UserResource {
	
@Autowired	
private UserService service ;	
	
	
	@GetMapping
 	public ResponseEntity<List<UserDTO>> findAll(){
	List<User> list = service.findAll();
	List<UserDTO>  listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById( @PathVariable String id){
		User u  = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(u));
		}
	
@PostMapping	
public ResponseEntity<User> insert(@RequestBody UserDTO userdto ){	
User user = service.fromDto(userdto);
user = service.insert(user);
URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(user.getId()).toUri();
return ResponseEntity.created(uri).build(); //o created retorna o 201 ou seja , um novo recurso criado.
}

@DeleteMapping(value = "/{id}")
public ResponseEntity<Void> delete(@PathVariable String id){	
service.delete(id);
return ResponseEntity.noContent().build();
}

@PutMapping (value = "/{id}")
public ResponseEntity<User> update (@RequestBody UserDTO objDto ,@PathVariable String id ){		
User obj = service.fromDto(objDto); 	
obj.setId(id);
obj = service.update(obj);
return ResponseEntity.noContent().build();

}

}
