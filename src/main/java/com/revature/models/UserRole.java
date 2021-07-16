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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




@Entity
@Table(name = "user_roles")
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_role_id;
	
	
	@Column(name = "user_role")
	private String user_role;

	@JsonIgnoreProperties("user_role_fk")
	@OneToMany(mappedBy = "user_role_fk", fetch = FetchType.EAGER)
	private List<User> user;



	//boiler plate code below --------------------------------------------------------

	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}



	public UserRole(String user_role, List<User> user) {
		super();
		this.user_role = user_role;
		this.user = user;
	}



	public UserRole(int user_role_id, String user_role, List<User> user) {
		super();
		this.user_role_id = user_role_id;
		this.user_role = user_role;
		this.user = user;
	}



	@Override
	public String toString() {
		return "UserRole [user_role_id=" + user_role_id + ", user_role=" + user_role + ", user=" + user + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((user_role == null) ? 0 : user_role.hashCode());
		result = prime * result + user_role_id;
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
		UserRole other = (UserRole) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (user_role == null) {
			if (other.user_role != null)
				return false;
		} else if (!user_role.equals(other.user_role))
			return false;
		if (user_role_id != other.user_role_id)
			return false;
		return true;
	}



	public int getUser_role_id() {
		return user_role_id;
	}



	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}



	public String getUser_role() {
		return user_role;
	}



	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}



	public List<User> getUser() {
		return user;
	}



	public void setUser(List<User> user) {
		this.user = user;
	}
	
	
	
}//class
