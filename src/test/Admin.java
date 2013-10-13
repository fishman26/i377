package test;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex3.SetupDao;

public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("do");
		if("insert_data".equals(action)){
			try {
				new SetupDao().createSchema("example_data.sql");
			} catch (Exception e) {
				e.printStackTrace();
			}

			response.setHeader("Location", "Search");
			response.setStatus(HttpServletResponse.SC_FOUND);
		} else if("clear_data".equals(action)){
			try {
				new Dao().clearData();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			response.setHeader("Location", "Search");
			response.setStatus(HttpServletResponse.SC_FOUND);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			}
}