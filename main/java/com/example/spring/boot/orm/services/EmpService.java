package com.example.spring.boot.orm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.boot.orm.model.Employee;
import com.example.spring.boot.orm.repositories.EmpRepository;

@Service
public class EmpService {
	@Autowired

	private EmpRepository empRepository;

	public List<Employee> findAll() {

		System.out.println("about to invoke repository method");

		return empRepository.findAll();

	}
}
