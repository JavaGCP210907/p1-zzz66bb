package com.ers.models;

public class UpdateStatusDTO {
	
	private int reimb_id;
	private String reimb_resolver_name;
    private int reimb_status_id;
    
    
	public UpdateStatusDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UpdateStatusDTO(int reimb_id, String reimb_resolver_name, int reimb_status_id) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_resolver_name = reimb_resolver_name;
		this.reimb_status_id = reimb_status_id;
	}


	public int getReimb_id() {
		return reimb_id;
	}


	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}


	public String getReimb_resolver_name() {
		return reimb_resolver_name;
	}


	public void setReimb_resolver_name(String reimb_resolver_name) {
		this.reimb_resolver_name = reimb_resolver_name;
	}


	public int getReimb_status_id() {
		return reimb_status_id;
	}


	public void setReimb_status_id(int reimb_status_id) {
		this.reimb_status_id = reimb_status_id;
	}


	@Override
	public String toString() {
		return "UpdateStatusDTO [reimb_id=" + reimb_id + ", reimb_resolver_name=" + reimb_resolver_name
				+ ", reimb_status_id=" + reimb_status_id + "]";
	}
    
    
    
    
	
	
	
	

}
