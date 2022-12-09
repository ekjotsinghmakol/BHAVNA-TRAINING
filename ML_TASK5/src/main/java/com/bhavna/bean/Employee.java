package com.bhavna.bean;

public class Employee {
	private int employeeId;
    private String employeeName;
    private double employeeSalary;
    private String joiningDate;
    private int deptId;
    private String deptName;
    private String status;



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



   public double getEmployeeSalary() {
        return employeeSalary;
    }



   public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }



   public String getJoiningDate() {
        return joiningDate;
    }



   public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }



   public int getDeptId() {
        return deptId;
    }



   public void setDeptId(int deptId) {
        this.deptId = deptId;
    }



   public String getDeptName() {
        return deptName;
    }



   public void setDeptName(String deptName) {
        this.deptName = deptName;
    }



   public String getStatus() {
        return status;
    }



   public void setStatus(String status) {
        this.status = status;
    }



   @Override
    public String toString() {
        return "EmployeeRecord [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeSalary="
                + employeeSalary + ", joiningDate=" + joiningDate + ", deptId=" + deptId + ", deptName=" + deptName
                + ", status=" + status + "]";
    }
}
