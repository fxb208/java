package com.reflect.other;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class ReflectDemo {
	public static void main(String[] args) throws Exception {
		Class cla=Arrays.class;
		Method[] methods=cla.getMethods();
		for(Method method:methods){
			if("asList".equals(method.getName())){
				System.out.println(method);
			}
		}
		Method m=cla.getMethod("asList", Object[].class);
		List l=(List)m.invoke(null, new Object[]{new String[]{"A","B","C"}});
		System.out.println(l);
	}
}
