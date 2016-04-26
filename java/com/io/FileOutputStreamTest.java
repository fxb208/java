package com.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
	public static void main(String[] args) {
		//test1();
		//test2();
		long start=System.currentTimeMillis();
		fileCopy("file\\1.CHM", "file\\2.CHM");
		long end=System.currentTimeMillis();
		System.out.println(end-start);//454
	}
	public static void test1(){
		/*1,创建File对象，输出的file文件可以不存在，当执行过程中，若不存在可以自动创建
		 * 若存在，则覆盖
		 */
		File file=new File("hello1.txt");
		FileOutputStream fos=null;
		try {
			//2,创建FileOutputStream对象
			fos = new FileOutputStream(file);
			//3,写入操作
			fos.write(new String("hello world").getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//4,关闭流
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void test2(){
		File file1=new File("hello.txt");
		File file2=new File("hello2.txt");
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			fis = new FileInputStream(file1);	
			fos = new FileOutputStream(file2);
			byte[] b=new byte[10];
			int len;
			while((len=fis.read(b))!=-1){
//				for(int i=0;i<len;i++){
//					fos.write(b[i]);
//				}
				fos.write(b, 0, len);
			};
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	
	public static void fileCopy(String src,String dest){
		File file1=new File(src);
		File file2=new File(dest);
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			fis = new FileInputStream(file1);	
			fos = new FileOutputStream(file2);
			byte[] b=new byte[1024];
			int len;
			while((len=fis.read(b))!=-1){
				fos.write(b, 0, len);
			};
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
}
