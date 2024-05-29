package com.example.spring.boot.orm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee1223")
public class Employee {
	@Id
	@Column(name = "emp_id")
	private Integer empNo;

	@Column(name = "emp_name")
	private String empName;

	@Column(name = "designation")
	private String job;

	@Column(name = "dept_id")
	private Integer deptNo;

	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}

	public Employee(Integer empNo, String empName, String job, Integer deptNo) {
		this.empNo = empNo;
		this.empName = empName;
		this.job = job;
		this.deptNo = deptNo;
	}

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", job=" + job + ", deptNo=" + deptNo + "]";
	}

}
