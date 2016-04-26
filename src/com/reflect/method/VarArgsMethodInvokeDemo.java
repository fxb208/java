package com.reflect.method;

import java.lang.reflect.Method;
import java.util.Arrays;

public class VarArgsMethodInvokeDemo {
	public static void main(String[] args) throws Exception {
		Class cla=VarArgsMethodInvokeDemo.class;
		Method method1=cla.getMethod("show1", int[].class);
		//method.invoke(null, 1,2,3,4,5);
		method1.invoke(null, new int[]{1,2,3,4,5});
		
		Method method2=cla.getMethod("show2", String[].class);
		//System.out.println(method2);
		//method2.invoke(null, new String[]{"A","B","C"});
		//对于数组的引用类型，会自动解包，为了解决该问题，我们使用Object的一维数组把实际参数包装起来
		method2.invoke(null, new Object[]{new String[]{"A","B","C"}});
	}
	//可变参数底层就是数组
	//基本类型
	public static void show1(int[] args) {
		System.out.println(Arrays.toString(args));
	}
	//引用类型
	public static void show2(String[] args) {
		System.out.println(Arrays.toString(args));
	}
}
