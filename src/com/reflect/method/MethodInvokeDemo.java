package com.reflect.method;

import java.lang.reflect.Method;

class Emp{
	public int sayHello(){
		System.out.println("sayHello()");
		return 1;
	}
	public void sayHi(String name){
		System.out.println("sayHi(String name)..."+name);
	}
	private void sayGoodBye(String name,int age){
		System.out.println("sayGoodBye(String name,int age)..."+name+","+age);
	}
}
//方法的调用
public class MethodInvokeDemo {
	public static void main(String[] args) throws Exception {
		Class<Emp> cla=Emp.class;
		Method method01=cla.getMethod("sayHello");
		Method method02=cla.getMethod("sayHi", String.class);
		Method method03=cla.getDeclaredMethod("sayGoodBye", String.class,int.class);
		System.out.println(method02);
		Object i=method01.invoke(cla.newInstance());
		System.out.println(i);
		method02.invoke(cla.newInstance(), "fxb");
		method03.setAccessible(true);
		method03.invoke(cla.newInstance(), "fxb",26);
	}
	
}
