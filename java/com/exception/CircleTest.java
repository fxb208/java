package com.exception;

class Circle implements Comparable{
	private double radius;
	

	public double getRadius() {
		return radius;
	}


	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}


	@Override
	public int compareTo(Object obj) {
		// TODO Auto-generated method stub
		if(this==obj){
			return 0;
		}else if(obj instanceof Circle){
			Circle c=(Circle) obj;
			if(this.radius>c.radius){
				return 1;
			}else if(this.radius==c.radius){
				return 0;
			}else{
				return -1;
			}
		}else{
			throw new RuntimeException("传入的类型有误");
			//抛出自定义异常
			//throw new MyException("传入的类型有误");
		}
	}
}

public class CircleTest{
	public static void main(String[] args) {
		Circle c1=new Circle(2.1);
		Circle c2=new Circle(2.1);
		try {
			System.out.println(c1.compareTo(c2));
			System.out.println(c1.compareTo("adc"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
