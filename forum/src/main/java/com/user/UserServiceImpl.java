package com.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getUser() {
		return (List<User>) userRepository.findAll();
	}
	
	public void save(User u) {
		userRepository.save(u);
	}

}
