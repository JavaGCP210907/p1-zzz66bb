package com.ers.services;

import java.util.List;

import com.ers.daos.ReimbursementDao;
import com.ers.models.ErsReimbursement;
import com.ers.models.RequestDTO;
import com.ers.models.UpdateStatusDTO;

public class ReimbursementService {
	
	//instantiate an ReimbursementDao to use its methods
	ReimbursementDao rDao = new ReimbursementDao();
	
	public List<ErsReimbursement> getAllReimbursements(){
		
		return rDao.getAllReimbursements();
	}
	
	public List<ErsReimbursement> getPendingReimbursementEmployees(){
		
		return rDao.getPendingReimbursementEmployees();	
	}
	
	public List<ErsReimbursement> getApprovedReimbursementEmployees(){
		
		return rDao.getApprovedReimbursementEmployees();		
	}
	
	public List<ErsReimbursement> getDeniedReimbursementEmployees(){
		
		return rDao.getDeniedReimbursementEmployees();		
	}
	
	public List<ErsReimbursement> getPendingReimbursementIndividual(String username){
		
		return rDao.getPendingReimbursementIndividual(username);		
	}
	
	public List<ErsReimbursement> getPastReimbursementIndividual(String username){
		
		return rDao.getPastReimbursementIndividual(username);		
	}
	
	public boolean addreimbursement(RequestDTO request_info){
		
		return rDao.addreimbursement(request_info);		
	}
	
	public boolean updateStatus(UpdateStatusDTO updateStatus_info){
		
		return rDao.updateStatus(updateStatus_info);
	}
}
	
	