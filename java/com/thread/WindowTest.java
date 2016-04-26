package com.thread;
//模拟火车票售票
class Window extends Thread{
	static int ticket=100;
	static Object obj=new Object();
	public void run(){
		while(true){
		//	synchronized (this) {//this表示win1，win2，win3
			synchronized (obj) {
				if(ticket>0){
					try {
						Thread.currentThread().sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"售票:"+ticket--);
				}else{
					break;
				}
			}
			
		}
	}
	
}

class Window1 implements Runnable{

	int ticket=100;
	public void run(){
		while(true){	
			if(ticket>0){
				try {
					Thread.currentThread().sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"售票:"+ticket--);
			}else{
				break;
			}
		}
	}
	
}
/*
 * java实现线程安全，线程的同步机制
 * 一：同步代码块
 * 1，共享数据：多个线程共同操作的同一数据（变量）
 * 2，同步监视器：由一个类来当担。那个线程获取此监视器，谁就执行大括号里被同步的方法。俗称锁
 * 要求：所有的线程公用一把锁
 * 注：在实现的的方式中，可以使用this来充当锁，但在继承的方式里，慎用this
 * 二：同步方法
 * synchronized修饰的方法
 * 同步方法的锁：this
 */
class Window2 implements Runnable{
	int ticket=100;
	Object obj=new Object();	
	public void run(){
		Animal animal=new Animal();
		while(true){	
			synchronized (this) {
				if(ticket>0){
					try {
						Thread.currentThread().sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"售票:"+ticket--);
				}else{
					break;
				}
			}
		}
	}
	
}

class Window3 implements Runnable{
	int ticket=100;
	Object obj=new Object();	
	public void run(){
		while(true){
			show();
		}	
	}
	public synchronized void show(){
		if(ticket>0){
			try {
				Thread.currentThread().sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"售票:"+ticket--);
		}
	}
	
}
public class WindowTest {
	public static void main(String[] args) {
	//	ThreadTest();
	//	RunnableTest();
		System.out.println("...................");
	//	RunnableSynoTest();
		MethodSynoTest();
	}
	
	public static void ThreadTest(){
		Thread win1=new Window();
		Thread win2=new Window();
		Thread win3=new Window();
		win1.setName("窗口1");
		win2.setName("窗口2");
		win3.setName("窗口3");
		win1.start();
		win2.start();
		win3.start();
	}
	
	public static void RunnableTest(){	
		Runnable win1=new Window1();
		Thread t1=new Thread(win1);
		Thread t2=new Thread(win1);
		Thread t3=new Thread(win1);
		t1.setName("窗口1");
		t2.setName("窗口2");
		t3.setName("窗口3");
		t1.start();
		t2.start();
		t3.start();
	}
	
	public static void RunnableSynoTest(){	
		Runnable win1=new Window2();
		Thread t1=new Thread(win1);
		Thread t2=new Thread(win1);
		Thread t3=new Thread(win1);
		t1.setName("窗口1");
		t2.setName("窗口2");
		t3.setName("窗口3");
		t1.start();
		t2.start();
		t3.start();
	}
	
	public static void MethodSynoTest(){	
		Runnable win1=new Window3();
		Thread t1=new Thread(win1);
		Thread t2=new Thread(win1);
		Thread t3=new Thread(win1);
		t1.setName("窗口1");
		t2.setName("窗口2");
		t3.setName("窗口3");
		t1.start();
		t2.start();
		t3.start();
	}
}

class Animal{
	
}
