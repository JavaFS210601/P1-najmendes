package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "reimbursements_statuses")
public class ReimbursementStatus {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int reimb_status_id;
	
	@Column(name = "reimb_status")
	private String reimb_status;
	
	@JsonIgnoreProperties("reimb_status_fk")
	@OneToMany(mappedBy = "reimb_status_fk", fetch = FetchType.EAGER)
	private List<Reimbursement> reimbursement;

	//boiler plate code below--------------------------------------------------------------------


	public ReimbursementStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReimbursementStatus(String reimb_status, List<Reimbursement> reimbursement) {
		super();
		this.reimb_status = reimb_status;
		this.reimbursement = reimbursement;
	}

	public ReimbursementStatus(int reimb_status_id, String reimb_status, List<Reimbursement> reimbursement) {
		super();
		this.reimb_status_id = reimb_status_id;
		this.reimb_status = reimb_status;
		this.reimbursement = reimbursement;
	}

	@Override
	public String toString() {
		return "ReimbursementStatus [reimb_status_id=" + reimb_status_id + ", reimb_status=" + reimb_status
				+ ", reimbursement=" + reimbursement + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reimb_status == null) ? 0 : reimb_status.hashCode());
		result = prime * result + reimb_status_id;
		result = prime * result + ((reimbursement == null) ? 0 : reimbursement.hashCode());
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
		ReimbursementStatus other = (ReimbursementStatus) obj;
		if (reimb_status == null) {
			if (other.reimb_status != null)
				return false;
		} else if (!reimb_status.equals(other.reimb_status))
			return false;
		if (reimb_status_id != other.reimb_status_id)
			return false;
		if (reimbursement == null) {
			if (other.reimbursement != null)
				return false;
		} else if (!reimbursement.equals(other.reimbursement))
			return false;
		return true;
	}

	public int getReimb_status_id() {
		return reimb_status_id;
	}

	public void setReimb_status_id(int reimb_status_id) {
		this.reimb_status_id = reimb_status_id;
	}

	public String getReimb_status() {
		return reimb_status;
	}

	public void setReimb_status(String reimb_status) {
		this.reimb_status = reimb_status;
	}

	public List<Reimbursement> getReimbursement() {
		return reimbursement;
	}

	public void setReimbursement(List<Reimbursement> reimbursement) {
		this.reimbursement = reimbursement;
	}
	
	
	
	
}//class
