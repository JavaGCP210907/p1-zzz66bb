package com.ers.daos;

import com.ers.models.ErsUsers;

public interface UserInterface {
	
	public ErsUsers getUserById(int id);	
	
	public ErsUsers getUserByName(String username);

}
