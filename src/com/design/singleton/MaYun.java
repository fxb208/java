package com.design.singleton;

public class MaYun {
	private static MaYun instance = new MaYun();
	public static MaYun getInstance() {
		return instance;
	}
	private MaYun() {
	//MaYun诞生要做的事情
	}
	public void splitAlipay() {
		System.out.println("Alipay是我的啦！看你丫Yahoo绿眉绿眼的望着。。。");
	}
}
