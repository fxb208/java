package com.util.collection;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		//test01();
		//test02();
		//test03();
		test04();
		
	}
	public static void test01(){
		//treeSet定制排序
		/*
		 * 1，创建一个Comparator接口的类对象
		 * 2，将此对象作为形参传递给TreeSet的构造器
		 */
		Comparator comparator=new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				if(o1 instanceof Customer && o2 instanceof Customer){
					Customer c1=(Customer)o1;
					Customer c2=(Customer)o2;
					int i=c1.getAge().compareTo(c2.getAge());
					if(i==0){
						return c1.getName().compareTo(c2.getName());
					}
					return i;
					
				}
				return 0;
			}
		};
		
		Set set=new TreeSet(comparator);
		set.add(new Customer("AA", 21));
		set.add(new Customer("CC", 29));
		set.add(new Customer("DD", 26));
		set.add(new Customer("BB", 24));
		for(Object obj:set){
			System.out.println(obj);
		}
	}
	
	
	public static void test02(){
		
		MyDate date1=new MyDate(1991, 2, 8);
		Employee e1=new Employee("AA", 26, date1);
		
		MyDate date2=new MyDate(1990, 12, 24);
		Employee e2=new Employee("DD", 26, date1);
		
		MyDate date3=new MyDate(1991, 12, 24);
		Employee e3=new Employee("BB", 26, date1);
		
		MyDate date4=new MyDate(1995, 12, 24);
		Employee e4=new Employee("CC", 26, date1);
		
		MyDate date5=new MyDate(1997, 12, 24);
		Employee e5=new Employee("CC", 27, date1);
		Set set=new TreeSet();
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		set.add(e5);
		for(Object obj:set){
			System.out.println(obj);
		}
	}
	
	public static void test03(){
		Comparator comparator=new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				if(o1 instanceof Employee1 && o2 instanceof Employee1){
					Employee1 e1=(Employee1)o1;
					Employee1 e2=(Employee1)o2;
					MyDate c1=e1.getMyDate();
					MyDate c2=e2.getMyDate();
					int i=c1.getYear().compareTo(c2.getYear());
					if(i==0){
						int j=c1.getMonth().compareTo(c1.getMonth());
						if(j==0){
							return c1.getDay().compareTo(c2.getDay());
						}
						return j;
					}
					return i;
					
				}
				return 0;
			}
		};
		
		MyDate date1=new MyDate(1991, 2, 8);
		MyDate date2=new MyDate(1990, 12, 24);	
		MyDate date3=new MyDate(1991, 12, 24);
		MyDate date4=new MyDate(1995, 12, 24);
		MyDate date5=new MyDate(1997, 12, 24);
		
		Employee1 e11=new Employee1("AA", 26, date1);
		Employee1 e12=new Employee1("DD", 26, date2);
		Employee1 e13=new Employee1("BB", 26, date3);
		Employee1 e14=new Employee1("CC", 26, date4);	
		Employee1 e15=new Employee1("GG", 27, date5);
		Set set1=new TreeSet(comparator);
		set1.add(e11);
		set1.add(e12);
		set1.add(e13);
		set1.add(e14);
		set1.add(e15);
		Iterator iterator=set1.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	
	public static void test04(){
		Set set=new TreeSet();
		set.add("aa");
		set.add(12);
		System.out.println(set.size());
	}
}
