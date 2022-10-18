package com.rakuten.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rakuten.model.BookModel;

/**
 * Servlet implementation class DeleteBookController
 */
@WebServlet("/DeleteBookController")
public class DeleteBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBookController() {
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
String nameOfBook = request.getParameter("nameOfBook");
BookModel bm = new BookModel();
boolean flag = bm.deletBook(nameOfBook);
System.out.println("name of book = " + nameOfBook);
if(flag==true){
	String msg = "Book is deleted";
	request.setAttribute("msg", msg);
	RequestDispatcher rd = request.getRequestDispatcher("DeleteBookView.jsp");
	rd.forward(request, response);
	return;
}
else{
	request.setAttribute("book", nameOfBook);
	RequestDispatcher rd = request.getRequestDispatcher("DeleteBookView.jsp");
	rd.forward(request, response);
	
}

	}

}
