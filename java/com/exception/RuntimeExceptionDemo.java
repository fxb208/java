package com.exception;

public class RuntimeExceptionDemo {
	static void methodA(){
		try {
			System.out.println("进入方法A");
			throw new RuntimeException("制造异常");
		} finally{
			// TODO Auto-generated catch block
			System.out.println("用A方法的finally......");
		}
	}
	static int methodB(){
		try {
			System.out.println("进入方法B");
			return 1;
		}finally{
			// TODO Auto-generated catch block
			System.out.println("用B方法的finally......");
			return 2;
		}
	}
	public static void main(String[] args) {
		try {
			methodA();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		int i=methodB();
		System.out.println(i);
	}
}
