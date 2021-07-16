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
@Table(name = "reimbursement_types")
public class ReimbursementType { 

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reimb_type_id;
	
	@Column(name = "reimb_type")
	private String reimb_type;
		
	@JsonIgnoreProperties("reimb_type_fk")
	@OneToMany(mappedBy = "reimb_type_fk", fetch = FetchType.EAGER)
	private List<Reimbursement> reimbursement;


	//boiler plate code below------------------------------------------------------------------

	public ReimbursementType() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ReimbursementType(String reimb_type, List<Reimbursement> reimbursement) {
		super();
		this.reimb_type = reimb_type;
		this.reimbursement = reimbursement;
	}


	public ReimbursementType(int reimb_type_id, String reimb_type, List<Reimbursement> reimbursement) {
		super();
		this.reimb_type_id = reimb_type_id;
		this.reimb_type = reimb_type;
		this.reimbursement = reimbursement;
	}


	@Override
	public String toString() {
		return "ReimbursementType [reimb_type_id=" + reimb_type_id + ", reimb_type=" + reimb_type + ", reimbursement="
				+ reimbursement + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reimb_type == null) ? 0 : reimb_type.hashCode());
		result = prime * result + reimb_type_id;
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
		ReimbursementType other = (ReimbursementType) obj;
		if (reimb_type == null) {
			if (other.reimb_type != null)
				return false;
		} else if (!reimb_type.equals(other.reimb_type))
			return false;
		if (reimb_type_id != other.reimb_type_id)
			return false;
		if (reimbursement == null) {
			if (other.reimbursement != null)
				return false;
		} else if (!reimbursement.equals(other.reimbursement))
			return false;
		return true;
	}


	public int getReimb_type_id() {
		return reimb_type_id;
	}


	public void setReimb_type_id(int reimb_type_id) {
		this.reimb_type_id = reimb_type_id;
	}


	public String getReimb_type() {
		return reimb_type;
	}


	public void setReimb_type(String reimb_type) {
		this.reimb_type = reimb_type;
	}


	public List<Reimbursement> getReimbursement() {
		return reimbursement;
	}


	public void setReimbursement(List<Reimbursement> reimbursement) {
		this.reimbursement = reimbursement;
	}
	
	
	
	
	
}//class
