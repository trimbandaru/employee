package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepository;

@Controller
@RequestMapping("v1/employee")
public class EmployeeController {

  @Autowired
  EmployeeRepository employeeRepository;// = new EmployeeRepository();
  
  @RequestMapping(method = RequestMethod.GET, value="/getall")
  @ResponseBody
  public ResponseEntity<List<Employee>> getAllEmployees() {
	  //ResponseEntity.status(HttpStatus.OK);
	  return ResponseEntity.status(HttpStatus.ACCEPTED).body(employeeRepository.get());
	  //return employeeRepository.get();
	  
  }
  
  @RequestMapping(method = RequestMethod.GET, value="/{id}", produces = "application/json")
  @ResponseBody
  public  ResponseEntity<Employee> getEmployee(@PathVariable String id) {
	  Employee emp = employeeRepository.get(id);
	  if(emp == null) {
		  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	  }else {
		  return ResponseEntity.status(HttpStatus.OK).body(emp);
	  }
      
  }
  
  @RequestMapping(method = RequestMethod.POST, value="/", produces = "application/text")
  @ResponseBody
  public  ResponseEntity<String> createEmployee(Employee employee) {
	  String empID = employeeRepository.create(employee);
	  if(empID == null) {
		  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	  }else {
		  return ResponseEntity.status(HttpStatus.CREATED).body(empID);
	  }
  }
  
  @RequestMapping(method = RequestMethod.PUT, value="/{id}", produces = "application/json")
  @ResponseBody
  public  ResponseEntity<Employee> updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
	  Employee emp = employeeRepository.update(id, employee);
	  if(emp == null) {
		  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	  }else {
		  return ResponseEntity.status(HttpStatus.OK).body(employee);
	  }
  }
  
  @RequestMapping(method = RequestMethod.DELETE, value="/{id}", produces = "application/json")
  @ResponseBody
  public  ResponseEntity deleteEmployee(@PathVariable String id) {
	  Employee emp = employeeRepository.delete(id);
	  if(emp == null) {
		  return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	  }else {
		  return ResponseEntity.status(HttpStatus.OK).build();
	  }
      
  }
}
