package com.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 如何处理Exception
 * java提供的是异常处理的抓抛模型
 * 1，try{}catch(Exception e){}
 * 注：1,try内声明的变量，类似于局部变量，出了try{}，就不能被调用
 * 	2,finally可选
 * 	3,catch语句内部是对异常的处理
 * 		>e.getMessage();
 * 		>e.getStackTrace();
 *
 */
public class ExceptionHandleTest {
	public static void main(String[] args) {
		//test01();
		test02();
	}
	public static void test01(){
		Scanner s=new Scanner(System.in);
		try{
			int i=s.nextInt();
			System.out.println(i);
		}catch(InputMismatchException e){
			//System.out.println("输入类型不匹配");
			//System.out.println(e.getMessage());
			e.getStackTrace();
		}
	}
	
	public static void test02(){
		try {
			int[] i=new int[10];
			System.out.println(i[10]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("数组下标越界......");
			e.printStackTrace();
			
		}
		System.out.println("异常处理了");
	}
}
