package com.redfield.microservicesm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redfield.microservicesm.model.User;

public interface UserRepository extends JpaRepository<User,Integer>
{
	
}
