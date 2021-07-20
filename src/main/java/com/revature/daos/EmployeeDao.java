package com.revature.daos;

import java.util.List;

import javax.persistence.Parameter;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.revature.models.LoginDTO;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class EmployeeDao implements EmployeeDaoInterface {
	
	LoginDTO userCredentials = new LoginDTO();
	
	public boolean validateLogin(LoginDTO user) {
		
		Session session = HibernateUtil.getSession();

		boolean correctCredentials = false;
		
		List<User> userList = session.createQuery("FROM User").list();  //REMEMBER THAT HQL USES THE NAME OF THE CLASSES IN JAVA not the name used in the db!!!!!
		
			for (User u : userList) {
				
				if(u.getUsername().equals(user.getUsername())) {
					
					u.getUser_password();
					
					if (u.getUser_password().equals(user.getPassword())) {
						correctCredentials = true;
						return correctCredentials;
					}		
				}	
			}
		HibernateUtil.closeSession();
		return correctCredentials;
	}

				
		//In P1 : (Ben's suggestion) have a dao method to return one user or all users loop through array list and see if input matches one of them			
	
	
	public User retrieveUsersProfile(int id){
		
		Session session = HibernateUtil.getSession();
		
			User user = session.get(User.class, id); //get() gets an object straight from the db and skips the cache	
			//here we're saying "Create a new book object by getting the book from the db that has this id"
			
			HibernateUtil.closeSession();
			
			return user;	
		}

	
		 
	
	
	public void insertReimbursement(Reimbursement reimbursement) { //must be put in Reim_Status DAO
			
		//Open a session object so that we can connect to the db 
			
		Session session = HibernateUtil.getSession(); //Note the parallels btw ConnectionUtil.getConnection() in JDBC!
			
		session.save(reimbursement); //Refer to notes if you don't recognize this method - it's a method for insert functionality
			
		HibernateUtil.closeSession(); //Close our session (not super necessary here, but good practice)
			
		//That's the whole insert method,
		//DAO methods are significantly cleaner w/ Hibernate than JDBC				
	}

}
