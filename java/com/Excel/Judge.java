package com.Excel;

public class Judge {
	private String name;
	private String department;
	private String phone;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Judge [name=" + name + ", department=" + department
				+ ", phone=" + phone + "]";
	}
	
}
