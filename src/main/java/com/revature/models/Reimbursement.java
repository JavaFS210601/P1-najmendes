package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "reimbursements")
public class Reimbursement {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int reimb_id;
	
	@Column (name = "reimb_amount", nullable = false)
	private int reimb_amount;
	
	
	@Column (name = "date_submitted")
	private String date_submitted; //date
	
	
	@Column (name = "date_resolved")
	private String date_resolved; //date
	
	
	@Column (name = "reimb_description")
	private String reimb_description;
	
	
//	@OneToMany(mappedBy = "user_id", fetch = FetchType.EAGER)
//	private List<User> authorAndResolver;
	
	@JsonIgnoreProperties("reimbursementsOfAuthor")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id") //id of author
	private User author;
	
	@JsonIgnoreProperties("reimbursementsOfResolver")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_email")//email of resolver
	private User resolver;

	@JsonIgnoreProperties("reimbursement")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "reimb_status_id")
	private ReimbursementStatus reimb_status_fk;
	
	@JsonIgnoreProperties("reimbursement")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "reimb_type_id")
	private ReimbursementType reimb_type_fk;




	
	//boiler plate code below-----------------------------------------------------------------

	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Reimbursement(int reimb_amount, String date_submitted, String date_resolved, String reimb_description,
			User author, User resolver, ReimbursementStatus reimb_status_fk, ReimbursementType reimb_type_fk) {
		super();
		this.reimb_amount = reimb_amount;
		this.date_submitted = date_submitted;
		this.date_resolved = date_resolved;
		this.reimb_description = reimb_description;
		this.author = author;
		this.resolver = resolver;
		this.reimb_status_fk = reimb_status_fk;
		this.reimb_type_fk = reimb_type_fk;
	}





	public Reimbursement(int reimb_id, int reimb_amount, String date_submitted, String date_resolved,
			String reimb_description, User author, User resolver, ReimbursementStatus reimb_status_fk,
			ReimbursementType reimb_type_fk) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.date_submitted = date_submitted;
		this.date_resolved = date_resolved;
		this.reimb_description = reimb_description;
		this.author = author;
		this.resolver = resolver;
		this.reimb_status_fk = reimb_status_fk;
		this.reimb_type_fk = reimb_type_fk;
	}



//	@Override
//	public String toString() {
//		return "Reimbursement [reimb_id=" + reimb_id + ", reimb_amount=" + reimb_amount + ", date_submitted="
//				+ date_submitted + ", date_resolved=" + date_resolved + ", reimb_description=" + reimb_description
//				+ ", user=" + user.getUser_id() + " " + user.getFirst_name() + " " + user.getLast_name() 
//				+ ", reimb_status_fk=" + reimb_status_fk.getReimb_status() + ", reimb_type_fk=" + reimb_type_fk.getReimb_type() + "]";
//	}

	@Override
	public String toString() {
		return "Reimbursement [reimb_id=" + reimb_id + ", reimb_amount=" + reimb_amount + ", date_submitted="
				+ date_submitted + ", date_resolved=" + date_resolved + ", reimb_description=" + reimb_description
				+ ", author= " + author.getUser_id() + ": " + author.getFirst_name() + " " + author.getLast_name() + " " + author.getUser_email() 
				+ ", resolver= " +  resolver.getFirst_name() + " " + resolver.getLast_name() + " " + resolver.getUser_email()  
				+ ", reimb_status_fk=" + reimb_status_fk.getReimb_status() + ", reimb_type_fk=" + reimb_type_fk.getReimb_type() + "]";
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((date_resolved == null) ? 0 : date_resolved.hashCode());
		result = prime * result + ((date_submitted == null) ? 0 : date_submitted.hashCode());
		result = prime * result + reimb_amount;
		result = prime * result + ((reimb_description == null) ? 0 : reimb_description.hashCode());
		result = prime * result + reimb_id;
		result = prime * result + ((reimb_status_fk == null) ? 0 : reimb_status_fk.hashCode());
		result = prime * result + ((reimb_type_fk == null) ? 0 : reimb_type_fk.hashCode());
		result = prime * result + ((resolver == null) ? 0 : resolver.hashCode());
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
		Reimbursement other = (Reimbursement) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (date_resolved == null) {
			if (other.date_resolved != null)
				return false;
		} else if (!date_resolved.equals(other.date_resolved))
			return false;
		if (date_submitted == null) {
			if (other.date_submitted != null)
				return false;
		} else if (!date_submitted.equals(other.date_submitted))
			return false;
		if (reimb_amount != other.reimb_amount)
			return false;
		if (reimb_description == null) {
			if (other.reimb_description != null)
				return false;
		} else if (!reimb_description.equals(other.reimb_description))
			return false;
		if (reimb_id != other.reimb_id)
			return false;
		if (reimb_status_fk == null) {
			if (other.reimb_status_fk != null)
				return false;
		} else if (!reimb_status_fk.equals(other.reimb_status_fk))
			return false;
		if (reimb_type_fk == null) {
			if (other.reimb_type_fk != null)
				return false;
		} else if (!reimb_type_fk.equals(other.reimb_type_fk))
			return false;
		if (resolver == null) {
			if (other.resolver != null)
				return false;
		} else if (!resolver.equals(other.resolver))
			return false;
		return true;
	}





	public int getReimb_id() {
		return reimb_id;
	}





	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}





	public int getReimb_amount() {
		return reimb_amount;
	}





	public void setReimb_amount(int reimb_amount) {
		this.reimb_amount = reimb_amount;
	}





	public String getDate_submitted() {
		return date_submitted;
	}





	public void setDate_submitted(String date_submitted) {
		this.date_submitted = date_submitted;
	}





	public String getDate_resolved() {
		return date_resolved;
	}





	public void setDate_resolved(String date_resolved) {
		this.date_resolved = date_resolved;
	}





	public String getReimb_description() {
		return reimb_description;
	}





	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}





	public User getAuthor() {
		return author;
	}





	public void setAuthor(User author) {
		this.author = author;
	}





	public User getResolver() {
		return resolver;
	}





	public void setResolver(User resolver) {
		this.resolver = resolver;
	}





	public ReimbursementStatus getReimb_status_fk() {
		return reimb_status_fk;
	}





	public void setReimb_status_fk(ReimbursementStatus reimb_status_fk) {
		this.reimb_status_fk = reimb_status_fk;
	}





	public ReimbursementType getReimb_type_fk() {
		return reimb_type_fk;
	}





	public void setReimb_type_fk(ReimbursementType reimb_type_fk) {
		this.reimb_type_fk = reimb_type_fk;
	}
	

	


	
	
	
	
	
	
}//class
