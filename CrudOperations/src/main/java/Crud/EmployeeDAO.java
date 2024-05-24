package Crud;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
	List<Employee> getAllEmp() throws SQLException;

	void add(int id, String name, String job, int department, int salary) throws SQLException;

	void update(int id, String name, String job, int department, int salary) throws SQLException;

	void delete(int id) throws SQLException;
}
