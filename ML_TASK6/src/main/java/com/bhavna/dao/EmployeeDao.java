package com.bhavna.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bhavna.entity.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {
		
}
