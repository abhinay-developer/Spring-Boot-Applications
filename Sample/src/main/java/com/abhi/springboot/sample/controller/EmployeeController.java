package com.abhi.springboot.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.springboot.sample.model.Employee;
import com.abhi.springboot.sample.service.EmployeeService;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	// login employee Details
	// Get All Employee Details
	@GetMapping("/{email}/{password}")
	public ResponseEntity<?> loginEmployeesDetails(@PathVariable String email, @PathVariable String password) {

		try {
			Employee theEmployee = empService.loginEmployee(email, password);

			return new ResponseEntity<>(theEmployee, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Save Employee Details
	@PostMapping("/save")
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {

		try {
			Employee theEmployee = empService.registerEmployee(employee);

			return new ResponseEntity<>(theEmployee, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Get All Employee Details
	@GetMapping("/all")
	public ResponseEntity<?> getAllEmployeesDetails() {

		try {
			List<Employee> theEmployee = empService.getAllEmployees();

			return new ResponseEntity<>(theEmployee, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Get Employee By Id
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmpById(@PathVariable int id) {

		try {

			return new ResponseEntity<>(empService.getEmployeeById(id), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Get Employee By Id
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmpById(@PathVariable int id) {

		try {

			return new ResponseEntity<>(empService.deleteEmployeeById(id), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
