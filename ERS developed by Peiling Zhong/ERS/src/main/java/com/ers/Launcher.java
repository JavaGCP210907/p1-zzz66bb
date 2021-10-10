package com.ers;

import java.sql.Connection;
import java.sql.SQLException;

import com.ers.controllers.LoginController;
import com.ers.controllers.ReimbursementController;
import com.ers.utils.ConnectionUtil;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		
		//to get access to the HTTP Handlers in the controller layer
		LoginController lc = new LoginController();
		ReimbursementController rc = new ReimbursementController();
		
		//connection to database
		try(Connection conn = ConnectionUtil.getConnection()){
			System.out.println("You've connected to your database successfully!");
		} catch (SQLException e) {
			System.out.println("Your connection failed");
			e.printStackTrace();
		}
		
		//instantiate a Javalin object, and start the server
		Javalin app = Javalin.create(
				config -> {
					config.enableCorsForAllOrigins();
				}
				).start(8090);
		
		//expose API endpoints
		app.post("/login", lc.loginHandler);
		
		app.post("/reimbursement/add", rc.addreimbursementHandler);
		
		app.put("/reimbursement/updatestatus", rc.updateStatusHandler);
		
		app.get("/reimbursements", rc.getAllReimbursementsHandler);
		
		app.get("/reimbursements/past/:username", rc.getPastReimbursementIndividualHandler);
		
		app.get("/reimbursements/pending/:username", rc.getPendingReimbursementIndividualHandler);
		
		app.get("/reimbursements/pending", rc.getPendingReimbursementEmployeesHandler);
		
		app.get("/reimbursements/approved", rc.getApprovedReimbursementEmployeesHandler);
		
		app.get("/reimbursements/denied", rc.getDeniedReimbursementEmployeesHandler);				
	}
}
