package com.ers.models;

import java.sql.Timestamp;

public class ErsReimbursement {
	
	private int reimb_id;
	private double reimb_amount;
	private Timestamp reimb_submitted;
	private Timestamp reimb_resolved;
	private String reimb_description;
	private ErsUsers reimb_author_fk;
	private ErsUsers reimb_resolver_fk;
	private ErsReimbursementStatus reimb_status_fk;
	private ErsReimbursementType reimb_type_fk;
	
	public ErsReimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErsReimbursement(int reimb_id, double reimb_amount, Timestamp reimb_submitted, Timestamp reimb_resolved,
			String reimb_description, ErsUsers reimb_author_fk, ErsUsers reimb_resolver_fk,
			ErsReimbursementStatus reimb_status_fk, ErsReimbursementType reimb_type_fk) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.reimb_author_fk = reimb_author_fk;
		this.reimb_resolver_fk = reimb_resolver_fk;
		this.reimb_status_fk = reimb_status_fk;
		this.reimb_type_fk = reimb_type_fk;
	}

	public ErsReimbursement(double reimb_amount, Timestamp reimb_submitted, Timestamp reimb_resolved,
			String reimb_description, ErsUsers reimb_author_fk, ErsUsers reimb_resolver_fk,
			ErsReimbursementStatus reimb_status_fk, ErsReimbursementType reimb_type_fk) {
		super();
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.reimb_author_fk = reimb_author_fk;
		this.reimb_resolver_fk = reimb_resolver_fk;
		this.reimb_status_fk = reimb_status_fk;
		this.reimb_type_fk = reimb_type_fk;
	}

	public int getReimb_id() {
		return reimb_id;
	}

	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}

	public double getReimb_amount() {
		return reimb_amount;
	}

	public void setReimb_amount(double reimb_amount) {
		this.reimb_amount = reimb_amount;
	}

	public Timestamp getReimb_submitted() {
		return reimb_submitted;
	}

	public void setReimb_submitted(Timestamp reimb_submitted) {
		this.reimb_submitted = reimb_submitted;
	}

	public Timestamp getReimb_resolved() {
		return reimb_resolved;
	}

	public void setReimb_resolved(Timestamp reimb_resolved) {
		this.reimb_resolved = reimb_resolved;
	}

	public String getReimb_description() {
		return reimb_description;
	}

	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}

	public ErsUsers getReimb_author_fk() {
		return reimb_author_fk;
	}

	public void setReimb_author_fk(ErsUsers reimb_author_fk) {
		this.reimb_author_fk = reimb_author_fk;
	}

	public ErsUsers getReimb_resolver_fk() {
		return reimb_resolver_fk;
	}

	public void setReimb_resolver_fk(ErsUsers reimb_resolver_fk) {
		this.reimb_resolver_fk = reimb_resolver_fk;
	}

	public ErsReimbursementStatus getReimb_status_fk() {
		return reimb_status_fk;
	}

	public void setReimb_status_fk(ErsReimbursementStatus reimb_status_fk) {
		this.reimb_status_fk = reimb_status_fk;
	}

	public ErsReimbursementType getReimb_type_fk() {
		return reimb_type_fk;
	}

	public void setReimb_type_fk(ErsReimbursementType reimb_type_fk) {
		this.reimb_type_fk = reimb_type_fk;
	}

	@Override
	public String toString() {
		return "ErsReimbursement [reimb_id=" + reimb_id + ", reimb_amount=" + reimb_amount + ", reimb_submitted="
				+ reimb_submitted + ", reimb_resolved=" + reimb_resolved + ", reimb_description=" + reimb_description
				+ ", reimb_author_fk=" + reimb_author_fk + ", reimb_resolver_fk=" + reimb_resolver_fk
				+ ", reimb_status_fk=" + reimb_status_fk + ", reimb_type_fk=" + reimb_type_fk + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(reimb_amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((reimb_author_fk == null) ? 0 : reimb_author_fk.hashCode());
		result = prime * result + ((reimb_description == null) ? 0 : reimb_description.hashCode());
		result = prime * result + reimb_id;
		result = prime * result + ((reimb_resolved == null) ? 0 : reimb_resolved.hashCode());
		result = prime * result + ((reimb_resolver_fk == null) ? 0 : reimb_resolver_fk.hashCode());
		result = prime * result + ((reimb_status_fk == null) ? 0 : reimb_status_fk.hashCode());
		result = prime * result + ((reimb_submitted == null) ? 0 : reimb_submitted.hashCode());
		result = prime * result + ((reimb_type_fk == null) ? 0 : reimb_type_fk.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErsReimbursement other = (ErsReimbursement) obj;
		if (Double.doubleToLongBits(reimb_amount) != Double.doubleToLongBits(other.reimb_amount))
			return false;
		if (reimb_author_fk == null) {
			if (other.reimb_author_fk != null)
				return false;
		} else if (!reimb_author_fk.equals(other.reimb_author_fk))
			return false;
		if (reimb_description == null) {
			if (other.reimb_description != null)
				return false;
		} else if (!reimb_description.equals(other.reimb_description))
			return false;
		if (reimb_id != other.reimb_id)
			return false;
		if (reimb_resolved == null) {
			if (other.reimb_resolved != null)
				return false;
		} else if (!reimb_resolved.equals(other.reimb_resolved))
			return false;
		if (reimb_resolver_fk == null) {
			if (other.reimb_resolver_fk != null)
				return false;
		} else if (!reimb_resolver_fk.equals(other.reimb_resolver_fk))
			return false;
		if (reimb_status_fk == null) {
			if (other.reimb_status_fk != null)
				return false;
		} else if (!reimb_status_fk.equals(other.reimb_status_fk))
			return false;
		if (reimb_submitted == null) {
			if (other.reimb_submitted != null)
				return false;
		} else if (!reimb_submitted.equals(other.reimb_submitted))
			return false;
		if (reimb_type_fk == null) {
			if (other.reimb_type_fk != null)
				return false;
		} else if (!reimb_type_fk.equals(other.reimb_type_fk))
			return false;
		return true;
	}
	
	
	

}
