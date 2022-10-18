package com.rakuten.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rakuten.dto.Admin;
import com.rakuten.exceptions.DataInvaildException;
import com.rakuten.model.AdminModel;

/**
 * Servlet implementation class AdminLoginController
 */
@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String emailId = request.getParameter("emailId");
	String password = request.getParameter("password");
	
	Admin ad = new Admin();
	
	try{
	ad.setEmailId(emailId);
	ad.setPassword(password);
	}
	
	catch(DataInvaildException d){
		d.printStackTrace();
		String errorMsg = d.getMessage();
		request.setAttribute("errorMsg", errorMsg);
		RequestDispatcher rd = request.getRequestDispatcher("HomeView.jsp");
		rd.forward(request, response);
		return;
	}
	AdminModel am = new AdminModel();
	boolean flag = am.loginAdmin(ad);
	
	if(flag==true){
		
		String successMsg = "Admin login is successfull";
		request.setAttribute("successMsg", successMsg);
		RequestDispatcher rd = request.getRequestDispatcher("HomeView.jsp");
		rd.forward(request, response);
	}
	else{
		String errorMsg = "Admin login is not successfull. User Id and password is wrong";
		request.setAttribute("errorMsg", errorMsg);
		RequestDispatcher rd = request.getRequestDispatcher("HomeView.jsp");
		rd.forward(request, response);
	}
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
