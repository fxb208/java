package com.reflect.other;
//对象工厂，创建对象
//工厂类通常涉及单例模式，应该把工厂类做成单例的

/*
 * 如何编写工具类
 * 方法一：
 * 	1，把工具方法做成非static方法
 * 	2，把工具类做成单例模式的 	
 * 那么要调用工具方法，必须先得到工具类对象，再调用方法
 * 
 * 方法二：
 * 	1，把工具方法做成static方法
 * 	2，把工具类所有的构造器全部私有化，或者把改工具类加上abstract
 * 这样做的目的：就是为了全部是类去调用工具方法
 * 如：java.util.Arrays类
 */
public enum BeanFactory {
	INSTANCE;
	public <T>T creatBean(String className,Class<T> checkType){
		try {
			Class<T> cla=(Class<T>) Class.forName(className);
			Object obj=cla.newInstance();
			//需要检查obj的类型
			if(!checkType.isInstance(obj)){
				throw new IllegalArgumentException("对象和类不兼容");
			}
			return (T)obj;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}
}
