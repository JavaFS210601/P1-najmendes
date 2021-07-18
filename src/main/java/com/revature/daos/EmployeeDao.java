package com.revature.daos;

import java.util.List;

import javax.persistence.Parameter;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.revature.models.LoginDTO;
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
	
	
	
	
	public static List<User> selectAllUsers(){
		
		Session session = HibernateUtil.getSession();
		
		List<User> userList = session.createQuery("FROM User").list();
		
		HibernateUtil.closeSession();
		
		return userList;

	}
	
	
//	@Override
//	public void submitReimbursementRequest() {
//		// TODO Auto-generated method stub
//		
//	}

//	@Override
	public User viewAllTicketsById(int id) { //this method actually needs to be in the manager's DAO
												 //this method in this class must be viewAllTicketsByUserId
		
		Session session = HibernateUtil.getSession();
		
		User usersTickets = session.get(User.class, id);
		
//		Query query = session.createQuery("from reimbursements where author = :username");
//		
//		List<Reimbursement> authorReimbursementList = (List<Reimbursement>) query.setParameter(username, "username");
		
//		 = query.list();
		
		HibernateUtil.closeSession();
		
		return usersTickets;
		
	}

}
