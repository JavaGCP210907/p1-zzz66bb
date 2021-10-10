package com.ers.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ers.models.ErsReimbursementStatus;
import com.ers.models.ErsReimbursementType;
import com.ers.utils.ConnectionUtil;

public class ReimbursementTypeDao implements ReimbursementTypeInterface{

	@Override
	public ErsReimbursementType getReimbursementTypeById(int id) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from ers_reimbursement_type where reimb_type_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql); 
			
			ps.setInt(1, id); 
			
			ResultSet rs = ps.executeQuery(); 
			
			if(rs.next()) {
				
				ErsReimbursementType ert  = new ErsReimbursementType(); 
				ert.setReimb_type_id(rs.getInt("reimb_type_id"));
				ert.setReimb_type(rs.getString("reimb_type"));				
				return ert; 				
			}					
			
		}catch (SQLException e) {
			System.out.println("get ersreimbursement_type by id failed :*");
			e.printStackTrace();
		}
	
		return null;
	}
}
