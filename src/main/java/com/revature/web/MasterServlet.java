package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.EmployeeLoginController;
import com.revature.controllers.ManagerLoginController;



public class MasterServlet extends HttpServlet {
	
	private EmployeeLoginController employeeLoginController = new EmployeeLoginController();
	private ManagerLoginController managerLoginController = new ManagerLoginController();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//tell application we're using json for the content of our response
		response.setContentType("application.json");
		
		//override default response status to 404(pageNotFound) so we can handle exceptions how we want
		//...tomcat by default sends a 200 status code
		response.setStatus(404);
		
		//getting the request URI and stripping out the base path to be left with end-point
		String URI = request.getRequestURI().replace("/P1-najmendes/", "");
		
		//consider making a separate class for the switch statement and calling on that 
		//method in the doGet() method...
		switch(URI) {
		
		//employee requests
			case "employeelogin":
				employeeLoginController.loginEmployee(request, response);				
				break;
				
			case "employeeviewtickets":
				employeeLoginController.employeeviewtickets(request, response);			
				break;
										
//			case "employeesubmitticket":
//				employeeLoginController.submitNewTicket(request, response);			
//				break;
				
				
				
		//finance manager requests		
			case "managerlogin":{			
				managerLoginController.loginManager(request, response);	
				break;
			}
			
			case "managerviewalltickets":
				managerLoginController.viewAllTickets(response);			
				break;
//							
//			case "managerresolveticket":
//				employeeLoginController.viewAllTickets(request, response);			
//				break;

						
		}//switch	
	}//doGet()
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	//this send every POST request to the doGet method...why?
			//B/c I only want one switch statement in this servlet...it can get very messy otherwise
			//amd we'll differentiate get from post in the contollers instead of the servlet.
	doGet(request, response);
	
}

	
	
	
	
	

}//class
