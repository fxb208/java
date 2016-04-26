package com.util.collection;

public class Employee implements Comparable{
	private String name;
	private Integer age;
	private MyDate myDate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public MyDate getMyDate() {
		return myDate;
	}
	public void setMyDate(MyDate myDate) {
		this.myDate = myDate;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", myDate=" + myDate
				+ "]";
	}
	public Employee(String name, Integer age, MyDate myDate) {
		super();
		this.name = name;
		this.age = age;
		this.myDate = myDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((myDate == null) ? 0 : myDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (myDate == null) {
			if (other.myDate != null)
				return false;
		} else if (!myDate.equals(other.myDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if(o instanceof Employee){
			Employee e=(Employee)o;
			return this.getName().compareTo(e.getName());
		}
		return 0;
	}
	
}
