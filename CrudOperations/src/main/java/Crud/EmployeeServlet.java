package Crud;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public EmployeeDAL db;

	public void init() throws ServletException {
		super.init();
		db = new EmployeeDAL();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Employee> list = db.getAllEmp();
		request.setAttribute("ed", list);
		request.getRequestDispatcher("Employees.jsp").forward(request, response);

	}

}
