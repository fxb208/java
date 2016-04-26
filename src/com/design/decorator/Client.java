package com.design.decorator;

public class Client {
	public static void main(String[] args) {
		Person p=new Person();
		Decorator decorator=new Decorator_first(new Decorator_zero(p));
		decorator.wearClothes();
		decorator.walkToWhere();
	}
}
