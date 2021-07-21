package com.revature.daos;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.LoginDTO;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class ManagerDao implements ManagerDaoInterface {

	LoginDTO userCredentials = new LoginDTO();
	final Logger log = LogManager.getLogger(ManagerDao.class);
	
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
	
	
	
	
	
	public Reimbursement retrieveResolvingTicket(int id){
		
		Session session = HibernateUtil.getSession();
		
		Reimbursement reimbursement = session.get(Reimbursement.class, id); //get() gets an object straight from the db and skips the cache	
			//here we're saying "Create a new book object by getting the book from the db that has this id"
			
			HibernateUtil.closeSession();
			
			return reimbursement;	
		}
	
	
	
	
	
	
	
	
	
	public void updateTicket(Reimbursement reimbursement) { //must be put in Reim_Status DAO
			
		Transaction transactionOne = null;
		Transaction transactionTwo = null;
		
		Session sessionOne = HibernateUtil.getSessionFactory().openSession(); //Note the parallels btw ConnectionUtil.getConnection() in JDBC!
			
			transactionOne = sessionOne.beginTransaction();
			
				Reimbursement pendingResolve = new Reimbursement(
						
						reimbursement.getReimb_amount(),
						reimbursement.getDate_submitted(),
						reimbursement.getDate_resolved(),
						reimbursement.getReimb_description(),
						reimbursement.getAuthor(),
						reimbursement.getResolver(),
						reimbursement.getReimb_status_fk(),
						reimbursement.getReimb_type_fk()
						);
			
				sessionOne.save(pendingResolve);
			
			transactionOne.commit();
			
			sessionOne.close();
			
		Session sessionTwo = HibernateUtil.getSessionFactory().openSession();
			
			transactionTwo = sessionTwo.beginTransaction();
		
				pendingResolve.setReimb_id(reimbursement.getReimb_id());
				
				sessionTwo.merge(pendingResolve);
			
			transactionTwo.commit();
			
			sessionTwo.close();

	
	}		

	
	
	/*
	 * WEBSITE THAT HELPED ME FIGURE OUT THIS UPDATING/RESOLVING TICKET:
	 * 
	 * https://www.javaguides.net/2018/11/hibernate-merge-example.html#:~:text=Hibernate%205%20-%20merge%20%28%29%20Example.%201%201.,a%20Hibernate%20configuration%20file%20-%20hibernate.cfg.xml.%20More%20items
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	
	
	
	
	
	
	
	
	
	
}//class end



	