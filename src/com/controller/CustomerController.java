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

import com.bean.Customer;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mappings.CustomerDetail;
import com.mappings.SearchCustomer;
import com.service.CustomerService;


@WebServlet("/CustomerController/*")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo[] = request.getPathInfo().split("/");
		if(pathInfo == null || pathInfo.length < 1){
			System.out.println("Invalid Request");			
		}
		else if(pathInfo.length>=1 && pathInfo[1].equalsIgnoreCase("getAllCustomers")){
			CustomerService customerService = new CustomerService();
			
			try {
				ArrayList<CustomerDetail> custList = customerService.getAllCustomer();
				if(custList.size()>0){
					response.getWriter().write(new Gson().toJson(custList));
				}
				else
					response.getWriter().write(new Gson().toJson(-1));
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] pathInfo = request.getPathInfo().split("/");
		if(pathInfo == null || pathInfo.length < 1){
			System.out.println("Invalid Request");
			
		}
		else if(pathInfo.length>=1 && pathInfo[1].equalsIgnoreCase("createCustomer")){
			
			BufferedReader bufferReader = request.getReader();
			
			Customer customer = new Gson().fromJson(bufferReader, Customer.class);
			
			CustomerService customerService = new CustomerService();
			
			try {
				int custId = customerService.createCustomer(customer);
				if(custId>0){
					System.out.println("customer created successfully");
					response.getWriter().write(new Gson().toJson(custId));					
				}
				else{
					System.out.println("Creation failed");
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}	
		
		/*else if(pathInfo.length>=1 && pathInfo[1].equalsIgnoreCase("viewCustomer")){
			
			CustomerService customerService = new CustomerService();
			ArrayList<CustomerDetail> alist = new ArrayList<CustomerDetail>();
			
			try {
				
				alist=customerService.getAllCustomer();
				
				response.getWriter().write(new Gson().toJson(alist));
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}*/
		
		else if(pathInfo.length>=1 && pathInfo[1].equalsIgnoreCase("viewCustomer")){
			
			BufferedReader bufferReader = request.getReader();
//			System.out.println("result is"+bufferReader.readLine());
			
			SearchCustomer custObj = new Gson().fromJson(bufferReader, SearchCustomer.class);
//			System.out.println("result is"+custObj.getSsnId());
			System.out.println(custObj.getSsnId());

			CustomerService customerService = new CustomerService();
			ArrayList<CustomerDetail> custList = new ArrayList<CustomerDetail>();
			
			try {
					custList=customerService.searchCustomer(custObj);
					
					if(custList.size()>0)
					{
						response.getWriter().write(new Gson().toJson(custList));
					}
					else
					{
						response.getWriter().write(new Gson().toJson(null));
					}
					
				} catch (SQLException e) {
					response.getWriter().write(new Gson().toJson(null));
				}
		}
		
		else if(pathInfo.length>=1 && pathInfo[1].equalsIgnoreCase("deleteCustomer"))
		{
			BufferedReader bufferReader = request.getReader();

			
			String data = bufferReader.readLine();
//			
			
			int customerId = Integer.parseInt(data);
			
			System.out.println("iiid id"+customerId);
			
			
			CustomerService customerService = new CustomerService();
			
			try {
				int custId = customerService.deleteCustomer(customerId);
				
					System.out.println("customer deletion called="+custId);
					response.getWriter().write(new Gson().toJson(custId));					
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String[] pathInfo = req.getPathInfo().split("/");
		if(pathInfo == null || pathInfo.length < 1){
			System.out.println("Invalid Request");
			
		}
		else if(pathInfo.length>=1 && pathInfo[1].equalsIgnoreCase("updateCustomer"))
		{
			BufferedReader bufferReader = req.getReader();
			
			CustomerDetail customer = new Gson().fromJson(bufferReader, CustomerDetail.class);
			
			CustomerService customerService = new CustomerService();
			
			try {
				boolean custId = customerService.updateCustomer(customer);
				if(custId){
					System.out.println("customer updated successfully");
					resp.getWriter().write(new Gson().toJson(custId));					
				}
				else{
					System.out.println("updation failed");
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	/*@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
		String[] pathInfo = request.getPathInfo().split("/");
		if(pathInfo == null || pathInfo.length < 1){
			System.out.println("Invalid Request");
			
		}
		
		if(pathInfo.length>=1 && pathInfo[1].equalsIgnoreCase("deleteCustomer"))
		{
			BufferedReader bufferReader = request.getReader();

			
			String data = bufferReader.readLine();
//			
			
			int customerId = Integer.parseInt(data);
			
			System.out.println("iiid id"+customerId);
			
			
			CustomerService customerService = new CustomerService();
			
			try {
				int custId = customerService.deleteCustomer(customerId);
				
					System.out.println("customer deletion called="+custId);
					response.getWriter().write(new Gson().toJson(custId));					
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}*/
}
