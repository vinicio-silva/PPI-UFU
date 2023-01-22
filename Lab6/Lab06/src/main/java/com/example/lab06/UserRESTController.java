package com.example.lab06;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserRESTController {
	@Autowired
	private UserRepository useRepository;
	
	@GetMapping
	public List<Users> findAllUsers(){
		//Implement
		return useRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Users> findUserById(@PathVariable(value = "id") long id) {
		//Implement
		Optional<Users> user = useRepository.findById(id);
		if(user.isPresent()){
			return ResponseEntity.ok().body(user.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public Users saveEmployee(@Validated @RequestBody Users user){
		//Implement
		return useRepository.save(user);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable(value = "id") long id){
		//Implement
		Optional<Users> user = useRepository.findById(id);
		if(user.isPresent()){
			useRepository.deleteById(id);
			return ResponseEntity.ok().body("Deleted");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}

//curl --location --request POST 'http://localhost:8080/api/user' --header 'Content‐Type: application/json' --data‐raw '{"name": "LarryPage", "email": "larry@oracle.com" }'