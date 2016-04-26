package com.compare;

//Person实现Comparable接口要覆盖compareTo方法
public class Person implements Comparable<Person>{
	private String name;
	private int age;
	public Person(String name,int age){
		this.name=name;
		this.age=age;
	}
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
	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return this.getAge()-o.getAge();
	}
	
}
