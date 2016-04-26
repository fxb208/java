package com.io.objectStram;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class objectStreamTest {
	public static void main(String[] args) {
		test1();
		//System.out.println(ClassLoader.getSystemResource(""));
		//test2();
	}
	
	
	public static void OBStreamToFile(String fileResourceName,Object object){
		try {
			File file=new File("D:\\workspace\\templet\\objectStream\\"+fileResourceName);
			if(!file.exists()){
				file.createNewFile();
			}
			ObjectOutputStream obStream=new ObjectOutputStream(new FileOutputStream(file));
			obStream.writeObject(object);
			obStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static <T>T FileToOBStream(String fileResourceName,Class<T> cla){
		try {
			File file=new File("D:\\workspace\\templet\\objectStream\\"+fileResourceName);
			if(!file.exists()){
				file.createNewFile();
			}
			ObjectInputStream obStream=new ObjectInputStream(new FileInputStream(file));	
			return (T) obStream.readObject();	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static void test1(){
		Person person=FileToOBStream("person.txt",Person.class);
		System.out.println(person);
	}
	
	public static void test2(){
		Person person=new Person("fxb", 26, "male");
		OBStreamToFile("person.txt",person);
		System.out.println(person);
	}
}
