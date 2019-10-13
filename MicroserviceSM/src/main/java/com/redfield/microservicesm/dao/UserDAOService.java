package com.redfield.microservicesm.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.redfield.microservicesm.model.User;

@Component
public class UserDAOService
{
	private static int usersCount = 3;
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1,"teeste1",new Date()));
		users.add(new User(2,"teeste2",new Date()));
		users.add(new User(3,"teeste3",new Date()));
	}
	
	public List<User> getUsers()
	{
		return users;
	}
	
	public User addUser(User user)
	{
		if(user.getId()==null)
		{
			user.setId(++usersCount);
		}
		
		users.add(user);
		return user;
	}
	
	public User getUser(int id)
	{
		for(User user:users)
		{
			if(user.getId()==id)
				return user;
		}
		return null; 
	}
	
	public User deleteUser(int id)
	{
		for(int i=0; i<users.size();i++)
		{
			if(users.get(i).getId()==id)
				return users.remove(i);
		}
		return null; 
	}
}
