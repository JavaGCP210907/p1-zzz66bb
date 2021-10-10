package com.ers.controllers;

import java.util.List;

import com.ers.models.ErsReimbursement;
import com.ers.models.RequestDTO;
import com.ers.models.UpdateStatusDTO;
import com.ers.services.ReimbursementService;
import com.google.gson.Gson;

import io.javalin.http.Handler;

public class ReimbursementController {
	
	ReimbursementService rs = new ReimbursementService();
			
	public Handler getAllReimbursementsHandler = (ctx) -> {
		
		//to get access to the method in the service layer
		List<ErsReimbursement> allReimbursements = rs.getAllReimbursements();
		
		//convert our Java object into a JSON String
		Gson gson = new Gson();
		String JSONReimbursements = gson.toJson(allReimbursements);
		
		//return all reimbursements
		ctx.result(JSONReimbursements);
		ctx.status(200);	
	};
	

	public Handler getPendingReimbursementEmployeesHandler = (ctx) -> {
		
		List<ErsReimbursement> pendingReimbursementEmployees = rs.getPendingReimbursementEmployees();
		
		Gson gson = new Gson();	
		String JSONPendingReimbursementEmployees = gson.toJson(pendingReimbursementEmployees);
		
		//return all pending reimbursements
		ctx.result(JSONPendingReimbursementEmployees);	
		ctx.status(200);	
	};
	
	
	public Handler getApprovedReimbursementEmployeesHandler = (ctx) -> {
		
		
		List<ErsReimbursement> approvedReimbursementEmployees = rs.getApprovedReimbursementEmployees();
		
		Gson gson = new Gson();
		String JSONApprovedReimbursementEmployees = gson.toJson(approvedReimbursementEmployees);
		
		//return all approved reimbursements
		ctx.result(JSONApprovedReimbursementEmployees);
		ctx.status(200);	
	};
	
	
	public Handler getDeniedReimbursementEmployeesHandler = (ctx) -> {
			
		List<ErsReimbursement> deniedReimbursementEmployees = rs.getDeniedReimbursementEmployees();
		
		Gson gson = new Gson();
		String JSONDeniedReimbursementEmployees = gson.toJson(deniedReimbursementEmployees);
		
		//return all denied reimbursements
		ctx.result(JSONDeniedReimbursementEmployees);	
		ctx.status(200);	
	};
	
	
	public Handler getPendingReimbursementIndividualHandler = (ctx) -> {
			
		String username = ctx.pathParam("username");
		
		List<ErsReimbursement> pendingReimbursementIndividual = rs.getPendingReimbursementIndividual(username);
		
		Gson gson = new Gson();	
		String JSONPendingReimbursementIndividual = gson.toJson(pendingReimbursementIndividual);
		
		//return current employee's pending reimbursements
		ctx.result(JSONPendingReimbursementIndividual);	
		ctx.status(200);	
	};
	
	
	public Handler getPastReimbursementIndividualHandler = (ctx) -> {	
		
		String username = ctx.pathParam("username");	
		
		List<ErsReimbursement> pastReimbursementIndividual = rs.getPastReimbursementIndividual(username);
		
		Gson gson = new Gson();	
		String JSONPastReimbursementIndividual = gson.toJson(pastReimbursementIndividual);
		
		//return current employee's reimbursements history
		ctx.result(JSONPastReimbursementIndividual);	
		ctx.status(200);	
	};
	
	
	public Handler addreimbursementHandler = (ctx) -> {
		
		String body = ctx.body(); 	
		Gson gson = new Gson();
		RequestDTO request_info = gson.fromJson(body, RequestDTO.class);
		
		//to get access to method in the service layer to add current employee's reimbursement
		if(rs.addreimbursement(request_info)) { 
	
			//if successful, return successful status code to client
			ctx.status(200);			
		} else { 
			
			ctx.status(401); 
			ctx.result("Adding Request Failed");		
		}		
	};
	
	
	public Handler updateStatusHandler= (ctx) -> {		
		
		String body = ctx.body(); 
		Gson gson = new Gson();
		UpdateStatusDTO updateStatus_info = gson.fromJson(body, UpdateStatusDTO.class);		
	
		//to get access to method in the service layer to approve or deny employees' reimbursement request
		if(rs.updateStatus(updateStatus_info)) { 
	
			ctx.status(200);		
		} else { 
			
			ctx.status(401); 
			ctx.result("Updating Reimbursement Status Failed");		
		}			
	};	
}
