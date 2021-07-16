package com.revature.services;

import java.util.List;

import com.revature.daos.EmployeeDao;
import com.revature.models.Reimbursement;

public class EmployeeService {
	
	private EmployeeDao empDao = new EmployeeDao();

	public List<Reimbursement> viewAllTickets() {
		return empDao.viewAllTickets();
	}

}
