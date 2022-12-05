package com.bhavna.bean;

public class EmployeeLogin {

	private String name;
	private String date;
    private String time;
    
	public EmployeeLogin(String name, String date,String time) {
		super();
		this.name = name;
		this.time = time;
		this.date = date;
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
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return " [name=" + name + ", date=" + date + ", time=" + time + "]";
	}
	
    
    
}
