package Crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAL {
	Connection con;

	public EmployeeDAL() {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training",
					"plf_training_admin", "pff123");
			System.out.println("Database connection established successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error establishing database connection: " + e.getMessage());
		}
	}

	public List<Employee> getAllEmp() {
		List<Employee> list = new ArrayList<>();
		try {
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st.executeQuery("select * from employees195");
			while (rs.next()) {
				Employee e = new Employee();
				e.setEmpid(rs.getInt("empid"));
				e.setDept(rs.getInt("deptid"));
				e.setEmp_name(rs.getString("emp_name"));
				e.setJob(rs.getString("job"));
				e.setSalary(rs.getInt("salary"));
				list.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public void add(int id, String name, String job, int department, int salary) throws SQLException {
		PreparedStatement pt = con
				.prepareStatement("insert into employees195 (empid,emp_name,job,deptid,salary) values(?,?,?,?,?)");
		pt.setInt(1, id);
		pt.setString(2, name);
		pt.setString(3, job);
		pt.setInt(4, department);
		pt.setInt(5, salary);
		pt.execute();

	}

	public void update(int id, String name, String job, int department, int salary) throws SQLException {
		PreparedStatement pt = con
				.prepareStatement("update employees195 set emp_name =?, job =?,deptid=?,salary=? where empid=?");
		pt.setInt(5, id);
		pt.setString(1, name);
		pt.setString(2, job);
		pt.setInt(3, department);
		pt.setInt(4, salary);
		pt.execute();
	}

	public void delete(int id) throws SQLException {
		PreparedStatement pt = con.prepareStatement("delete from employees195 where empid=?");
		pt.setInt(1, id);
		pt.execute();
	}

}