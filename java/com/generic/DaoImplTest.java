package com.generic;

import java.util.List;

public class DaoImplTest {
	public static void main(String[] args) {
		test1();
	}
	public static void test1(){
		DaoImpl<User> dao=new DaoImpl<>();
		dao.save("AA",new User(1, 25, "FXB"));
		dao.save("BB", new User(2, 26, "TT"));
		dao.save("CC", new User(3, 24, "FXB"));
		System.out.println(dao.get("CC"));
		dao.remove("CC");
		List<User> list=dao.list();
		System.out.println(list);
	}
}
