package com.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;


public class BufferedTest {
	public static void main(String[] args) {
//		long start=System.currentTimeMillis();
//		fileCopy();
//		long end=System.currentTimeMillis();
//		System.out.println(end-start);//124
//		
		readLineTest();
	}
	public static void fileCopy(){
		//1,创建File对象
		File file1=new File("file\\1.CHM");
		File file2=new File("file\\2.CHM");
		//2，创建节点流
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		try {
			FileInputStream fis=new FileInputStream(file1);
			FileOutputStream fos=new FileOutputStream(file2);
			//3，创建缓存流
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			byte[] b=new byte[1024];
			int len;
			//4，读写操作
			while((len=bis.read(b))!=-1){
				bos.write(b, 0, len);
				bos.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭流
			if(bos!=null){
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(bis!=null){
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void readLineTest(){
		File file=new File("file\\reader.txt");
		BufferedReader br=null;
		try {
			FileReader fr=new FileReader(file);
			br = new BufferedReader(fr);
//			char[] c=new char[4];
//			int len;
//			while((len=br.read(c))!=-1){
//				System.out.println(new String(c,0,len));
//			}
			String str;
			while((str=br.readLine())!=null){
				System.out.println(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
