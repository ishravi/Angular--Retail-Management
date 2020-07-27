package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Account;
import com.bean.AccountStatus;
import com.mappings.Accountdet;
import com.bean.Customer;
import com.exception.AccountCountExceeded;
import com.exception.CurrentAccountCountExceeded;
import com.exception.CustomerIDNotFoundException;
import com.exception.SavingsAccountCountExceeded;
import com.google.gson.Gson;
import com.mappings.AccountViewBean;
import com.service.AccountService;
import com.service.CustomerService;


@WebServlet("/AccountController/*")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] pathInfo = request.getPathInfo().split("/");
		if(pathInfo == null || pathInfo.length < 1){
			System.out.println("Invalid Request");
			
		}
		
		
		else if(pathInfo.length>=1 && pathInfo[1].equalsIgnoreCase("getAllAccount")){
			
			
			System.out.println("eeeeeeee");
			AccountService accountService = new AccountService();
			ArrayList<Account> accList = new ArrayList<Account>();
			accList = accountService.viewAllAccountStatus();
			System.out.println("zzzzz"+accList.get(0).getCusid());
			response.getWriter().write(new Gson().toJson(accList));
			
			
		}
		

		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] pathInfo = request.getPathInfo().split("/");
		if(pathInfo == null || pathInfo.length < 1){
			System.out.println("Invalid Request");
			
		}
		
else if(pathInfo.length>=1 && pathInfo[1].equalsIgnoreCase("createAccount")){
			
			BufferedReader bufferReader = request.getReader();
			
			Accountdet account = new Gson().fromJson(bufferReader, Accountdet.class);

			System.out.println("in controller id "+account.getCustomerId()+" "+account.getAccountType()+" "+account.getAccountBalance());
			
			AccountService accountService = new AccountService();
			
			try {
				long id=0;
				try {
					id = accountService.createAccount(account);
					
					System.out.println("back id is "+id);
				} catch (CustomerIDNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				response.getWriter().write(new Gson().toJson(id));
				if(id>0){
					System.out.println("customer created successfully");
										
				}
				else{
					System.out.println("Creation failed");
				}
			} catch (SQLException e) {
				
				
			} catch (SavingsAccountCountExceeded e) {
			
			} catch (CurrentAccountCountExceeded e) {
		
			} catch (AccountCountExceeded e) {
				
			}
			
		}
		

else if(pathInfo.length>=1 && pathInfo[1].equalsIgnoreCase("viewAccountByCustomerId")){
	System.out.println("cus id in controller");
	BufferedReader bufferReader = request.getReader();
	
	String cusid=bufferReader.readLine().substring(16, 21);
	int id = Integer.parseInt(cusid);
	System.out.println("cus id in controller"+id);
	long accid = 0;
	
	
	AccountService accountService = new AccountService();
	ArrayList<Account> accList = new ArrayList<Account>();
	accList = accountService.viewAllAccountForCustomer(id, accid) ;
	if(accList.size()==0){
		response.getWriter().write(new Gson().toJson(-1));
	}
	else{
	response.getWriter().write(new Gson().toJson(accList));
	}
	
	
//	BufferedReader bufferReader1 = request.getReader();
//
//	AccountViewBean acc = new Gson().fromJson(bufferReader1, AccountViewBean.class);
//	System.out.println("in controller acc id "+acc.getAccountid()+"cus id "+acc.getCusid()+" ");
//	
//	AccountService accountService = new AccountService();
//	ArrayList<Account> accList = new ArrayList<Account>();
//
//
//	accList = accountService.viewAllAccountForCustomer(acc.getCusid(), acc.getAccountid()) ;
//	response.getWriter().write(new Gson().toJson(accList));

	
	
	
}
		
else if(pathInfo.length>=1 && pathInfo[1].equalsIgnoreCase("deleteAccountByAccountId")){
	BufferedReader bufferReader = request.getReader();
//	System.out.println("inside delete"+bufferReader.readLine());

	String accid=bufferReader.readLine();
	long id = Long.parseLong(accid);
	System.out.println("cus id in controller"+accid);
	AccountService accountService = new AccountService();

	long returnid = accountService.deleteAccount(id);
	response.getWriter().write(new Gson().toJson(returnid));

	
}
		
	}
	
//	@Override
//	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		String[] pathInfo = req.getPathInfo().split("/");
//		if(pathInfo == null || pathInfo.length < 1){
//			System.out.println("Invalid Request");
//			
//		}
//		
//		else if(pathInfo.length>=1 && pathInfo[1].equalsIgnoreCase("deleteAccountByAccountId")){
//			System.out.println("inside delete");
//		BufferedReader bufferReader = req.getReader();
//		System.out.println("inside delete"+bufferReader.readLine());
////		String accid=bufferReader.readLine().substring(16, 22);
////		long id = Integer.parseInt(accid);
////		System.out.println("acc id in controller"+accid);
////		AccountService accountService = new AccountService();
////	
////		long returnid = accountService.deleteAccount(id);
////		resp.getWriter().write(new Gson().toJson(returnid));
//	
//		
//	}
//		
//	}

}
