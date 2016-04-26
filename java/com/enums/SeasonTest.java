package com.enums;

public class SeasonTest {
	public static void main(String[] args) {
		
	}
}

//枚举类
class Season{
	//1,提供类的属性，声明为private final
	private final String seasonName;
	private final String seasonDesc;
	//2,构造器中初始化属性
	private Season(String seasonName,String seasonDesc){
		this.seasonName=seasonName;
		this.seasonDesc=seasonDesc;
	}
	//3，公共方法中调用
	public String getSeasonName() {
		return seasonName;
	}
	public String getSeasonDesc() {
		return seasonDesc;
	}
	//4,创建枚举类对象，声明为 static final 
	public static final Season SPRING=new Season("spring", "春暖花开");
	public static final Season SUMMER=new Season("spring", "夏日炎炎");
	public static final Season AUTUMN=new Season("spring", "秋高气爽");
	public static final Season WINTER=new Season("spring", "白雪皑皑");
	@Override
	public String toString() {
		return "Season [seasonName=" + seasonName + ", seasonDesc="
				+ seasonDesc + "]";
	}
	public void show(){
		System.out.println("season...........");
	}
}
