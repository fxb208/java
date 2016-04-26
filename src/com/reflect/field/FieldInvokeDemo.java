package com.reflect.field;

import java.lang.reflect.Field;

class Emp{
	private String name="xxxx";
	private int age=20;
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
}

public class FieldInvokeDemo {
	public static void main(String[] args) throws Exception {
		//setValue();
		getValue();
	}
	
	public static void setValue() throws Exception{
		Class cla=Emp.class;
		Field field01=cla.getDeclaredField("name");
		Field field02=cla.getDeclaredField("age");
		field01.setAccessible(true);
		field02.setAccessible(true);
		Object obj=cla.newInstance();
		field01.set(obj, "fxb");
		field02.set(obj, 26);
		System.out.println(obj);
	}
	
	public static void getValue() throws Exception{
		Class cla=Emp.class;
		Field field01=cla.getDeclaredField("name");
		Field field02=cla.getDeclaredField("age");
		field01.setAccessible(true);
		field02.setAccessible(true);
		Object object01=field01.get(cla.newInstance());
		int object02=field02.getInt(cla.newInstance());
		System.out.println(object01.toString());
		System.out.println(object02);
	}
}
