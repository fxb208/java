package com.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * FileReader,FileWriter只能处理文本文件
 * 对于非文本文件，只能试用字节流
 *
 */
public class FileReaderTest {
	public static void main(String[] args) {
		//test1();
		test2();
	}
	public static void test1(){
		File file=new File("reader.txt");
		FileReader fr=null;
		try {
			fr = new FileReader(file);
			int c;
			while((c=fr.read())!=-1){
				System.out.println((char)c);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fr!=null){
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void test2(){
		File file1=new File("file\\reader.txt");
		File file2=new File("file\\reader1.txt");
		FileReader fr=null;
		FileWriter fw=null;
		try {
			fr = new FileReader(file1);
			fw = new FileWriter(file2);
			char[] c=new char[5];
			int len;
			while((len=fr.read(c))!=-1){
				fw.write(c, 0, len);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fr!=null){
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fw!=null){
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
}
