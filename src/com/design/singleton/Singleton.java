package com.design.singleton;



public class Singleton{
//	//这种方式不行
//	private Singleton(){
//		
//	}
//	public static Singleton getSingleton(){
//		return new Singleton();
//	}
//	public void show(){
//		System.out.println(".........");
//	}
	
	//方式一 懒单例模式
	private static Singleton instance=null;
	private Singleton(){
		System.out.println("创建对象。。。。。。。");
	}
	
	//参考：http://blog.csdn.net/youcanping2008/article/details/8579409
	public static Singleton getInstance(){
		if(instance==null){
			//对于一般方法同步代码块内，可以使用this，
			//对于静态方法而言，使用当前类本身充当锁
			synchronized(Singleton.class){
				if(instance==null){
					instance=new Singleton();
				}
			}
			
		}
		return instance;
	}
	
	//懒单例模式线程安全问题
//	public static Singleton getInstance(){
//		if(instance==null){
//			if(instance==null){
//				instance=new Singleton();
//			}
//		}
//		return instance;
//	}
}
