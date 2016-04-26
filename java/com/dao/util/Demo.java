package com.dao.util;

import com.dao.util.Util.Work;

public class Demo implements Work{

	public static void main(String[] args) {
		System.out.println(Work.age);
	}
	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("isWorking.........");
	}

}
