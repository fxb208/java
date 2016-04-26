package com.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {
	public static void main(String[] args) {
		//testComparable();
		//testComparator();
		testPersonComparable();
	}
	public static void testComparable(){
		Person person01=new Person("fxb", 12);
		Person person02=new Person("fxb", 36);
		Person person03=new Person("fxb", 24);
		List<Person> list=new ArrayList<>();
		list.add(person01);
		list.add(person02);
		list.add(person03);
		for(Person p:list){
			System.out.println(p.getAge());
		}
		Collections.sort(list);
		System.out.println("................");
		for(Person p:list){
			System.out.println(p.getAge());
		}
	}
	
	public static void testComparator(){
		User person01=new User("fxb", 12);
		User person02=new User("fxb", 36);
		User person03=new User("fxb", 24);
		List<User> list=new ArrayList<>();
		list.add(person01);
		list.add(person02);
		list.add(person03);
		for(User u:list){
			System.out.println(u.getAge());
		}
		Collections.sort(list,new UserComparator());
		
		System.out.println("................");
		for(User u:list){
			System.out.println(u.getAge());
		}
	}
	
	public static void testPersonComparable(){
		Person person01=new Person("fxb", 12);
		Person person02=new Person("fxb", 36);
		System.out.println(person01.compareTo(person02));
	}
	
	
}
