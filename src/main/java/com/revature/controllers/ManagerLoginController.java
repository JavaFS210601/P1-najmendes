package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.LoginDTO;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.ManagerLoginService;

public class ManagerLoginController {
		
	private ManagerLoginService managerLoginService = new ManagerLoginService();
	private ObjectMapper objectMapper = new ObjectMapper();
	final Logger log = LogManager.getLogger(ManagerLoginController.class);

	public void loginManager(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		if (request.getMethod().equals("POST")) { //post MUST BE CAPITAL!!! ("POST") not ("Post")
			
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
		
				//if the username/password of the object sent to the service are valid...do this...
				if(managerLoginService.login(loginDTO)) {
					
					HttpSession session = request.getSession();
					
					session.setAttribute("user", loginDTO);
					session.setAttribute("loggedin", true);
					
					response.setStatus(200); //successfully retrieved manager
					response.getWriter().print("Hello, " + loginDTO.username + " is logged in!" );
					log.info(loginDTO.username + " :Successful manager login");
					
				} else {
					
					HttpSession session = request.getSession(false);
					
						if (session != null) {
							session.invalidate();
						}
					
					response.setStatus(401);
					response.getWriter().print("Login Invalid");
					log.warn("Invalid credentials entered for manager login");
					
				}	
		
		}
	
	}

	
	
	public void viewAllTickets(HttpServletResponse response) throws IOException {
		
		List<Reimbursement> allReimbursementsList = managerLoginService.viewAllTickets();
		
		String json = objectMapper.writeValueAsString(allReimbursementsList);
		
		response.getWriter().print(json);
		
		response.setStatus(200);
		log.info("Manager request to view tickets");
	}	

				
	
	
	public void viewResolvingTicket(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
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
		Reimbursement userInput = objectMapper.readValue(postBody, Reimbursement.class);
		

		Reimbursement ticket2bResolved = managerLoginService.viewResolvingTicket(userInput.getReimb_id());
		
		String json = objectMapper.writeValueAsString(ticket2bResolved);
		
		response.getWriter().print(json);

		response.setStatus(200);
		log.info("Employee request to view tickets");
	
}//view tickets method	
	
	
	
	
	
	
	//manager resolveTicket() ...add log.warn("Ticket information has been updated");
	
	public void resolveTicket(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		if (request.getMethod().equals("POST")) { //post MUST BE CAPITAL!!! ("POST") not ("Post")
			
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
			Reimbursement resolvePendingTicket = objectMapper.readValue(postBody, Reimbursement.class);
			
					
			managerLoginService.resolveTicket(resolvePendingTicket);

						
				response.setStatus(200); //successfully retrieved manager
				response.getWriter().print("Ticket resolved");
				log.info("Ticket resolved successfully");
											
		}
	}
	

}//class
