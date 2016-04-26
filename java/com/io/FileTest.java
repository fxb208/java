package com.io;

import java.io.File;
import java.net.URL;

public class FileTest {
	public static void main(String[] args) {
		Filetest();
	}
	public static void Filetest(){
		String uri=ClassLoader.getSystemResource("db.properties").getPath();
		File file=new File(uri);
		System.out.println(file.exists());
		System.out.println(file.canRead());
		System.out.println(file.isDirectory());
		System.out.println(file.getName());
		System.out.println(file.getPath());
		System.out.println(file.lastModified());
		System.out.println(file.mkdir());
	}
}
