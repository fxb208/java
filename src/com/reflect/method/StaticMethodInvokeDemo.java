package com.reflect.method;

import java.lang.reflect.Method;

public class StaticMethodInvokeDemo {
	public static void main(String[] args) throws Exception{
		Class cla=StaticMethodInvokeDemo.class;
		Method method=cla.getMethod("getStatic", String.class);
		method.invoke(null, "fxb");
	}
	public static void getStatic(String name){
		System.out.println("getStatic(String name)...."+name);
	}
}
