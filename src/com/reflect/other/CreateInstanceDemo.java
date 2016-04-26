package com.reflect.other;

import java.util.Date;

public class CreateInstanceDemo {
	public static void main(String[] args) {
		Object date1=creatInstance("java.util.Date");
		System.out.println(date1);
		
		Date date2=BeanFactory.INSTANCE.creatBean("java.util.Date", Date.class);
		System.out.println(date2);
		
		Date date3=ObjectFactory.creatBean("java.util.Date", Date.class);
		System.out.println(date3);
 	}
	
	//根据传入的类全限定名，创建一个对象并返回
	public static Object creatInstance(String className){
		try {
			Class cla=Class.forName(className);
			Object obj=cla.newInstance();
			return obj;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}
	
	public static <T>T creatInstance(Class<T> cla){
		try {
			return cla.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}
	
	public static <T>T creatInstance2(String className){
		try {
			Class<T> cla=(Class<T>) Class.forName(className);
			Object obj=cla.newInstance();
			//需要检查obj的类型
			return (T)obj;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}
	

}
