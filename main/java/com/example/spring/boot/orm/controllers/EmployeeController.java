package com.example.spring.boot.orm.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.spring.boot.orm.model.Employee;
import com.example.spring.boot.orm.services.EmpService;

@Controller
public class EmployeeController {

	EmpService empService;

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired

	public EmployeeController(EmpService es) {

		this.empService = es;

	}

	@GetMapping(value = "/emplist")

	public String getAllEmployees(Model model) {

		logger.info("Handling /emplist request");

		// get all employees from service

		logger.info("about to invoke service method");

		System.out.println("about to invoke service method");

		List<Employee> empList = empService.findAll();

		logger.info("Got emplist from service");

		System.out.println("got emplist from service");

		System.out.println(empList.toString());

		model.addAttribute("elist", empList);

		logger.info("about to call logical view");

		System.out.println("about to call logical view");

		return "emplist";

	}

}
