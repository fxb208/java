package com.reflect.other;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class LoadResourceDemo {
	public static void main(String[] args) throws Exception {
		//load1();
		//load2_1();
		//load2_2();
		//load3();
	}
	public static void load1() throws Exception{
		InputStream inStream=new FileInputStream(new File("D:/workspace/templet/resources/db.properties"));
		Properties p=new Properties();
		p.load(inStream);
		System.out.println(p);
	}
	
	//classpath的根路劲（就是output的路劲），用ClassLoader去加载资源文件
	public static void load2_1() throws Exception{
		//ClassLoader静态方法
		InputStream inStream=
				ClassLoader.getSystemResourceAsStream("db.properties");
		Properties p=new Properties();
		p.load(inStream);
		System.out.println(p);
	}
	
	//获得ClassLoader对象
	public static void load2_2() throws Exception{
//		InputStream inStream=
//				LoadResourceDemo.class.getClassLoader().getResourceAsStream("db.properties");
		InputStream inStream=Thread.currentThread().
				getContextClassLoader().getResourceAsStream("db.properties");
		Properties p=new Properties();
		p.load(inStream);
		System.out.println(p);
	}
	
	//相对于类路劲去找db.properties
	public static void load3() throws Exception{
		InputStream inStream=
				LoadResourceDemo.class.getResourceAsStream("db.properties");
		Properties p=new Properties();
		p.load(inStream);
		System.out.println(p);
	}
}
