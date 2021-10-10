package com.ers.models;

public class RequestDTO {
	
	private double reimb_amount;
	private String reimb_description;
	private String ers_username;
	private int reimb_type_id;
	
	public RequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestDTO(double reimb_amount, String reimb_description, String ers_username, int reimb_type_id) {
		super();
		this.reimb_amount = reimb_amount;
		this.reimb_description = reimb_description;
		this.ers_username = ers_username;
		this.reimb_type_id = reimb_type_id;
	}

	public double getReimb_amount() {
		return reimb_amount;
	}

	public void setReimb_amount(double reimb_amount) {
		this.reimb_amount = reimb_amount;
	}

	public String getReimb_description() {
		return reimb_description;
	}

	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}

	public String getErs_username() {
		return ers_username;
	}

	public void setErs_username(String ers_username) {
		this.ers_username = ers_username;
	}

	public int getReimb_type_id() {
		return reimb_type_id;
	}

	public void setReimb_type_id(int reimb_type_id) {
		this.reimb_type_id = reimb_type_id;
	}

	@Override
	public String toString() {
		return "RequestDTO [reimb_amount=" + reimb_amount + ", reimb_description=" + reimb_description
				+ ", ers_username=" + ers_username + ", reimb_type_id=" + reimb_type_id + "]";
	}
	
	

}
