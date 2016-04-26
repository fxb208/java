package com.design.singleton;

import java.util.HashSet;
import java.util.Set;

public class Client {
	public static void main(String[] args) {
		//test01();
		test04();
	}
	
	public static void test01(){
		MaYun maYun01=MaYun.getInstance().getInstance();
		MaYun maYun02=MaYun.getInstance().getInstance();
		System.out.println(maYun01==maYun02);
	}
	
	public static void test02(){
//		Singleton singleton01=Singleton.getSingleton();
//		Singleton singleton02=Singleton.getSingleton();
//		System.out.println(singleton01==singleton02);
	}
	
	public static void test03(){
		Singleton singleton1=Singleton.getInstance();
		Singleton singleton2=Singleton.getInstance();
		System.out.println(singleton1==singleton2);
	}
	
	public static void test04(){
		ThreadTest t=new ThreadTest();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		System.out.println(t.singles.toString());
	}
}

class ThreadTest implements Runnable {  
    //存放单例对象，使用Set是为了不存放重复元素  
    public Set<Singleton> singles = new HashSet<Singleton>();  
    @Override  
    public void run() {  
        //获取单例  
    	Singleton s = Singleton.getInstance();  
        //添加单例  
        singles.add(s);  
    }  
}  
