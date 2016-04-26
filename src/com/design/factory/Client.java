package com.design.factory;

public class Client {
	public static void main(String[] args) {
		Fruit fruit=FruitFactory.getFruit("com.factory.Apple");
		fruit.grow();
		fruit.eat();
	}
}
