package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.LoginDTO;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.EmployeeLoginService;
import com.revature.utils.HibernateUtil;


public class EmployeeLoginController {
	
	private EmployeeLoginService employeeService = new EmployeeLoginService();
	private ObjectMapper objectMapper = new ObjectMapper();
	
	public void loginEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		if (request.getMethod().equals("POST")) {
			
			//this process below is to get our JSON string
			BufferedReader bufferedReader = request.getReader();
			
			StringBuilder stringBuilder = new StringBuilder();
			
			String line = bufferedReader.readLine();
			
				while (line != null) {
					
					stringBuilder.append(line);
					line = bufferedReader.readLine();
				}//while
			
			String postBody = new String(stringBuilder);
			
			//we created a LoginDTO using the JSON turned Java "read this JSON(body) into this object (lDTO) and model it after this class (LoginDTO)
			LoginDTO loginDTO = objectMapper.readValue(postBody, LoginDTO.class);
			
		
			//control flow to determine what happens in the event of a successful/unsuccessful login
		
				//if the username/password sent to the service are valid...do this...
				if(employeeService.login(loginDTO)) { 
					
					HttpSession session = request.getSession();
					
					session.setAttribute("user", loginDTO);
					session.setAttribute("loggedin", true);
					
					response.setStatus(200); //successfully retrieved manager
					response.getWriter().print("Hello, " + loginDTO.username + " is logged in!" );
					
				} else {
					
					HttpSession session = request.getSession(false);
					
						if (session != null) {
							session.invalidate();
						}
					
					response.setStatus(401);
					response.getWriter().print("Login Invalid");
					
				}			
		}	
	}
	
		
	
	
	
	public void employeeviewtickets(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
			//this process below is to get our JSON string
			BufferedReader bufferedReader = request.getReader();
			
			StringBuilder stringBuilder = new StringBuilder();
			
			String line = bufferedReader.readLine();
			
				while (line != null) {
					
					stringBuilder.append(line);
					line = bufferedReader.readLine();
				}//while
			
			String postBody = new String(stringBuilder);
			
			//we created a LoginDTO object using the JSON turned Java 
			User userInput = objectMapper.readValue(postBody, User.class);
			

			User employeeProfile = employeeService.viewAllTickets(userInput.getUser_id());
			
			String json = objectMapper.writeValueAsString(employeeProfile);
			
			response.getWriter().print(json);

			response.setStatus(200);
		
	}//view tickets method	
		
		

	
	
	
	//public void submitNewTicket(
	public void submitNewTicket (HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		if (request.getMethod().equals("POST")) {
					
					//this process below is to get our JSON string
					BufferedReader bufferedReader = request.getReader();
					
					StringBuilder stringBuilder = new StringBuilder();
					
					String line = bufferedReader.readLine();
					
						while (line != null) {
							
							stringBuilder.append(line);
							line = bufferedReader.readLine();
						}//while
					
					String postBody = new String(stringBuilder);
					
					//we created a LoginDTO using the JSON turned Java "read this JSON(body) into this object (lDTO) and model it after this class (LoginDTO)
					Reimbursement newReimb = objectMapper.readValue(postBody, Reimbursement.class);
					
					employeeService.submitNewTicket(newReimb);
				
					//control flow to determine what happens in the event of a successful/unsuccessful login
				
						//if the username/password sent to the service are valid...do this...
//						if(employeeService.submitNewTicket(newReimb)) { 
//							
//							HttpSession session = request.getSession();
//							
//							session.setAttribute("user", loginDTO);
//							session.setAttribute("loggedin", true);
//							
//							response.setStatus(200); //successfully retrieved manager
//							response.getWriter().print("Hello, " + loginDTO.username + " is logged in!" );
//							
//						} else {
//							
//							HttpSession session = request.getSession(false);
//							
//								if (session != null) {
//									session.invalidate();
//								}
//							
//							response.setStatus(401);
//							response.getWriter().print("Login Invalid");
//							
//						}			
				}	
				
	}
	

	
	
	
}//class
