package com.bhavna.main;

import com.bhavna.bean.Employee;
import com.bhavna.dao.Operations;


public class Main {

	public static void main(String[] args) {
		Operations operation = new Operations();
		
		operation.getData();
		operation.updateData();
		operation.countEmployeeData();
		
		Employee employee1 = new Employee(105, "Radhe", 86000.0, "2019-01-01");
		operation.saveEmployee(employee1);
		

	}

}
