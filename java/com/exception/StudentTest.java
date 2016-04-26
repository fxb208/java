package com.exception;

public class StudentTest {
	public static void main(String[] args) {
		stuTest();
	}
	public static void stuTest(){
		Student s=new Student();
		try {
			s.regist(-12);
			System.out.println(s);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
}
class Student{
	private int id;
	public void regist(int id) throws MyException{
		if(id>0){
			this.id=id;
		}else{
			throw new MyException("传入的学号有误");
		}
	}
	@Override
	public String toString() {
		return "Student [id=" + id + "]";
	}
	
}
