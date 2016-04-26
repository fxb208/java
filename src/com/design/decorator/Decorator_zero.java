package com.design.decorator;

public class Decorator_zero extends Decorator{

	public Decorator_zero(Human human) {
		super(human);
		// TODO Auto-generated constructor stub
	}
	
	public void goHome(){
		System.out.println("进房子。。。。");
	}
	public void findMap(){
		System.out.println("书房找找Map。。。");
	}

	@Override
	public void wearClothes() {
		// TODO Auto-generated method stub
		super.wearClothes();
		findMap();
	}

	@Override
	public void walkToWhere() {
		// TODO Auto-generated method stub
		super.walkToWhere();
		goHome();
	}

}
