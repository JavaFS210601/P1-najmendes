package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.services.EmployeeService;


public class EmployeeController {
	
	private EmployeeService empServe = new EmployeeService();
	private ObjectMapper objectMapper = new ObjectMapper();
	
	
	public void viewAllTickets(HttpServletResponse response) throws IOException {

		List<Reimbursement> reimbursementsList = empServe.viewAllTickets();
			
		String json = objectMapper.writeValueAsString(reimbursementsList);
		
		response.getWriter().print(json);	
		
		response.setStatus(200);
		
	}
	
	

}
