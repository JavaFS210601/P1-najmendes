package com.revature.services;

import java.util.List;

import com.revature.daos.ManagerDao;
import com.revature.models.LoginDTO;
import com.revature.models.Reimbursement;
import com.revature.models.User;

public class ManagerLoginService {

	private ManagerDao managerDao = new ManagerDao();
		
	public boolean login(LoginDTO user) {
		
		if(managerDao.validateLogin(user)) {
			return true;
			}
			return false;
	}
	
	
	public List<Reimbursement> viewAllTickets(){
		return managerDao.selectAllReimbursements();	
	}
	
	
	
	public Reimbursement viewResolvingTicket(int id) {
		return managerDao.retrieveResolvingTicket(id);
	}
	
	

	
	
	
	public void resolveTicket(Reimbursement reimbursement) {
		managerDao.updateTicket(reimbursement);

	}
	
	
}//class
