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
 * Servlet implementation class BookRecordUpdateController
 */
@WebServlet("/BookRecordUpdateController")
public class BookRecordUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookRecordUpdateController() {
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
	
	Book bk = new Book();
	bk.setNameOfBook(nameOfBook);
	bk.setBookPdfUplode(bookPdfUplode);
	bk.setBookImage(bookImage);
	double bp = Double.parseDouble(bookPrice);
	bk.setBookPrice(bp);
	bk.setBookAuthor(bookAuthor);
	
	BookModel bm = new BookModel();
	boolean flag = bm.UpdateBook(bk);
	
	if(flag==true){
		String msg = "Book updated successfully";
		request.setAttribute("msg", msg);
		RequestDispatcher rd  = request.getRequestDispatcher("BookRecordUpdateView.jsp");
		rd.forward(request, response);
		return;
	}
	else{
		String errorMsg = "Book is not update";
		request.setAttribute("errorMsg", errorMsg);
		RequestDispatcher rd = request.getRequestDispatcher("UpdateBookDetailView.jsp");
		rd.forward(request, response);
	}
	
	
	}

}
