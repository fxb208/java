package com.design.factory;
/*
 * 利用反射实现的工厂模式
 */
public class FruitFactory {
	
	public static Fruit getFruit(String className){
		Fruit fruit=null;
		try {
			fruit=(Fruit)Class.forName(className).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fruit;
		
	}
}
