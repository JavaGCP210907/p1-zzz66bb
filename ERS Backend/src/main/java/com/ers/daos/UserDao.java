package com.ers.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ers.models.ErsUsers;
import com.ers.utils.ConnectionUtil;

public class UserDao implements UserInterface{

	@Override
	public ErsUsers getUserById(int id) {
		
		UserRoleDao urDao = new UserRoleDao();
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from ers_users where ers_user_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql); 
			
			ps.setInt(1, id); 
			
			ResultSet rs = ps.executeQuery(); 
			
			if(rs.next()) {
				
				ErsUsers eu = new ErsUsers(						
						rs.getInt("ers_user_id"),
						rs.getString("ers_username"),
						rs.getString("ers_password"),
						rs.getString("user_first_name"),
						rs.getString("user_last_name"),
						rs.getString("user_email"),
						null
						);
				
				if(rs.getInt("user_role_id") != 0) {					
					eu.setUser_role_fk(urDao.getUserRoleById(rs.getInt("user_role_id")));					
				}				
				return eu;
					
			}
			
		} catch (SQLException e) {
			System.out.println("get user by id failed :*");
			e.printStackTrace();
		}
		
		return null;		
	}

	
	@Override
	public ErsUsers getUserByName(String username) {
		
		UserRoleDao urDao = new UserRoleDao();
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from ers_users where ers_username = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql); 
			
			ps.setString(1, username); 
			
			ResultSet rs = ps.executeQuery(); 			
			
			if(rs.next()) {
				
				ErsUsers eu = new ErsUsers(						
						rs.getInt("ers_user_id"),
						rs.getString("ers_username"),
						rs.getString("ers_password"),
						rs.getString("user_first_name"),
						rs.getString("user_last_name"),
						rs.getString("user_email"),
						null
						);
				
				if(rs.getInt("user_role_id") != 0) {					
					eu.setUser_role_fk(urDao.getUserRoleById(rs.getInt("user_role_id")));					
				}
				return eu;
									
			}		
		} catch (SQLException e) {
			System.out.println("get user by name failed :*");
			e.printStackTrace();
		}		
		return null;
	
	}
}
