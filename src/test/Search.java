package test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.Dao;

public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("do");
		Dao dao = new Dao();
		if ("delete".equals(action)) {
			try {
				dao.deleteRow(request.getParameter("id"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		List<Object> objects = new ArrayList<Object>();

		String search = request.getParameter("searchString");
		if (search != null) {
			try {
				objects = dao
						.search(request.getParameter("searchString"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {

			try {
				objects = dao.findAllObjects();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("objects", objects);

		request.getRequestDispatcher("WEB-INF/jsp/Search.jsp").forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			}

}