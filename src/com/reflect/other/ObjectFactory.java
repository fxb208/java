package com.reflect.other;

public class ObjectFactory {
	private ObjectFactory(){
		
	}
	public static <T>T creatBean(String className,Class<T> checkType){
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
