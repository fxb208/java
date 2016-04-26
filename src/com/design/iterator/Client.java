package com.design.iterator;

public class Client {
	public static void main(String[] args) {
		Aggregate aggregate=new ConcreteAggregate();
		aggregate.add("小刚");
		aggregate.add("小红");
		aggregate.add("小明");
		Iterator it=aggregate.iterator();
		while(it.hasNext()){
			String str=(String)it.next();
			System.out.println(str);
		}
		
	}
}
