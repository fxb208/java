package com.design.interfaceFactory;

public class Factory implements IFactory{

	@Override
	public IProduct1 createIProduct1() {
		// TODO Auto-generated method stub
		return new Product1();
	}

	@Override
	public IProduct2 createIProduct2() {
		// TODO Auto-generated method stub
		return new Product2();
	}

}
