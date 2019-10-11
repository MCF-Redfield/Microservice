package com.redfield;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.redfield.dao.UserDAOService;
import com.redfield.model.User;



@RestController
public class UserController
{
	@Autowired
	private UserDAOService userS;
	
	@GetMapping("/users")
	public List<User> getUsers()
	{
		return userS.getUsers();
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<Object> getUser(@PathVariable int id)
	{
		User user = userS.getUser(id);
		if(user==null)
			return ResponseEntity.notFound().build();//Not Found p/ user ñ encontrado
		return ResponseEntity.ok(userS.getUser(id));//OK p/ user encontrado
	}

	@PostMapping("/users")
	public ResponseEntity<Object> addUser(@RequestBody User user)
	{
		User addedUser = userS.addUser(user);
		//logo após inserir o user, quero direcionar a rota p/ o user recem-adicionado
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}")//caminho to redirect
			.buildAndExpand(addedUser.getId())//valor do ID
			.toUri();
		//P/ retornar o Status.Crated
		return ResponseEntity.created(location).build();
	}
	
	
}
