package com.abhi.springboot.sample.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "employee_details")
public class Employee {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int empId;

	private String name;

	private String password;

	private long mobileNo;

	private String email;

	private int salary;

	private String companyName;

	private String companyLocation;

	private String address;

	private Date createdDate;

	private Date updatedDate;
}
