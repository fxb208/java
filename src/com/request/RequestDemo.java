package com.request;

import com.github.kevinsawicki.http.HttpRequest;

//http://kevinsawicki.github.io/http-request/
public class RequestDemo {
	public static void main(String[] args) {
//		int response = HttpRequest.get("http://www.baidu.com").code();
//		System.out.println(response);
		contentTypeTest();
		getBodyTest();
	}
	
	public static void contentTypeTest(){
		String contentType = HttpRequest.get("http://www.baidu.com")
                .accept("application/json") //Sets request header
                .contentType(); //Gets response header
		System.out.println("Response content type was " + contentType);
	}
	
	public static void getBodyTest(){
		String response = HttpRequest.get("http://www.baidu.com").body();
		System.out.println("Response was: " + response);
	}
}
