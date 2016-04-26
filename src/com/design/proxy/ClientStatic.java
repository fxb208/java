package com.design.proxy;

public class ClientStatic {
	public static void main(String[] args) {
		UserManager userManager=new Proxy( new UserManagerImpl());  
        userManager.addUser("0001", "张三");
	}
}
