package com.design.singleton;

public class Person {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean equals(Person p) 
	{
		if(p==null){
			System.out.println("p==null");
			return false;
		}
		if(p==this){
			System.out.println("p==this");
			return true;
		}
		System.out.println(".....");
		return (this.name.equals(p.name))&&(this.age==p.age);
	}
	
}
