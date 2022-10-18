package com.rakuten.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rakuten.dto.Book;
import com.rakuten.exceptions.DataInvaildException;
import com.rakuten.model.BookModel;

/**
 * Servlet implementation class AddBookController
 */
@WebServlet("/AddBookController")
public class AddBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookController() {
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
String bookPdfUplode = request.getParameter("bookPdfUplode");
String bookImage = request.getParameter("bookImage");
String bookPrice = request.getParameter("bookPrice");
String bookAuthor = request.getParameter("bookAuthor");

Book ab = new Book();

try{
	ab.setNameOfBook(nameOfBook);
	ab.setBookPdfUplode(bookPdfUplode);
	ab.setBookImage(bookImage);
	double bp = Double.parseDouble(bookPrice);
	ab.setBookPrice(bp);
	ab.setBookAuthor(bookAuthor);
	}
catch(DataInvaildException d){
	d.printStackTrace();
	String errorMsg = d.getMessage();
	request.setAttribute("errorMsg", errorMsg);
	RequestDispatcher rd = request.getRequestDispatcher("AddBookView.jsp");
	rd.forward(request, response);
	return;
}
BookModel abm = new BookModel();
boolean flag = abm.addBook(ab);
 if(flag==true){
	 String successMsg = "Book added successfully";
	 request.setAttribute("successMsg", successMsg);
	 RequestDispatcher rd = request.getRequestDispatcher("AddBookView.jsp");
	 rd.forward(request, response);
 }
 else{
	 String errorMsg = "Book is not added successfully";
	 request.setAttribute("errorMsg", errorMsg);
	 RequestDispatcher rd = request.getRequestDispatcher("AddBookView.jsp");
	 rd.forward(request, response);
 }

	}

}
