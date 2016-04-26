package com.util.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 操作Collection和Map的工具类,Collections
 * 
 * 
 *
 */
public class CollectionsTest {
	public static void main(String[] args) {
		//test1();
		test2();
	}
	public static void test1(){
		List<Integer> list=new ArrayList<Integer>(); 
		list.add(123);
		list.add(250);
		list.add(26);
		list.add(360);
		System.out.println(list);
		
		System.out.println(".............");
		Collections.reverse(list);
		System.out.println(list);
		
		System.out.println("-------------");
		Collections.sort(list);
		System.out.println(list);
		
		System.out.println(".............");
		Collections.shuffle(list);
		System.out.println(list);
		
		System.out.println("-------------");
		Collections.swap(list, 0, 2);
		System.out.println(list);
	}
	
	public static void test2(){
		List<Integer> list=new ArrayList<Integer>(); 
		list.add(123);
		list.add(250);
		list.add(26);
		list.add(360);
		list.add(360);
		System.out.println(Collections.max(list));
		System.out.println(Collections.min(list));
		System.out.println(Collections.frequency(list, 360));
		System.out.println(".................");
		//错误的实现方式
	//	List<Integer> list1=new ArrayList<Integer>();
		List list1=Arrays.asList(new Object[list.size()]);
		Collections.copy(list1, list);
		System.out.println(list1);
		
	//通过以下方式保证list的线程安全性
		Collections.synchronizedList(list);
		System.out.println(list);
	}
}
