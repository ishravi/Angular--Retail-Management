package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mappings.LogIn;
import com.service.LoginService;

@WebServlet("/LoginController/*")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gson gson = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		

		String pathInfo[] = request.getPathInfo().split("/");

		for (String s : pathInfo) {
			System.out.println(s);
		}
		if (pathInfo == null || pathInfo.length < 1) {
			// error
		} else if (pathInfo.length > 1 && pathInfo[1].equalsIgnoreCase("login")) {
			int status = -2;
			String loginPath = pathInfo[1];

			System.out.println("loginPath is" + loginPath);

			BufferedReader br = request.getReader();

			LogIn login=new Gson().fromJson(br, LogIn.class);
			
			System.out.println("jhdgjhwsg"+login.getUsername() + "   "+login.getPassword());

			LoginService loginService = new LoginService();
	
				 try {
					status= loginService.validateUser(login);
					if(status==1)
					{
						System.out.println("login success");
						response.getWriter().write(new Gson().toJson("1"));
					}
					else if(status==0)
					{
						System.out.println(status);						
						response.getWriter().write(new Gson().toJson("0"));
					}
					else if(status==-1)
					{
						response.getWriter().write(new Gson().toJson("-1"));
					}
				} catch (SQLException e) {					
					e.printStackTrace();
				}				
		    }
		}	
     }
