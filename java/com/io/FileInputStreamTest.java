package com.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* 1,流的分类：
 * 数据流向的不同：输入流，输出流
 * 处理数据单位的不同：字节流，字符流（处理文本文件）
 * 角色的不同：节点流(直接作用于文件的)，处理流
 * 2,io体系
 * 抽象基类：                                         节点流                                                     处理流     
 * InputStream      FileInputStream         BufferedInputStream
 * OutputStream     FileOutputStream        BufferedOutputStream(flush())
 * Reader           FileReader              BufferedReader
 * Writer           FileWriter              BufferedWriter(flush())
 */
public class FileInputStreamTest {
	public static void main(String[] args) throws IOException {
		//test1();
		//test3();
		test4();
	}
	
	public static void test1() throws IOException{
		//1,创建File对象
		File file=new File("hello.txt");
		//2,创建一个FileInputStream的对象
		FileInputStream fis=new FileInputStream(file);
		//3,调用FileInputStream的方法，实现File文件的读取
		int b=fis.read();
		while(b !=-1){
			System.out.println((char)b);
			b=fis.read();
		}
		//4,关闭流
		fis.close();
	}
	
	public static void test2(){
		//1,创建File对象
		//2,创建一个FileInputStream的对象
		FileInputStream fis=null;
		try {
			File file=new File("hello.txt");
			fis = new FileInputStream(file);
			//3,调用FileInputStream的方法，实现File文件的读取
			int b;
			while((b=fis.read()) !=-1){
				System.out.println((char)b);
				b=fis.read();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//4,关闭流
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void test3(){
		//2,创建一个FileInputStream的对象
		FileInputStream fis=null;
		try {
			//1,创建File对象
			File file=new File("hello.txt");
			fis = new FileInputStream(file);
			//3,调用FileInputStream的方法，实现File文件的读取
			byte[] b=new byte[5];
			int len=fis.read(b);
			while(len !=-1){
//				for(int i=0;i<len;i++){
//					System.out.println((char)b[i]);
//				}
//				len=fis.read(b);
				
//				for(int i=0;i<b.length;i++){
//					System.out.println((char)b[i]);
//				}
//				len=fis.read(b);
				String str=new String(b, 0, len);
				len=fis.read(b);
				System.out.println(str);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//4,关闭流
			if(fis !=null){
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		}
	
	}
	public static void test4(){
		File file=new File("WebContent\\backbone\\view.html");
		System.out.println(file.exists());
	}
}
