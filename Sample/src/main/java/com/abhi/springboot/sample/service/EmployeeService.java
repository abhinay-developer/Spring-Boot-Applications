package com.abhi.springboot.sample.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.abhi.springboot.sample.model.Employee;
import com.abhi.springboot.sample.repository.IEmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private IEmployeeRepository empRepository;
	
	
	//login Employee
	
	public Employee  loginEmployee(String email,String password) {
		
		return empRepository.findByEmailAndPassword(email,password);
	}
	
	

	// Save employee Details

	public Employee registerEmployee(Employee employee) {
		Date d=new Date();
		
		employee.setCreatedDate(d);
		return empRepository.save(employee);
	}

	// Get all Employee Details

	public List<Employee> getAllEmployees() {

		return empRepository.findAll();
	}

	// Get employee By Id

	public Optional<Employee> getEmployeeById(int id) {

		return empRepository.findById(id);
	}

//delete By Id
	public ResponseEntity<String> deleteEmployeeById(int id) {

		try {
			empRepository.deleteById(id);

			return new ResponseEntity<>("Deleted Sucessfully::" + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Id Not Found ::" + id, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
