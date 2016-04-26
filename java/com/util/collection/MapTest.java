package com.util.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MapTest {
	public static void main(String[] args) {
		//test1();
		//test2();
		//test3();
		//test4();
		
		test5();
	}
	public static void test1(){
		Map map=new HashMap();
		map.put("AA", 26);
		map.put(null, 23);
		map.put("BB", 22);
		map.put(22, "CC");
		map.put(22, "DD");
		System.out.println(map.size());
		System.out.println(map);
	}
	
	public static void test2(){
		Map map=new HashMap();
		map.put("AA", 26);
		map.put(null, 23);
		map.put("BB", 22);
		map.put(22, "CC");
		
		//遍历key
		Set set1=map.keySet();
		for(Object obj:set1){
			System.out.println(obj+"="+map.get(obj));
		}
		
		//遍历entry
		Set<Entry<Object, Object>> set2=map.entrySet();
		for(Entry entry:set2){
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
		
		//遍历value
		Collection collection=map.values();
		Iterator iterator=collection.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	
	public static void test3(){
		//自然排序
		Map<Person,Integer> map=new TreeMap<Person,Integer>();
		map.put(new Person("AA", 24), 98);
		map.put(new Person("BB", 24), 98);
		map.put(new Person("DD", 24), 97);
		map.put(new Person("CC", 24), 96);
		Set<Person> set=map.keySet();
		for(Person p:set){
			System.out.println(map.get(p));
		}
	}
	
	public static void test4(){
		//定制排序
		Comparator comparator=new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				if(o1 instanceof Customer
						&& o2 instanceof Customer){
					Customer person1=(Customer)o1;
					Customer person2=(Customer)o2;
					int i=person1.getAge().compareTo(person2.getAge());
					if(i==0){
						return person1.getName().compareTo(person2.getName());
					}
					return i;
				}
				return 0;
			}
		};
		Map<Customer,Integer> map=new TreeMap<Customer,Integer>(comparator);
		map.put(new Customer("AA", 23), 98);
		map.put(new Customer("BB", 29), 98);
		map.put(new Customer("DD", 21), 97);
		map.put(new Customer("CC", 22), 96);
		Set<Customer> set=map.keySet();
		for(Customer customer:set){
			System.out.println(customer+"="+map.get(customer));
		}
	}
	
	public static void test5(){
		Comparator comparator=new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1,
					Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				return -o1.getValue().compareTo(o2.getValue());
			}
		};
		Map<String, Integer> map=new TreeMap<String,Integer>();
		map.put("YY", 100);
		map.put("AA", 68);
		map.put("CC", 75);
		map.put("DD", 90);
		map.put("GG", 60);
		map.put("BB", 70);
		map.put("MM", 95);
		map.put("JJ", 78);
		List<Map.Entry<String, Integer>> list=new ArrayList<Map.Entry<String, Integer>>(map.entrySet()) ;
		Collections.sort(list, comparator);
		List<Map.Entry<String, Integer>> list1=list.subList(0, 3);
		for(Map.Entry<String, Integer> entry:list1){
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}
}

