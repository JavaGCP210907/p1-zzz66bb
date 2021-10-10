package com.ers.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ers.models.ErsUserRoles;
import com.ers.utils.ConnectionUtil;

public class UserRoleDao implements UserRoleInterface{

	@Override
	public ErsUserRoles getUserRoleById(int id) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from ers_user_roles where ers_user_role_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql); 
			
			ps.setInt(1, id); 
			
			ResultSet rs = ps.executeQuery(); 
			
			if(rs.next()) {
							
				ErsUserRoles eur  = new ErsUserRoles(); 
				
				eur.setErs_user_role_id(rs.getInt("ers_user_role_id"));
				eur.setUser_role(rs.getString("user_role"));
				
				return eur; 				
			}								
		}catch (SQLException e) {
			System.out.println("get user_role by id failed :*");
			e.printStackTrace();
		}	
		return null;
		
	}
}
