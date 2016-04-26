package com.reflect.constructor;

import java.lang.reflect.Constructor;

class Emp{
	public Emp(){
		System.out.println("Emp()");
	}
	public Emp(String name){
		System.out.println("Emp(String name)...."+name);
	}
	private Emp(String name,int age){
		System.out.println("Emp(String name,int age)...."+name+age);
	}
	
}
public class ConstructorInvokeDemo {
	public static void main(String[] args) throws Exception {
		Class<Emp> cla=Emp.class;
		Constructor<Emp> constructor01=cla.getConstructor();
		Constructor<Emp> constructor02=
				cla.getConstructor(String.class);
		Constructor<Emp> constructor03=
				cla.getDeclaredConstructor(String.class,int.class);
		Emp emp01=constructor01.newInstance();
		Emp emp02=constructor02.newInstance("fxb");
		constructor03.setAccessible(true);
		Emp emp03=constructor03.newInstance("fxb",26);
	}
}
