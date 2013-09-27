package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("Hello ");
		response.getWriter().println("<br> Your session id is " +" " + request.getSession().getId());
		response.getWriter().println("<br> Session attribute is " + " "+ request.getParameter("param"));
	}
	}
