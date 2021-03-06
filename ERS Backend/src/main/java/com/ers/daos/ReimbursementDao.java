package com.ers.daos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ers.models.ErsReimbursement;
import com.ers.models.RequestDTO;
import com.ers.models.UpdateStatusDTO;
import com.ers.utils.ConnectionUtil;

public class ReimbursementDao implements ReimbursementInterface {
	
	//to get access to the dao layer
	UserDao uDao = new UserDao();
	ReimbursementStatusDao rsDao = new ReimbursementStatusDao();
	ReimbursementTypeDao rtDao = new ReimbursementTypeDao();

	@Override
	public List<ErsReimbursement> getAllReimbursements() {
		
		//get data from database by using JDBC and SQL query
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from ers_reimbursement";
			
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery(sql);
			
			List<ErsReimbursement> reimbursementList = new ArrayList<>();
			
			//populate the ArrayList
			while(rs.next()) {
				
				//make a new ErsReimbursement object for each row
				ErsReimbursement e = new ErsReimbursement(			
						rs.getInt("reimb_id"),
						rs.getDouble("reimb_amount"),
						rs.getTimestamp("reimb_submitted"),
						rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"),
						null,
						null,
						null,
						null
						);
				
				if(rs.getInt("reimb_author") != 0) {		
					e.setReimb_author_fk(uDao.getUserById(rs.getInt("reimb_author")));
				}
				
				if(rs.getInt("reimb_resolver") != 0) {				
					e.setReimb_resolver_fk(uDao.getUserById(rs.getInt("reimb_resolver")));
				}
				else {
					e.setReimb_resolver_fk(null);
				}
				
				if(rs.getInt("reimb_status_id") != 0) {					
					e.setReimb_status_fk(rsDao.getReimbursementStatusById(rs.getInt("reimb_status_id")));
				}
				
				if(rs.getInt("reimb_type_id") != 0) {					
					e.setReimb_type_fk(rtDao.getReimbursementTypeById(rs.getInt("reimb_type_id")));
				}
				
				reimbursementList.add(e);											
			}
			
			return reimbursementList;			
			
		}catch (SQLException e) {
			System.out.println("Get reimbursements failed");
			e.printStackTrace();
		}
		
		return null;		
	}

	@Override
	public List<ErsReimbursement> getPendingReimbursementEmployees() {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from ers_reimbursement where reimb_status_id = 1";
			
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery(sql);
			
			List<ErsReimbursement> reimbursementList = new ArrayList<>();
			
			while(rs.next()) {
				ErsReimbursement e = new ErsReimbursement(						
						rs.getInt("reimb_id"),
						rs.getDouble("reimb_amount"),
						rs.getTimestamp("reimb_submitted"),
						rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"),
						null,
						null,
						null,
						null
						);
				
				if(rs.getInt("reimb_author") != 0) {					
					e.setReimb_author_fk(uDao.getUserById(rs.getInt("reimb_author")));
				}
				
				if(rs.getInt("reimb_resolver") != 0) {					
					e.setReimb_resolver_fk(uDao.getUserById(rs.getInt("reimb_resolver")));
				}
				else {
					e.setReimb_resolver_fk(null);
				}
				
				if(rs.getInt("reimb_status_id") != 0) {					
					e.setReimb_status_fk(rsDao.getReimbursementStatusById(rs.getInt("reimb_status_id")));
				}
				
				if(rs.getInt("reimb_type_id") != 0) {					
					e.setReimb_type_fk(rtDao.getReimbursementTypeById(rs.getInt("reimb_type_id")));
				}
				
				reimbursementList.add(e);
											
			}
			
			return reimbursementList;
			
			
		}catch (SQLException e) {
			System.out.println("Get reimbursements failed");
			e.printStackTrace();
		}
		
		return null;
	}

	
	@Override
	public List<ErsReimbursement> getApprovedReimbursementEmployees() {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from ers_reimbursement where reimb_status_id = 3";
			
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery(sql);
			
			List<ErsReimbursement> reimbursementList = new ArrayList<>();
			
			while(rs.next()) {
				ErsReimbursement e = new ErsReimbursement(						
						rs.getInt("reimb_id"),
						rs.getDouble("reimb_amount"),
						rs.getTimestamp("reimb_submitted"),
						rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"),
						null,
						null,
						null,
						null
						);
				
				if(rs.getInt("reimb_author") != 0) {					
					e.setReimb_author_fk(uDao.getUserById(rs.getInt("reimb_author")));
				}
				
				if(rs.getInt("reimb_resolver") != 0) {					
					e.setReimb_resolver_fk(uDao.getUserById(rs.getInt("reimb_resolver")));
				}
				else {
					e.setReimb_resolver_fk(null);
				}
				
				if(rs.getInt("reimb_status_id") != 0) {					
					e.setReimb_status_fk(rsDao.getReimbursementStatusById(rs.getInt("reimb_status_id")));
				}
				
				if(rs.getInt("reimb_type_id") != 0) {					
					e.setReimb_type_fk(rtDao.getReimbursementTypeById(rs.getInt("reimb_type_id")));
				}
				
				reimbursementList.add(e);
											
			}
			
			return reimbursementList;		
			
		}catch (SQLException e) {
			System.out.println("Get reimbursements failed");
			e.printStackTrace();
		}
		
		return null;
	}

	
	@Override
	public List<ErsReimbursement> getDeniedReimbursementEmployees() {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from ers_reimbursement where reimb_status_id = 2";
			
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery(sql);
			
			List<ErsReimbursement> reimbursementList = new ArrayList<>();
			
			while(rs.next()) {
				ErsReimbursement e = new ErsReimbursement(						
						rs.getInt("reimb_id"),
						rs.getDouble("reimb_amount"),
						rs.getTimestamp("reimb_submitted"),
						rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"),
						null,
						null,
						null,
						null
						);
				
				if(rs.getInt("reimb_author") != 0) {					
					e.setReimb_author_fk(uDao.getUserById(rs.getInt("reimb_author")));
				}
				
				if(rs.getInt("reimb_resolver") != 0) {					
					e.setReimb_resolver_fk(uDao.getUserById(rs.getInt("reimb_resolver")));
				}
				else {
					e.setReimb_resolver_fk(null);
				}
				
				if(rs.getInt("reimb_status_id") != 0) {					
					e.setReimb_status_fk(rsDao.getReimbursementStatusById(rs.getInt("reimb_status_id")));
				}
				
				if(rs.getInt("reimb_type_id") != 0) {					
					e.setReimb_type_fk(rtDao.getReimbursementTypeById(rs.getInt("reimb_type_id")));
				}
				
				reimbursementList.add(e);
											
			}
			
			return reimbursementList;			
			
		}catch (SQLException e) {
			System.out.println("Get reimbursements failed");
			e.printStackTrace();
		}
		
		return null;
	}

	
	@Override
	public List<ErsReimbursement> getPendingReimbursementIndividual(String username) {
		
		UserDao ud = new UserDao();
		int user_id = ud.getUserByName(username).getErs_user_id();
		
		
		try(Connection conn = ConnectionUtil.getConnection()){
						
			String sql = "select * from ers_reimbursement where (reimb_status_id = 1) and (reimb_author = ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, user_id);
			
			ResultSet rs = ps.executeQuery();
			
			List<ErsReimbursement> reimbursementList = new ArrayList<>();
			
			while(rs.next()) {
				ErsReimbursement e = new ErsReimbursement(						
						rs.getInt("reimb_id"),
						rs.getDouble("reimb_amount"),
						rs.getTimestamp("reimb_submitted"),
						rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"),
						null,
						null,
						null,
						null
						);
				
				if(rs.getInt("reimb_author") != 0) {					
					e.setReimb_author_fk(uDao.getUserById(rs.getInt("reimb_author")));
				}
				
				if(rs.getInt("reimb_resolver") != 0) {					
					e.setReimb_resolver_fk(uDao.getUserById(rs.getInt("reimb_resolver")));
				}
				else {
					e.setReimb_resolver_fk(null);
				}
				
				if(rs.getInt("reimb_status_id") != 0) {					
					e.setReimb_status_fk(rsDao.getReimbursementStatusById(rs.getInt("reimb_status_id")));
				}
				
				if(rs.getInt("reimb_type_id") != 0) {					
					e.setReimb_type_fk(rtDao.getReimbursementTypeById(rs.getInt("reimb_type_id")));
				}
				
				reimbursementList.add(e);
											
			}
			
			return reimbursementList;			
			
		}catch (SQLException e) {
			System.out.println("Get reimbursements failed");
			e.printStackTrace();
		}
		
		return null;
	}

	
	@Override
	public List<ErsReimbursement> getPastReimbursementIndividual(String username) {
		
		UserDao ud = new UserDao();
		int user_id = ud.getUserByName(username).getErs_user_id();		
		
		try(Connection conn = ConnectionUtil.getConnection()){			
			
			String sql = "select * from ers_reimbursement where ((reimb_status_id = 3) or (reimb_status_id = 2)) and (reimb_author = ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, user_id);
			
			ResultSet rs = ps.executeQuery();
			
			List<ErsReimbursement> reimbursementList = new ArrayList<>();
			
			while(rs.next()) {
				ErsReimbursement e = new ErsReimbursement(						
						rs.getInt("reimb_id"),
						rs.getDouble("reimb_amount"),
						rs.getTimestamp("reimb_submitted"),
						rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"),
						null,
						null,
						null,
						null
						);
				
				if(rs.getInt("reimb_author") != 0) {					
					e.setReimb_author_fk(uDao.getUserById(rs.getInt("reimb_author")));
				}
				
				if(rs.getInt("reimb_resolver") != 0) {					
					e.setReimb_resolver_fk(uDao.getUserById(rs.getInt("reimb_resolver")));
				}
				else {
					e.setReimb_resolver_fk(null);
				}
				
				if(rs.getInt("reimb_status_id") != 0) {					
					e.setReimb_status_fk(rsDao.getReimbursementStatusById(rs.getInt("reimb_status_id")));
				}
				
				if(rs.getInt("reimb_type_id") != 0) {					
					e.setReimb_type_fk(rtDao.getReimbursementTypeById(rs.getInt("reimb_type_id")));
				}
				
				reimbursementList.add(e);
											
			}
			
			return reimbursementList;			
			
		}catch (SQLException e) {
			System.out.println("Get reimbursements failed");
			e.printStackTrace();
		}
		
		return null;
	}

	
	
	@Override
	public boolean addreimbursement(RequestDTO request_info) {		
		
		UserDao ud = new UserDao();
		int user_id = ud.getUserByName(request_info.getErs_username()).getErs_user_id();		
		
		double reimb_amount = request_info.getReimb_amount();
		String reimb_description = request_info.getReimb_description();
		int reimb_author = user_id;
		int reimb_type_id = request_info.getReimb_type_id();		
		
		try(Connection conn = ConnectionUtil.getConnection()){
						
			String sql = "insert into ers_reimbursement (reimb_amount, reimb_description, reimb_author, reimb_type_id) values (?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setDouble(1, reimb_amount);
			ps.setString(2, reimb_description);
			ps.setInt(3, reimb_author);
			ps.setInt(4, reimb_type_id);			
			
			int addNum = ps.executeUpdate();
			
			if (addNum == 0) {
				return false;
			}			
			return true;			
			
		}catch (SQLException e) {
			System.out.println("Get reimbursements failed");
			e.printStackTrace();
		}
		
		return false;
	}	
	

	@Override
	public boolean updateStatus(UpdateStatusDTO updateStatus_info) {
		
		UserDao ud = new UserDao();
		int user_id = ud.getUserByName(updateStatus_info.getReimb_resolver_name()).getErs_user_id();		
		
		int reimb_id = updateStatus_info.getReimb_id();
		int reimb_resolver = user_id;
		int reimb_status_id = updateStatus_info.getReimb_status_id();
				
		try(Connection conn = ConnectionUtil.getConnection()){
						
			String sql = "update ers_reimbursement set reimb_resolved = ?, reimb_resolver = ?, reimb_status_id = ? where reimb_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
			ps.setInt(2, reimb_resolver);
			ps.setInt(3, reimb_status_id);
			ps.setInt(4, reimb_id);
			
			int uStatus = ps.executeUpdate();
			
			if (uStatus == 0) {
				return false;
			}			
			return true;					
			
		}catch (SQLException e) {
			System.out.println("updating reimbursements status failed");
			e.printStackTrace();
		}
		
		return false;
	}
}
