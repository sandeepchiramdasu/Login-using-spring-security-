package com.security.springsec.controller;

import java.util.ArrayList;
import java.util.*;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.springsec.model.Employee;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class Controller {
	private List<Employee> employees = new ArrayList<>(List.of(
			new Employee(1,"sandeep",22),
			new Employee(2,"kumar",23)));
	
	@GetMapping("/")
	public List<Employee> getEmployees(){
		return employees;
	}
	
	@PostMapping("/emp")
	public  Employee addEmployee(@RequestBody Employee employee) {
		employees.add(employee);
		return employee;
	}
	@GetMapping("/csrf_token")
	public CsrfToken getCsrfToken(HttpServletRequest request) {
		return (CsrfToken)request.getAttribute("_csrf");
	}
}
