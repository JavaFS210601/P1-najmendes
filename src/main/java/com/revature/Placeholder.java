package com.revature;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.utils.HibernateUtil;

public class Placeholder {
	//this is a placeholder so that this project pushes correctly
	
	//Remember your project won't have a launcher!! 
	//it'll have a master servlet though
	
	
	//THERE'S NO LAUNCHER IN THIS PROJECT, BUT I NEED A LAUNCHER TO MAKE SURE CONNECTION 
	//AND OTHER STUFF WORKS!!!

	
	
	public static List<User> selectAllUsers(){
		
		Session session = HibernateUtil.getSession();
		
		List<User> userList = session.createQuery("FROM User").list();
		
		HibernateUtil.closeSession();
		
		return userList;

	}
	
	public static List<Reimbursement> selectAllReimbursements(){
		
		Session session = HibernateUtil.getSession();
		
		List<Reimbursement> reimbursementList = session.createQuery("FROM Reimbursement").list();
		
		HibernateUtil.closeSession();
		
		return reimbursementList;
		
	}
	
	
	
	
	public static void insertReimbType(ReimbursementType type) { //must be put in Reim_Type DAO
		
		//Open a session object so that we can connect to the db 
		
		Session session = HibernateUtil.getSession(); //Note the parallels btw ConnectionUtil.getConnection() in JDBC!
		
		session.save(type); //Refer to notes if you don't recognize this method - it's a method for insert functionality
		
		HibernateUtil.closeSession(); //Close our session (not super necessary here, but good practice)
		
		//That's the whole insert method,
		//DAO methods are significantly cleaner w/ Hibernate than JDBC				
	}
	
	public static void insertReimbStatus(ReimbursementStatus status) { //must be put in Reim_Status DAO
		
		//Open a session object so that we can connect to the db 
		
		Session session = HibernateUtil.getSession(); //Note the parallels btw ConnectionUtil.getConnection() in JDBC!
		
		session.save(status); //Refer to notes if you don't recognize this method - it's a method for insert functionality
		
		HibernateUtil.closeSession(); //Close our session (not super necessary here, but good practice)
		
		//That's the whole insert method,
		//DAO methods are significantly cleaner w/ Hibernate than JDBC				
	}
	
	public static void insertReimbursement(Reimbursement reimbursement) { //must be put in Reim_Status DAO
		
		//Open a session object so that we can connect to the db 
		
		Session session = HibernateUtil.getSession(); //Note the parallels btw ConnectionUtil.getConnection() in JDBC!
		
		session.save(reimbursement); //Refer to notes if you don't recognize this method - it's a method for insert functionality
		
		HibernateUtil.closeSession(); //Close our session (not super necessary here, but good practice)
		
		//That's the whole insert method,
		//DAO methods are significantly cleaner w/ Hibernate than JDBC				
	}
	
	
	
	

	public static void insertUser(User user) { //can be added to ___ dao if we want signup capability
		
		//Open a session object so that we can connect to the db 
		
		Session session = HibernateUtil.getSession(); //Note the parallels btw ConnectionUtil.getConnection() in JDBC!
		
		session.save(user); //Refer to notes if you don't recognize this method - it's a method for insert functionality
		
		HibernateUtil.closeSession(); //Close our session (not super necessary here, but good practice)
		
		//That's the whole insert method,
		//DAO methods are significantly cleaner w/ Hibernate than JDBC				
	}
	
	public static void insertRoles(UserRole role) { //must be put in user_roles DAO
		
		//Open a session object so that we can connect to the db 
		
		Session session = HibernateUtil.getSession(); //Note the parallels btw ConnectionUtil.getConnection() in JDBC!
		
		session.save(role); //Refer to notes if you don't recognize this method - it's a method for insert functionality
		
		HibernateUtil.closeSession(); //Close our session (not super necessary here, but good practice)
		
		//That's the whole insert method,
		//DAO methods are significantly cleaner w/ Hibernate than JDBC				
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
// INSERTING POSSIBLE USER ROLES INTO TABLE		
		UserRole author = new UserRole("reimb_author", null);
		UserRole resolver = new UserRole("reimb_resolver", null);
		
		insertRoles(author); //1
		insertRoles(resolver); //2
		
		// TESTING IF INSERTING INTO USER TABLE WORKS
		
		User one = new User("one","one","jane","doe","jdoe@fmail.com",author, null, null);
		User two = new User("two","two","john","doe","johndoe@fmail.com",author, null, null);
		User three = new User("three","three","henry","doe","hdoe@fmail.com",author, null, null);
		User four = new User("four","four","gary","tiff","gtiff@aol.net",author, null, null);
		///add more authors
		
		
		
		
		User five = new User("five","five","manuel","duffy","mandu@aol.net",resolver, null, null);
		User six = new User("six","six","uri","oka","urioka@aol.net",resolver, null, null);
		User seven = new User("seven","seven","suzie","micquele","suzmic@aol.net",resolver, null, null);
		//add one more resolver
		
		insertUser(one);
		insertUser(two);
		insertUser(three);
		insertUser(four);
		insertUser(five);
		insertUser(six);
		insertUser(seven);
		
		
// INSERTING POSSIBLE REIMBURSEMENT STATUSES INTO TABLE
			
		ReimbursementStatus approved = new ReimbursementStatus("approved",null);
		ReimbursementStatus denied= new ReimbursementStatus("denied",null);
		
		insertReimbStatus(approved); //1
		insertReimbStatus(denied); //2
		
		
// INSERTING POSSIBLE REIMBURSEMENT TYPES INTO TABLE
		
		ReimbursementType lodging = new ReimbursementType("lodging",null);
		ReimbursementType travel = new ReimbursementType("travel",null);
		ReimbursementType food= new ReimbursementType("food",null);
		ReimbursementType other= new ReimbursementType("other",null);
		
		insertReimbType(lodging); //1
		insertReimbType(travel); //2
		insertReimbType(food);   //3
		insertReimbType(other); //4
		
		
		// TESTING IF INSERTING INTO REIMBUREMENT TABLE WORKS
		//Reimbursement
		
		Reimbursement reimb1 = new Reimbursement(125,"06/10/2020","06/21/2020","got some food on trip",one,five, approved, food);
		Reimbursement reimb2 = new Reimbursement(300,"06/10/2020","06/21/2020","had to stay overnight",one,six, approved, lodging);
		Reimbursement reimb3 = new Reimbursement(20,"10/10/2019","11/01/2019","traveled to work",two,seven, denied, travel);
		Reimbursement reimb4 = new Reimbursement(500,"01/10/2021","01/21/2021","got food with clients",four,five, approved, food);
		Reimbursement reimb5 = new Reimbursement(1792,"05/10/2018","07/21/2018","boss said to request reimbursement",three,six, denied, other);
		Reimbursement reimb6 = new Reimbursement(1792,"08/10/2018","08/21/2018","several issues were made",three,seven, approved, travel);
		Reimbursement reimb7 = new Reimbursement(212,"01/10/2021","01/21/2021","got a room for client",four,five, denied, lodging);
		Reimbursement reimb8 = new Reimbursement(523,"07/19/2021",null,"got stranded out of state",two,null, null, lodging);
	
		
		//insertReimb
		
		insertReimbursement(reimb1);
		insertReimbursement(reimb2);
		insertReimbursement(reimb3);
		insertReimbursement(reimb4);
		insertReimbursement(reimb5);
		insertReimbursement(reimb6);
		insertReimbursement(reimb7);
		insertReimbursement(reimb8);
		
	
		List<User> users = selectAllUsers();
		
	
		List<Reimbursement> reimbursements = selectAllReimbursements();
		
			for(User u : users) {
				System.out.println(u);
			}
		
			for(Reimbursement r :reimbursements) {
				System.out.println(r);
			}
		
	}
}
