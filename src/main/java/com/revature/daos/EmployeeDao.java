package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Reimbursement;
import com.revature.utils.HibernateUtil;

public class EmployeeDao implements EmployeeDaoInterface {

	@Override
	public void submitReimbursementRequest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Reimbursement> viewAllTickets() { //this method actually needs to be in the manager's DAO
												 //this method in this class must be viewAllTicketsByUserId
		
		Session session = HibernateUtil.getSession();
		
		List<Reimbursement> reimbursementList = session.createQuery("FROM Reimbursement").list();
		
		HibernateUtil.closeSession();
		
		return reimbursementList;
		
	}

}
