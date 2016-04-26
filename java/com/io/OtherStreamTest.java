package com.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
/*
 * 转换流的使用
 * 输入流 systom.in
 */
public class OtherStreamTest {
	public static void main(String[] args) {
		//test1();
		test2();
	}
	public static void test1(){
		File file1=new File("file\\reader.txt");
		BufferedReader br=null;
		try {
			FileInputStream fis=new FileInputStream(file1);
			InputStreamReader isr=new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);
			String str;
			while((str=br.readLine())!=null){
				System.err.println(str);
			}
		}catch (IOException e) {
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
	
	public static void test2(){
		BufferedReader br=null;
		try {
			InputStream is=System.in;
			InputStreamReader isr=new InputStreamReader(is);
			br = new BufferedReader(isr);
			while(true){
				System.out.println("请输入字符串");
				System.out.println(br.readLine());
			}
		}catch (IOException e) {
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
