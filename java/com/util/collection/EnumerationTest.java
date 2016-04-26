package com.util.collection;

import java.util.Enumeration;
import java.util.StringTokenizer;

public class EnumerationTest {
	public static void main(String[] args) {
		test1();
	}
	public static void test1(){
		Enumeration enu=new StringTokenizer("ab-c*-gg-d", "-");
		while(enu.hasMoreElements()){
			System.out.println(enu.nextElement());
		}
	}
}
