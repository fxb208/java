package com.generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericTest {
	/*
	 * 1，不能在static方法中使用泛型
	 * 2，不能在try——catch中使用泛型的声明
	 */
	public static void main(String[] args) {
		//test1();
		//test2();
		//test3();
		//test4();
		test7();
	}
	public static void test1(){
		/*
		 * 1，实例化泛型类的对象时，指明泛型的类型
		 * 指明以后，对应类中所有使用泛型的位置，都变为实例化中指定的泛型类型
		 * 2，如果没有指明，默认object类型
		 */

		Order<Boolean> order=new Order<Boolean>();
		order.setT(true);
		order.add();
		List<Boolean> list=order.list;
		System.out.println(list);
	}
	
	public static void test2(){
		SubOrder subOrder=new SubOrder();
		subOrder.setT(12);
		System.out.println(subOrder.getT());
	}
	
	public static void test3(){
		Order<Boolean> order=new Order<Boolean>();
		Integer i=order.getE(34);
		System.out.println(i);
	}
	
	public static void test4(){
		Order<Boolean> order=new Order<Boolean>();
		Integer[] integers=new Integer[]{1,2,3};
		List<Integer> list=new ArrayList<>();
		List<Integer> list1=order.fromArrayToList(integers, list);
		System.out.println(list1);
	}
	
	
	/*
	 * 泛型与继承的关系:
	 * 若类A是类B的子类，那么List<A>就不是list<B>的子接口
	 */
	public static void test5(){	
		Object object=null;
		String str="AA";
		object=str;
		List<Object> list=null;
		List<String> list1=new ArrayList<String>();
		//list=list1;
		/*
		 * 假设list=list1;
		 * list.add(123);
		 * list.get(0)获得的是Integer
		 */
		
	}
	
	/*
	 * 通配符?
	 * List<A>,list<B>都是List<?>的子接口
	 * ? extend A:可存放A及其子类
	 * ? super A:可存放A及其父类
	 */
	public static void test6(){	
		List<?> list=null;
		List<String> list1=new ArrayList<String>();
		List<Object> list2=new ArrayList<Object>();
		list=list1;
		list=list2;
	}
	
	public static void test7(){	
		List<?> list=null;
		List<String> list1=new ArrayList<String>();
		list1.add("AA");
		list1.add("BB");
		list=list1;
		Iterator<?> iterator=list.iterator();
		//可以读取声明为通配符的集合类的对象
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		//不可以向声明为通配符的集合类的对象写入，唯一例外，可以存null
		list1.add(null);

	}
}
