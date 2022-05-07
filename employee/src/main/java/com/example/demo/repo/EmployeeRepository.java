package com.example.demo.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public class EmployeeRepository {
	
	private List<Employee> employeeList = null;
	public EmployeeRepository() {
		// TODO Auto-generated constructor stub
		employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee("I20000", "John Kepler", "Sr Software Engigneer", 200000));
		employeeList.add(new Employee("I20001", "Sasidhar", "Software Engigneer", 100000));
		employeeList.add(new Employee("I20002", "Wong Lee", "Network Engigneer", 150000));
	}
	
	public String create(Employee employee) {
		//insert data into DB
		//generate random number for employee id
		return "I"+this.getRandomNumber();
	}
	
	public Employee get(String employeeID) {
		//query database and get the employee record
		
		return this.searchList(employeeID);
		
	}
	public List<Employee> get() {
		//query database and get the employee record
		
		return this.employeeList;
		
	}
	
	public Employee update(String employeeID, Employee employee) {
		//update DB record
		Employee e = this.searchList(employeeID);
		return e;
	}
	
	public Employee delete(String employeeID) {
		//delete DB record
		Employee e = this.searchList(employeeID);
		if(e != null) {
			return e;
		}else {
			return null;
		}
	}
	
	private Employee searchList(String employeeID) {
		Employee emp = null;
		for(Employee e : employeeList) {
		   if(e.getEmployeeID().equals(employeeID)) {
			   
			   emp = e;
			   break;
		   }
		}
		
		return emp;
	}
	
	private int getRandomNumber() {
	    return (int) ((Math.random() * (10000 - 1000)) + 1000);
	}


}
