package Crud;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CrudServlet")
public class CrudServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmployeeDAL db;

	public CrudServlet() {
		super();
		db = new EmployeeDAL();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String val = request.getParameter("action");
		if (val != null) {
			try {
				switch (val) {
				case "add":
					addEmployee(request, response);
					break;
				case "update":
					updateEmployee(request, response);
					break;
				case "delete":
					deleteEmployee(request, response);
					break;
				case "next":
					nextEmployee(request, response);
					break;
				case "previous":
					previousEmployee(request, response);
					break;
				case "first":
					first(request, response);
					break;
				case "last":
					last(request, response);
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void nextEmployee(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.getRequestDispatcher("Employees.jsp").forward(request, response);
	}

	private void previousEmployee(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.getRequestDispatcher("Employees.jsp").forward(request, response);
	}

	private void first(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("Employees.jsp").forward(request, response);
	}

	private void last(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("Employees.jsp").forward(request, response);
	}

	private void addEmployee(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException {
		String name = request.getParameter("Empname");
		String empIdString = request.getParameter("Empid");
		int id = 0; // Default value or handle error if necessary
		if (!empIdString.isEmpty()) {
			id = Integer.parseInt(empIdString);
		}

		String job = request.getParameter("job");
		int department = Integer.parseInt(request.getParameter("Department"));
		int salary = Integer.parseInt(request.getParameter("Sal"));
		db.add(id, name, job, department, salary);
		response.sendRedirect("EmployeeServlet");
	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException {
		int id = Integer.parseInt(request.getParameter("Empid"));
		String name = request.getParameter("Empname");
		String job = request.getParameter("job");
		int department = Integer.parseInt(request.getParameter("Department"));
		int salary = Integer.parseInt(request.getParameter("Sal"));
		db.update(id, name, job, department, salary);
		response.sendRedirect("EmployeeServlet");
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException {
		int id = Integer.parseInt(request.getParameter("Empid"));
		db.delete(id);
		response.sendRedirect("EmployeeServlet");
	}
}
