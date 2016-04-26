package com.reflect.other;

import java.lang.reflect.Modifier;

public abstract class OtherApiDemo {
	public static void main(String[] args) {
		int mod=OtherApiDemo.class.getModifiers();
		System.out.println(mod);
		System.out.println(Modifier.toString(mod)); 
		System.out.println(OtherApiDemo.class.getName());
		System.out.println(OtherApiDemo.class.getSimpleName());
	}
}
