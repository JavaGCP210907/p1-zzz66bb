package com.ers.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ers.models.ErsReimbursementStatus;
import com.ers.models.ErsUserRoles;
import com.ers.utils.ConnectionUtil;

public class ReimbursementStatusDao implements ReimbursementStatusInterface{

	@Override
	public ErsReimbursementStatus getReimbursementStatusById(int id) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from ers_reimbursement_status where reimb_status_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql); 
			
			ps.setInt(1, id); 
			
			ResultSet rs = ps.executeQuery(); 
			
			if(rs.next()) {				
				ErsReimbursementStatus ers  = new ErsReimbursementStatus(); 
				ers.setReimb_status_id(rs.getInt("reimb_status_id"));
				ers.setReimb_status(rs.getString("reimb_status"));				
				return ers; 				
			}					
			
		}catch (SQLException e) {
			System.out.println("get ersreimbursement_status by id failed :*");
			e.printStackTrace();
		}
	
		return null;
	}
}
