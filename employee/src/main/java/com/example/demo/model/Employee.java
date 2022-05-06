package com.example.demo.model;

public class Employee {
	
	private String employeeID;
	private String name;
	private String role;
	private int salary;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String employeeID,String name,String role,int salary) {
		// TODO Auto-generated constructor stub
		this.employeeID = employeeID;
		this.name = name;
		this.role = role;
		this.salary = salary;
	}
	
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", name=" + name + ", role=" + role + ", salary=" + salary + "]";
	}
	
	
	
	

}
