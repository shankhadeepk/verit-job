package com.jda.beans;

import org.bson.types.ObjectId;

public class Employee {
	
	private ObjectId id;	
	private int empId;
	private String empName;
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", empId=" + empId + ", empName=" + empName + "]";
	}
	
	
	

}
