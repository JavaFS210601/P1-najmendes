package com.revature.services;

import com.revature.daos.ManagerDao;
import com.revature.models.LoginDTO;

public class ManagerLoginService {

	private ManagerDao managerDao = new ManagerDao();
		
	public boolean login(LoginDTO user) {
		
		if(managerDao.validateLogin(user)) {
			return true;
			}
			return false;
	}
	
}
