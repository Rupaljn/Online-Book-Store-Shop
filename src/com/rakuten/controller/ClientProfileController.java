package com.rakuten.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rakuten.dto.Client;
import com.rakuten.model.ClientModel;

/**
 * Servlet implementation class ClientProfileontroller
 */
@WebServlet("/ClientProfileontroller")
public class ClientProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String name = request.getParameter("name");

ClientModel cm = new ClientModel();
Client client = cm.findClient(name);
if(client==null){
	String msg = "Name is wrong. Please enter your correct name";
	request.setAttribute("msg", msg);
	RequestDispatcher rd = request.getRequestDispatcher("ClientProfile.jsp");
	rd.forward(request, response);
	return;
}

request.setAttribute("client", client);
RequestDispatcher rd = request.getRequestDispatcher("ClientProfile.jsp");
rd.forward(request, response);

	
	
	
	}

}
