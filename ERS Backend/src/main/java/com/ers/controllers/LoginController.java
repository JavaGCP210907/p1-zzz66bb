package com.ers.controllers;
import com.ers.models.ErsUsers;
import com.ers.models.LoginDTO;
import com.ers.services.LoginService;
import com.ers.utils.JwtUtil;
import com.google.gson.Gson;

import io.javalin.http.Handler;

public class LoginController {
	
	LoginService ls = new LoginService();

	public Handler loginHandler = (ctx) -> {
		
		//turn the body of the POST request into a Java String
		String body = ctx.body(); 
		Gson gson = new Gson();
		
		//turn that JSON String into a LoginDTO object
		LoginDTO LDTO = gson.fromJson(body, LoginDTO.class);
	
		//invoke the login() method of LoginService.class to determine whether it's a successful or unsuccessful login
		if(ls.login(LDTO.getUsername(), LDTO.getPassword())) { 
			
			ErsUsers euForRole = ls.getUser(LDTO.getUsername());
			String JSONEuForRole = gson.toJson(euForRole);
			String jwt = JwtUtil.generate(LDTO.getUsername(), LDTO.getPassword());
			
			//if login is successful, return the role of the login user  and status code to client
			ctx.req.getSession(); 
			ctx.result(JSONEuForRole);
			ctx.status(200);
			
		} else { 
			//if login fails, return status code
			ctx.status(401); 
			ctx.result("Login Failed");		
		}		
	};
}
