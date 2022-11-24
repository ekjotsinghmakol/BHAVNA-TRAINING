package com.bhavna.model;

public class Details {
	private String country;
	private String state;
	private String area;
	private long zipCode;


	public Details(String country, String state, String area, long zipCode) {
		super();
		this.country = country;
		this.state = state;
		this.area = area;
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "[country=" + country + ", state=" + state + ", area=" + area + ", zipCode=" + zipCode + "]";
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public long getZipCode() {
		return zipCode;
	}
	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}


	

	
}
