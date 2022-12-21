package com.bhavna.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.bhavna.entity.Employee;
import com.bhavna.service.EmployeeService;
import com.employee.interfaces.AddEmployeeRequest;
import com.employee.interfaces.AddEmployeeResponse;
import com.employee.interfaces.DeleteEmployeeRequest;
import com.employee.interfaces.DeleteEmployeeResponse;
import com.employee.interfaces.EmployeeInfo;
import com.employee.interfaces.GetEmployeeByIdRequest;
import com.employee.interfaces.GetEmployeeIdResponse;
import com.employee.interfaces.GetEmployeeResponse;
import com.employee.interfaces.ServiceStatus;
import com.employee.interfaces.UpdateEmployeeRequest;
import com.employee.interfaces.UpdateEmployeeResponse;

@Endpoint
public class EmployeeController {
	
	
		private static final String NAMESPACE_URI = "http://interfaces.employee.com";

		@Autowired
		private EmployeeService employeeService;

		@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeRequest")
		@ResponsePayload
		public GetEmployeeResponse getEmployee() {
			GetEmployeeResponse response = new GetEmployeeResponse();
			List<EmployeeInfo> employeeInfoList = new ArrayList<>();
			List<Employee> employee = employeeService.getEmployee();
			for (int i = 0; i < employeeInfoList.size(); i++) {
				EmployeeInfo employeeInfo = new EmployeeInfo();
				BeanUtils.copyProperties(employee.get(i), employeeInfo);
				employeeInfoList.add(employeeInfo);
			}
			response.getEmployeeInfo().addAll(employeeInfoList);
			return response;
		}	
		

		@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addEmployeeRequest")
		@ResponsePayload
		public AddEmployeeResponse addEmployee(@RequestPayload AddEmployeeRequest request) {
			AddEmployeeResponse response = new AddEmployeeResponse();
			ServiceStatus serviceStatus = new ServiceStatus();

			Employee employee = new Employee();
			BeanUtils.copyProperties(request.getEmployeeInfo(), employee);
			employeeService.addEmployee(employee);
			serviceStatus.setStatus("SUCCESS");
			serviceStatus.setMessage("Content Added Successfully");
			response.setServiceStatus(serviceStatus);
			return response;
		}

		@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeByIdRequest")
		@ResponsePayload
		public GetEmployeeIdResponse getEmployee(@RequestPayload GetEmployeeByIdRequest request) {
			GetEmployeeIdResponse response = new GetEmployeeIdResponse();
			EmployeeInfo employeeInfo = new EmployeeInfo();
			BeanUtils.copyProperties(employeeService.getEmployeeById(request.getId()), employeeInfo);
			response.setEmployeeInfo(employeeInfo);
			return response;
		}

		@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateEmployeeRequest")
		@ResponsePayload
		public UpdateEmployeeResponse updateEmployee(@RequestPayload UpdateEmployeeRequest request) {
			Employee employee = new Employee();
			BeanUtils.copyProperties(request.getEmployeeInfo(), employee);
			employeeService.updateEmployee(employee);
			ServiceStatus serviceStatus = new ServiceStatus();
			serviceStatus.setStatus("SUCCESS");
			serviceStatus.setMessage("Content Updated Successfully");
			UpdateEmployeeResponse response = new UpdateEmployeeResponse();
			response.setServiceStatus(serviceStatus);
			return response;
		}

		@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteEmployeeRequest")
		@ResponsePayload
		public DeleteEmployeeResponse deleteEmployee(@RequestPayload DeleteEmployeeRequest request) {
			employeeService.deleteEmployee(request.getId());
			ServiceStatus serviceStatus = new ServiceStatus();

			serviceStatus.setStatus("SUCCESS");
			serviceStatus.setMessage("Content Deleted Successfully");
			DeleteEmployeeResponse response = new DeleteEmployeeResponse();
			response.setServiceStatus(serviceStatus);
			return response;
		}
	}

