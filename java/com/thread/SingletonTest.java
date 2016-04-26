package com.thread;
//4，线程同步的弊端，由于同一个时间里只能有一个线程访问共享数据，效率变低了
class Sington{
	private Sington(){
		
	}
	private static Sington instance=null;
	public static Sington getSington(){
		if(instance==null){
			synchronized (Sington.class) {
				instance=new Sington();
			}
			
		}
		return instance;
	}
}
public class SingletonTest {
	public static void main(String[] args) {
		Sington sington1=Sington.getSington();
		Sington sington2=Sington.getSington();
		System.out.println(sington1==sington2);
	}
}
