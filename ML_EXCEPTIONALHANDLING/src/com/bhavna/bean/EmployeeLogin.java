package com.bhavna.bean;

public class EmployeeLogin {

	private String name;
    private String time;
    
	public EmployeeLogin(String name, String time) {
		super();
		this.name = name;
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "[name=" + name + ", time=" + time + "]";
	}
    
    
}
