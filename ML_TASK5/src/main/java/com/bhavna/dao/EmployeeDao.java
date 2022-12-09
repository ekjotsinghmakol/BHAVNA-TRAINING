package com.bhavna.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bhavna.bean.Employee;

public class EmployeeDao {
	@Autowired
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(Employee employee) {
		String sql = "insert into employeerecord(employeeId,employeeName,employeeSalary,joiningDate,deptId,deptName,status) values('"
				+ employee.getEmployeeId() + "'," + employee.getEmployeeName() + ",'" + employee.getEmployeeSalary()
				+ ",'" + employee.getJoiningDate() + ",'" + employee.getDeptId() + ",'" + employee.getDeptName() + ",'"
				+ employee.getStatus() + "')";
		return template.update(sql);
	}

	public List<Employee> getEmployee() {
		return template.query("select * from employeerecord", new RowMapper<Employee>() {
			public Employee mapRow(ResultSet resultSet, int row) throws SQLException {
				Employee emp = new Employee();
				emp.setEmployeeId(resultSet.getInt(1));
				emp.setEmployeeName(resultSet.getString(2));
				emp.setEmployeeSalary(resultSet.getDouble(3));
				emp.setJoiningDate(resultSet.getString(4));
				emp.setDeptId(resultSet.getInt(5));
				emp.setDeptName(resultSet.getString(6));
				emp.setStatus(resultSet.getString(7));

				return emp;
			}
		});
	}

	public Employee getEmpById(int id) {
		String sql = "select * from employeerecord where employeeId=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Employee>(Employee.class));
	}
}
