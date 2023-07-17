package com.project.func.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.func.domain.User;
import com.project.func.dto.UserDTO;
import com.project.func.repositories.UserRepository;
import com.project.func.service.exceptions.ObjectNotFoundException;

@Service
public class UserService {
@Autowired
private UserRepository userRepository ; 	
	
public List<User> findAll(){	

return userRepository.findAll();	
}

public User findById(String id) {
	
Optional<User> user = userRepository.findById(id);
return user.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
}

public User insert(User u) {
return userRepository.insert(u);
}

public void delete(String id ) {
 userRepository.deleteById(id);	
}


public User update(User obj) {
User newObj = findById(obj.getId());

updateData(newObj,obj);
return userRepository.save(newObj) ;

}

public void updateData(User newObj , User u) {
	
newObj.setName(u.getName());
newObj.setEmail(u.getEmail());

}

public User fromDto(UserDTO objdto) {
User user = new User(objdto.getId(),objdto.getName(),objdto.getEmail());
return user;
}

}

