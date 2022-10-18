package com.rakuten.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rakuten.dto.Book;
import com.rakuten.model.BookModel;

/**
 * Servlet implementation class ViewBookController
 */
@WebServlet("/ViewBookController")
public class ViewBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBookController() {
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

	String nameOfBook = request.getParameter("bookName");
	
	BookModel bm = new BookModel();
	Book book = bm.findByName(nameOfBook);
	if(book==null){
		String msg = "Book does not exit";
		request.setAttribute("msg", msg);
		RequestDispatcher rd = request.getRequestDispatcher("AddBookView.jsp");
		rd.forward(request, response);
		return;
		
		
	}
	request.setAttribute("book", book);
	RequestDispatcher rd = request.getRequestDispatcher("ViewBook.jsp");
	rd.forward(request, response);
}

}
