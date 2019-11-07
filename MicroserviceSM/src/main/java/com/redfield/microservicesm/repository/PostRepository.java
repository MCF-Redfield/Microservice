package com.redfield.microservicesm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redfield.microservicesm.model.Post;

public interface PostRepository extends JpaRepository<Post,Integer>
{
	
}
