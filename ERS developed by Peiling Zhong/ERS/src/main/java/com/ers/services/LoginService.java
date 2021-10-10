package com.ers.services;

import com.ers.daos.UserDao;
import com.ers.models.ErsUsers;

public class LoginService {
	
	//validate the user login informations against username and password in your database
	public boolean login(String username, String password) {
		
		//gets access to the method in the DAO layer
		UserDao ud= new UserDao();
		ErsUsers eul = ud.getUserByName(username);

		if(eul != null) {
			if((eul.getErs_password()).equals(password)) {
				return true;
			}
			else {
				return false;
			}
		}
		
		return false;		
	}
	
	
	public ErsUsers getUser(String username) {
		
		//gets the DAO data and sends it up to the controller
		UserDao udRole = new UserDao();
		ErsUsers euRole = udRole.getUserByName(username);
		
		return euRole;
		
	}

}
