package com.design.decorator;

public class Person implements Human{

	@Override
	public void wearClothes() {
		// TODO Auto-generated method stub
		 System.out.println("穿什么呢。。");  
	}

	@Override
	public void walkToWhere() {
		// TODO Auto-generated method stub
		 System.out.println("去哪里呢。。"); 
	}

}
