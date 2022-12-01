package com.bhavna.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.bhavna.bean.Employee;

public class EmployeeOperation {

	Employee employee1 = new Employee("Ekjot", 30000, "Noida");
	Employee employee2 = new Employee("Arpit", 29000, "Noida");
	Employee employee3 = new Employee("Saumya", 30000, "Noida");
	Employee employee4 = new Employee("Anish", 980000, "Hyderabad");
	Employee employee5 = new Employee("Raj", 980000, "Noida");

	List<Employee> list = new ArrayList<Employee>();

	public void employeeOps() {

		list.add(employee1);
		list.add(employee2);
		list.add(employee3);
		list.add(employee4);
		list.add(employee5);

		Long search = list.stream().filter(item1 -> item1.getName().startsWith("S")).count();
		System.out.println("No of employees having names starting with S are \n"+search);

		List<Employee> filter = list.parallelStream().filter(location -> location.getLocation().equals("Hyderabad"))
				.collect(Collectors.toList());
		System.out.println("Employees in Hyderabad \n" + filter);

		Map<String, List<Employee>> map = list.stream().collect(Collectors.groupingBy(Employee::getLocation));

		List salary = list.stream().filter(sal -> sal.getSalary() > 100000).collect(Collectors.toList());
		System.out.println("Salary Of Employee Having Salary Greater than 100000: \n" + salary);

		List<Employee> maps = list.stream().sorted(
				Comparator.comparing(Employee::getName).thenComparing(Comparator.comparing(Employee::getLocation)))
				.collect(Collectors.toList());
		System.out.println("Sorted According to names and after location: " + maps);

	}
}
