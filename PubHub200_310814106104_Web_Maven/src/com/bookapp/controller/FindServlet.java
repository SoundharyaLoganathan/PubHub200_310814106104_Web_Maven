package com.bookapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookapp.dao.BookDAO;
import com.bookapp.model.Book;

/**
 * Servlet implementation class FindServlet
 */
@WebServlet("/FindServlet")
public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		Book book = new Book();
		book.setBookName(name);
		System.out.println(name);
		BookDAO dao = new BookDAO();
		List<Book> books = dao.findByName(book);
		System.out.println(books.size());
		if (books.size() > 0) {
			RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
			request.setAttribute("books", books);
			rd.forward(request, response);
		} else {
			response.sendRedirect("failure.jsp");
		}

		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
