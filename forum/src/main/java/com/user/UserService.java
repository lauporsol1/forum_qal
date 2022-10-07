package com.user;

import java.util.List;

public interface UserService {
	
	public List<User> getUser();

	public void save(User user);

}
