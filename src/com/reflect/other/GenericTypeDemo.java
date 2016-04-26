package com.reflect.other;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import org.eclipse.jdt.internal.compiler.lookup.ParameterizedTypeBinding;

class XXOO{
	public Map<String, Object> cache;
}
public class GenericTypeDemo {
	public static void main(String[] args) throws Exception {
		Class cla=XXOO.class;
		Field field=cla.getDeclaredField("cache");
		//没有带泛型信息
		Class type=field.getType();
		System.out.println(type);//interface java.util.Map
		
		//获取带泛型的类型
		Type qtype=field.getGenericType();
		ParameterizedType pType=(ParameterizedType)qtype;
		Type[] types=pType.getActualTypeArguments();
		for(Type t:types){
			System.out.println(t);
		}
	}
}
