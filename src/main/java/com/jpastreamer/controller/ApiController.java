package com.jpastreamer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpastreamer.entity.Employee;
import com.jpastreamer.service.JPAStreamerService;

@RestController
public class ApiController {
	
	@Autowired
	private JPAStreamerService jpaStreamerService;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return jpaStreamerService.getEmployeedata();
	}

}
