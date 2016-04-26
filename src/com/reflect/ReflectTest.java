package com.reflect;

import java.lang.reflect.Constructor;

import org.junit.Test;

public class ReflectTest {
	//@Test
	public void testClass01() throws ClassNotFoundException{
		Class cla1=Person.class;
		Person person=new Person("fxb", 26);
		Class cla2=person.getClass();
		Class cla3=Class.forName("com.reflect.Person");
		System.out.println(cla1==cla2);
		Constructor<Person>[] constructors=cla2.getConstructors();
		for(Constructor<Person> c:constructors){
			System.out.println(c);
		}
	}
	@Test
	public void testClass02(){
		System.out.println(Integer.TYPE==int.class);
	}
}
