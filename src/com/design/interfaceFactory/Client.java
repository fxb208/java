package com.design.interfaceFactory;

public class Client {
	public static void main(String[] args) {
		Factory factory=new Factory();
		factory.createIProduct1().show();
		factory.createIProduct2().show();
	}
}
