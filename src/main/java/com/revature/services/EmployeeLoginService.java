package com.revature.services;

import java.util.List;

import com.revature.daos.EmployeeDao;
import com.revature.models.LoginDTO;
import com.revature.models.Reimbursement;
import com.revature.models.User;

public class EmployeeLoginService {
	
	private EmployeeDao employeeDao = new EmployeeDao();
	
	

	public boolean login(LoginDTO user) {
		
		if(employeeDao.validateLogin(user)) {
			return true;
			}
			return false;
	}
		

	
	
	
	
	
	
	
	
	public User viewAllTickets(int id) {
		return employeeDao.viewAllTicketsById(id);
	}

} //view all tickets
