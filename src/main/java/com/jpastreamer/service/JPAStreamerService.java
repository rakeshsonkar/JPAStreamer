package com.jpastreamer.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.jpastreamer.entity.Employee$;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpastreamer.entity.Employee;
import com.speedment.jpastreamer.application.JPAStreamer;

@Service
public class JPAStreamerService {

	@Autowired
	private JPAStreamer jpaStreamer;

	public List<Employee> saveEmployees(List<Employee> employees) {
		return null;
	}

	public List<Employee> getEmployees() {
		return jpaStreamer.stream(Employee.class).collect(Collectors.toList());
	}

	public List<Employee> getEmployeedata() {

		return  jpaStreamer.stream(Employee.class).sorted(Employee$.name).limit(5).collect(Collectors.toList());

	}
	public List<Employee> getEmployeePagenation(int offset,int limit) {

		return  jpaStreamer
				.stream(Employee.class)
				.sorted(Employee$.name)
				.skip(offset)
				.limit(limit)
				.collect(Collectors.toList());

	}

	public List<Employee> getEmployeeDept(Integer dept) {

		return  jpaStreamer
				.stream(Employee.class)
				.filter(Employee$.dept.equal(dept))
				.collect(Collectors.toList());

	}
	public List<Employee> getEmployeeDeptAndSalary(Integer dept,double sal) {

		return  jpaStreamer
				.stream(Employee.class)
				.filter(Employee$.dept.equal(dept).and(Employee$.salary.greaterOrEqual(sal)))
				.collect(Collectors.toList());
	}
	// using between
	public List<Employee> getEmployeeBySalaryRange(double sal1,double sal2) {
		return  jpaStreamer
				.stream(Employee.class)
				.filter(Employee$.salary.between(sal1,sal2))
				.collect(Collectors.toList());
	}

	//aggregate function
	public Employee lessPaidEmp(){
		return  jpaStreamer.stream(Employee.class)
				.min(Comparator.comparing(Employee::getSalary)).get();
	}

	public List<Employee> getEmployeeByIds(List<Integer> ids){
		return  jpaStreamer.stream(Employee.class)
				.filter(Employee$.id.in(ids))
				.collect(Collectors.toList());
	}
	// fatch  is  groupBy

	public Map<Integer,List<Employee>> getEmployeeGroupByDept(){
		return jpaStreamer.stream(Employee.class)
				.collect(Collectors.groupingBy(Employee::getDept));
	}

}
