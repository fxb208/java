package com.exception;

import java.util.Date;
import java.util.Scanner;

/*
 * 一：异常体系结构
 * java.lang.Throwable
 *   |---Error:错误，程序中不进行处理
 *   |---Exception:要求在编写程序时，就要考虑对这些异常处理
 *   	|---编译时异常，编译期间出现异常(执行javac.exe命令时，出现异常)
 *   		Java编译器强制要求处理这类异常，如果不捕获这类异常，程序将不能被编译。
 *   	|---运行时异常，在运行期间出现的异常(执行java.exe命令时)
 * 当执行一个异常，如果出现异常，那么异常之后代码不再执行
 */
public class ExceptionTest {
	public static void main(String[] args) {
		test01();
		//test02();
		//test03();
		//test04();
		//tets05();
	}
	//空指针异常:java.lang.NullPointerException
	public static void tets05(){
		Person person=new Person();
		//person=null;
		System.out.println(person.getName().toString());
		
		String str="good good study,day day up";
		System.out.println(str.length());
	}
	
	//类型转换异常:java.lang.ClassCastException
	public static void test04(){
		Object obj=new Date();
		String str=(String)obj;
	}
	
	//算数异常:java.lang.ArithmeticException
	public static void test03(){
		int i=10;
		System.out.println(i/0);
	}
	//数组下标越界
	//java.lang.ArrayIndexOutOfBoundsException
	public static void test02(){
		int[] i=new int[10];
		System.out.println(i[10]);
	}
	
	public static void test01(){
		Scanner s=new Scanner(System.in);
		int i=s.nextInt();
		System.out.println(i);
	}
}

class Person{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
