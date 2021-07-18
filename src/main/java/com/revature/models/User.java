package com.revature.models;

import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int user_id;
	
	@Column(name = "username", nullable = false, unique = true)//unique
	private String username;
	
	@Column(name = "user_password", nullable = false)
	private String user_password;
	
	@Column(name = "first_name", nullable = false)
	private String first_name;
	
	@Column(name = "last_name", nullable = false)
	private String last_name;
	
	@Column(name = "user_email", unique = true)//unique
	private String user_email;
	
	@JsonIgnoreProperties("user")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_role_id") 
	private UserRole user_role_fk;

//	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinColumn(name = "reimb_id") 
//	private Reimbursement reimbursement; 
	//this one above is NOT needed because the @OneToMany below will
	//fulfill the list of reimbursements connected to this user
	//SCRATCH THAT!!! FOR SOME REASON THIS NOT WORKING...SO I THINK THIS MAY ACTUALLY BE NEEDED
	//POSSIBLY TO SHOW THE current REIMBURSEMENT REQUEST AS OPPOSED TO THE LIST OF OLD ONES
	
	@JsonIgnoreProperties("author")
	@OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
	List<Reimbursement> reimbursementsOfAuthor;
	
	@JsonIgnoreProperties("resolver")
	@OneToMany(mappedBy = "resolver", fetch = FetchType.EAGER)
	List<Reimbursement> reimbursementsOfResolver;



	//boiler plate code below----------------------------------------------------------------


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public User(String username, String user_password, String first_name, String last_name, String user_email,
			UserRole user_role_fk, List<Reimbursement> reimbursementsOfAuthor,
			List<Reimbursement> reimbursementsOfResolver) {
		super();
		this.username = username;
		this.user_password = user_password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.user_email = user_email;
		this.user_role_fk = user_role_fk;
		this.reimbursementsOfAuthor = reimbursementsOfAuthor;
		this.reimbursementsOfResolver = reimbursementsOfResolver;
	}



	public User(int user_id, String username, String user_password, String first_name, String last_name,
			String user_email, UserRole user_role_fk, List<Reimbursement> reimbursementsOfAuthor,
			List<Reimbursement> reimbursementsOfResolver) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.user_password = user_password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.user_email = user_email;
		this.user_role_fk = user_role_fk;
		this.reimbursementsOfAuthor = reimbursementsOfAuthor;
		this.reimbursementsOfResolver = reimbursementsOfResolver;
	}

	
//	@Override
//	public String toString() {	
//
//		return "User [user_id=" + user_id + ", username=" + username + ", user_password=" + user_password
//				+ ", first_name=" + first_name + ", last_name=" + last_name + ", user_email=" + user_email
//				+ ", user_role_fk=" + user_role_fk.getUser_role() + ", reimbursementsOfUser=" + reimbursementsOfUser + "]";
//	}
	
	
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", user_password=" + user_password
				+ ", first_name=" + first_name + ", last_name=" + last_name + ", user_email=" + user_email
				+ ", user_role_fk=" + user_role_fk.getUser_role() + ", reimbursementsOfAuthor=" + reimbursementsOfAuthor
				+ ", reimbursementsOfResolver=" + reimbursementsOfResolver + "]";
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + ((reimbursementsOfAuthor == null) ? 0 : reimbursementsOfAuthor.hashCode());
		result = prime * result + ((reimbursementsOfResolver == null) ? 0 : reimbursementsOfResolver.hashCode());
		result = prime * result + ((user_email == null) ? 0 : user_email.hashCode());
		result = prime * result + user_id;
		result = prime * result + ((user_password == null) ? 0 : user_password.hashCode());
		result = prime * result + ((user_role_fk == null) ? 0 : user_role_fk.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (reimbursementsOfAuthor == null) {
			if (other.reimbursementsOfAuthor != null)
				return false;
		} else if (!reimbursementsOfAuthor.equals(other.reimbursementsOfAuthor))
			return false;
		if (reimbursementsOfResolver == null) {
			if (other.reimbursementsOfResolver != null)
				return false;
		} else if (!reimbursementsOfResolver.equals(other.reimbursementsOfResolver))
			return false;
		if (user_email == null) {
			if (other.user_email != null)
				return false;
		} else if (!user_email.equals(other.user_email))
			return false;
		if (user_id != other.user_id)
			return false;
		if (user_password == null) {
			if (other.user_password != null)
				return false;
		} else if (!user_password.equals(other.user_password))
			return false;
		if (user_role_fk == null) {
			if (other.user_role_fk != null)
				return false;
		} else if (!user_role_fk.equals(other.user_role_fk))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}



	public int getUser_id() {
		return user_id;
	}



	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getUser_password() {
		return user_password;
	}



	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}



	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	public String getLast_name() {
		return last_name;
	}



	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}



	public String getUser_email() {
		return user_email;
	}



	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}



	public UserRole getUser_role_fk() {
		return user_role_fk;
	}



	public void setUser_role_fk(UserRole user_role_fk) {
		this.user_role_fk = user_role_fk;
	}



	public List<Reimbursement> getReimbursementsOfAuthor() {
		return reimbursementsOfAuthor;
	}



	public void setReimbursementsOfAuthor(List<Reimbursement> reimbursementsOfAuthor) {
		this.reimbursementsOfAuthor = reimbursementsOfAuthor;
	}



	public List<Reimbursement> getReimbursementsOfResolver() {
		return reimbursementsOfResolver;
	}



	public void setReimbursementsOfResolver(List<Reimbursement> reimbursementsOfResolver) {
		this.reimbursementsOfResolver = reimbursementsOfResolver;
	}
	
	

	



	

}//class
