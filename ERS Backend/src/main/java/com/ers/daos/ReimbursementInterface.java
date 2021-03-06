package com.ers.daos;

import java.util.List;

import com.ers.models.ErsReimbursement;
import com.ers.models.RequestDTO;
import com.ers.models.UpdateStatusDTO;

public interface ReimbursementInterface {
	
	public List<ErsReimbursement> getAllReimbursements();
	
	public List<ErsReimbursement> getPendingReimbursementEmployees();
	
	public List<ErsReimbursement> getApprovedReimbursementEmployees();
	
	public List<ErsReimbursement> getDeniedReimbursementEmployees();
	
	public List<ErsReimbursement> getPendingReimbursementIndividual(String username);
	
	public List<ErsReimbursement> getPastReimbursementIndividual(String username);
	
	public boolean addreimbursement(RequestDTO request_info);
	
	public boolean updateStatus(UpdateStatusDTO updateStatus_info); 
 
}
