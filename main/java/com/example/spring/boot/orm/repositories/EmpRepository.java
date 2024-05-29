package com.example.spring.boot.orm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.boot.orm.model.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer> {

}
