package com.rakuten.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rakuten.dto.Client;
import com.rakuten.exceptions.DataInvaildException;
import com.rakuten.model.ClientModel;

/**
 * Servlet implementation class ClientLoginController
 */
@WebServlet("/ClientLoginController")
public class ClientLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(request, HttpServletResponse response) throws ServletException, IOException {
	
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");

		Client clnt = new Client();
		try{
			clnt.setEmailId(emailId);
			clnt.setPassword(password);
			}
		catch(DataInvaildException d){
			d.printStackTrace();
			String errorMsg = d.getMessage();
			request.setAttribute("errorMsg", errorMsg);
			RequestDispatcher rd = request.getRequestDispatcher("HomeView.jsp");
			
			rd.forward(request, response);
			return;
		}

		ClientModel cm = new ClientModel();
		boolean flag = cm.loginClient(clnt);

		if(flag==true){
			String successMsg = "Client login is successfull";
			request.setAttribute("successMsg", successMsg);
			RequestDispatcher rd = request.getRequestDispatcher("HomeView.jsp");
			rd.forward(request, response);
		}
		else{
			String errorMsg = "Client login is not successfull";
			request.setAttribute("errorMsg", errorMsg);
			RequestDispatcher rd = request.getRequestDispatcher("HomeView.jsp");
			rd.forward(request, response);
		}
			
	

