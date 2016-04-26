package com.reflect.field;

import java.lang.reflect.Field;

class User{
	private String name;
}
class Student extends User{
	private String sex;
	public int age;
}
public class FieldDemo {
	public static void main(String[] args) throws Exception {
		//getAllFields();
		getOneFields();
	}
	
	public static void getAllFields(){
		Class cla=Student.class;
		Field[] fields=cla.getFields();
		for(Field field:fields){
			System.out.println(field);
		}
		System.out.println("......");
	}
	
	public static void getOneFields() throws Exception{
		Class cla=Student.class;
	//	Field field=cla.getField("name");
		Field field=cla.getDeclaredField("sex");
		System.out.println(field);
	}
}
