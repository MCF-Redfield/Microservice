package com.redfield.microservicesm.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.redfield.microservicesm.dao.UserDAOService;
import com.redfield.microservicesm.model.User;
import com.redfield.microservicesm.repository.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@Api(value="API Rest SocialMedia")
public class UserJPA
{
	@Autowired
	private UserDAOService userS;
	
	@Autowired
	private UserRepository userR;
	
	@ApiOperation(value = "Lista todos Users")
	@GetMapping("/jpa/users")
	public List<User> getUsers()
	{
		return userR.findAll();
	}

	/*
	 * @GetMapping("/users/{id}") public ResponseEntity<Object>
	 * getUser(@PathVariable int id) { User user = userS.getUser(id);
	 * 
	 * if(user!=null) { Resource<User> resource = new Resource<User>(user);
	 * ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getUsers());
	 * resource.add(linkTo.withRel("TOdos Users")); return
	 * ResponseEntity.ok(resource);//OK p/ user encontrado }
	 * 
	 * return ResponseEntity.notFound().build();//Not Found p/ user ñ encontrado }
	 */

	@ApiOperation(value = "Busca User por ID")
	@GetMapping("/jpa/users/{id}")
	public Optional<User> getUser(@PathVariable int id)
	{
		return userR.findById(id);
		/*
		 * Resource<User> resource = new Resource<User>(user);
		 * 
		 * if(user!=null) { ControllerLinkBuilder linkTo =
		 * linkTo(methodOn(this.getClass()).getUsers());
		 * resource.add(linkTo.withRel("TOdos Users")); return resource;//OK p/ user
		 * encontrado }
		 * 
		 *return resource;//Not Found p/ user ñ encontrado*/
	}
		
	@ApiOperation(value = "Adiciona User")
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user)
	{
		User addedUser = userR.save(user);
		//logo após inserir o user, quero direcionar a rota p/ o user recem-adicionado
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}")//caminho to redirect
			.buildAndExpand(addedUser.getId())//valor do ID
			.toUri();
		//P/ retornar o Status.Crated
		return ResponseEntity.created(location).build();
	}
	
	@ApiOperation(value = "Deleta User")
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id)
	{
		userR.deleteById(id);
		//if(user==null)
		//	return ResponseEntity.notFound().build();//Not Found p/ user ñ encontrado
		//return ResponseEntity.ok("Excluido com sucesso");//OK p/ user encontrado
	}
	
	
}
