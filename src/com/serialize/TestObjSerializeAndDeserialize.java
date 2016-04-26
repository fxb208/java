package com.serialize;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class TestObjSerializeAndDeserialize {
	public static void main(String[] args) {
		
	}
	public static void SerializePerson() throws Exception{
		Person person=new Person();
		person.setName("fxb");
		person.setAge(26);
		person.setSex("male");
		File file=new File("");
		OutputStream out=new FileOutputStream(file);
		ObjectOutputStream obStream=new ObjectOutputStream(out);
		obStream.writeObject(person);
	}
}
