package com.design.build;

public class Client {
	public static void main(String[] args) {
		Builder mingong=new Mingong();
	    Designer designer=new Designer();
	    System.out.println("创建room");
	    designer.order(mingong);
	    Room r = mingong.getRoom();
	    System.out.println(r.getWindow());//会输出window，表示构建成功。
	}
}
