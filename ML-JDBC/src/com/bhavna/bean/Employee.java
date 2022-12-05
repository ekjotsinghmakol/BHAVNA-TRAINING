package com.bhavna.bean;

public class Employee {
	private int employeeId;
    private String employeeName;
    private double salary;
    private String joiningDate;
    
	public Employee(int employeeId, String employeeName, double salary, String joiningDate) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.salary = salary;
		this.joiningDate = joiningDate;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	@Override
	public String toString() {
		return " [employeeId=" + employeeId + ", employeeName=" + employeeName + ", salary=" + salary
				+ ", joiningDate=" + joiningDate + "]";
	}
    
    
}
