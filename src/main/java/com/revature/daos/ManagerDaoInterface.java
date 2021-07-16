package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ManagerDaoInterface {

	
	//viewRequests
	public List<Reimbursement> selectOpenTickets();
	
	//viewRequests
	public List<Reimbursement> selectOpenTicketsById();
	
	//pastHistoryOfAllEmployees
	public List<Reimbursement> selectAllReimbursements();
	
	//pastHistoryOfAllEmployees
	public List<Reimbursement> selectAllReimbursementsById();
		
	//approve or denyRequest
	public void updateReimbursementStatus();


}
