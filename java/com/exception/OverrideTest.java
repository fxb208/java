package com.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

//子类重写抛出的异常要是父类异常类的子类或者是父类异常
public class OverrideTest {
	public static void main(String[] args) {
		A a=new B();
		try {
			a.method();
		} catch (ClassCastException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class A{
	public void method() throws ClassCastException{
		System.out.println("我是A的方法.......");
	}
}

class B extends A{
	public void method() throws RuntimeException{
		System.out.println("我是B的方法.......");
	}
}