package com.design.proxy;

public class Proxy implements UserManager{
	private UserManager userManager;
	public Proxy(UserManagerImpl ul){
		this.userManager=ul;
	}

	@Override
	public void addUser(String userId, String userName) {
		// TODO Auto-generated method stub
		System.out.println("正在进行添加用户前的准备工作,用户id为："+userId+"……");  
        try {  
            userManager.addUser(userId, userName);  
            System.out.println("成功添加用户"+userId+"，正在进行确认处理……");  
        } catch (Exception e) {  
            System.out.println("添加,userId="+userId+"失败！");  
        }  
	}

	@Override
	public void modifyUser(String userId, String userName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delUser(String userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String findUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
