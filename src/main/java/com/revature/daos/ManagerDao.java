package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.LoginDTO;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class ManagerDao implements ManagerDaoInterface {

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


	
	
	
	
	public List<Reimbursement> selectAllReimbursements(){
		
		Session session = HibernateUtil.getSession();
		
		List<Reimbursement> reimbursementList = session.createQuery("FROM Reimbursement").list();
		
		HibernateUtil.closeSession();
		
		return reimbursementList;
		
	}
	
}//class end



	