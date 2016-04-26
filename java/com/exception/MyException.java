package com.exception;
/*
 * 自定义异常类
 * 1,继承现有的异常类
 * 2，提供唯一的序列号
 */
public class MyException extends Exception{
	static final long serialVersionUID = -70347190745766939L;
	public MyException() {
	}

	public MyException(String message) {
		super(message);
	}

}
