package com.example.User.Service;


import java.util.List;
import java.util.Optional;

import com.example.User.Model.User;


public interface UserServices{
	
	List<User> findAllUser();

	void CreateUser(User user);

	void EditUser(User user);
	
	Optional<User> findByUserId(Long id);
	
	void saveUser(User user);

	void deleteUser(long id);
}
