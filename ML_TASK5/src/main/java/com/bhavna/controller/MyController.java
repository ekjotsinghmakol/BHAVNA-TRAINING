package com.bhavna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bhavna.bean.Employee;
import com.bhavna.dao.EmployeeDao;

@Controller
public class MyController {

	@Autowired
	EmployeeDao employeeDao;

	@RequestMapping("/")
	public String home() {
		return "index";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute Employee employee) {
		employeeDao.save(employee);
		return "redirect:/viewemp";
	}

	@RequestMapping("/viewemp")
	public String viewEmp(Model model) {
		List<Employee> list = employeeDao.getEmployee();
		System.out.println(list);
		model.addAttribute("list", list);
		return "viewemp";
	}

	@RequestMapping(value = "/editemp/{id}")
	public String edit(@PathVariable int id, Model m) {
		Employee emp = employeeDao.getEmpById(id);
		System.out.println(emp);
		m.addAttribute("list", emp);
		return "viewemp";
	}

}
