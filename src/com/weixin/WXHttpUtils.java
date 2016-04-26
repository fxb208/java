package com.weixin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class WXHttpUtils {
	private static Logger logger = Logger.getLogger(WXHttpUtils.class);
	//xml请求方式
	public static String xmlRequest(String url,String xml,String method){
		URL httpurl;
		try {
			httpurl = new URL(url);
			HttpURLConnection urlcon = (HttpURLConnection)httpurl.openConnection();
			urlcon.setDoOutput(true);
			urlcon.setDoInput(true);
			urlcon.setUseCaches(false);
			urlcon.setRequestProperty("Content-type","application/x-www-form-urlencoded"); 
			urlcon.setRequestMethod(method);
			urlcon.connect(); //获取连接

			OutputStream outputStream=urlcon.getOutputStream();//打开服务器的输入流
			outputStream.write(xml.getBytes("UTF-8"));//将数据写入到服务器的输出流
			outputStream.flush();
			outputStream.close();
			    
			InputStream is = urlcon.getInputStream();
			BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
			StringBuffer bs = new StringBuffer();
			String l = null;
			while((l=buffer.readLine())!=null){
				bs.append(l);
			}
			buffer.close();
			is.close();
			return bs.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("");
			return null;
		}
	
	}
		//json请求方式
	public String jsonRequest(String url,String json,String method) throws IOException{
		URL httpurl = new URL(url);
		HttpURLConnection urlcon = (HttpURLConnection)httpurl.openConnection();
		urlcon.setDoOutput(true);
		urlcon.setDoInput(true);
		urlcon.setUseCaches(false);
		urlcon.setRequestProperty("Content-type","application/x-www-form-urlencoded"); 
		urlcon.setRequestMethod(method);
		urlcon.connect(); //获取连接

		OutputStream outputStream=urlcon.getOutputStream();//打开服务器的输入流
		outputStream.write(json.getBytes("UTF-8"));//将数据写入到服务器的输出流
		outputStream.flush();
		outputStream.close();
		    
		    
		InputStream is = urlcon.getInputStream();
		BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
		StringBuffer bs = new StringBuffer();
		String l = null;
		while((l=buffer.readLine())!=null){
			bs.append(l);
		}
		buffer.close();
		is.close();
		return bs.toString();
	}
		//Map请求方式
		public static String mapRequest(String url,HashMap<String, String> map,String method) throws IOException{
			URL httpurl = new URL(url);
		    HttpURLConnection urlcon = (HttpURLConnection)httpurl.openConnection();
		    urlcon.setDoOutput(true);
		    urlcon.setDoInput(true);
		    urlcon.setUseCaches(false);
		    urlcon.setRequestProperty("Content-type","application/x-www-form-urlencoded"); 
		    urlcon.setRequestMethod(method);
		    urlcon.connect(); //获取连接
		    StringBuffer sb=new StringBuffer();      
		    if (!map.isEmpty()) {     
		        for (Map.Entry<String, String >entry:map.entrySet()) {              
		            sb.append(entry.getKey()+"=");              
		            sb.append(entry.getValue());               
		            sb.append("&");
		        }
		        sb.deleteCharAt(sb.length()-1);//删除字符串最后 一个字符“&”
		    }
		    byte[] data=sb.toString().getBytes(); 
		    OutputStream outputStream=urlcon.getOutputStream();//打开服务器的输入流
		    outputStream.write(data);//将数据写入到服务器的输出流
		    outputStream.flush();
		    
		    InputStream is = urlcon.getInputStream();
		    BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
		    StringBuffer bs = new StringBuffer();
		    String l = null;
		    while((l=buffer.readLine())!=null){
		        bs.append(l);
		    }
			return bs.toString();
		}
		
	public static String request(String url,String method){
		try {
			URL httpurl = new URL(url);
		    HttpURLConnection urlcon = (HttpURLConnection)httpurl.openConnection();
		    urlcon.setDoOutput(true);
		    urlcon.setDoInput(true);
		    urlcon.setUseCaches(false);
		    urlcon.setRequestProperty("Content-type","application/x-www-form-urlencoded"); 
		    urlcon.setRequestMethod(method);
		    urlcon.connect(); //获取连接
		    
		    InputStream is = urlcon.getInputStream();
		    BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
		    StringBuffer bs = new StringBuffer();
		    String l = null;
		    while((l=buffer.readLine())!=null){
		        bs.append(l);
		    }
		    buffer.close();
		    is.close();
			return bs.toString();
		} catch (IOException e) {
			// TODO: handle exception
			return null;
		}
			
	}

		//上传文件
		public String fileRequest(String url,byte[] fileBytes,String fileName,String method)throws Exception{
			/*
			 * 参考：
			 * http://blog.csdn.net/zj8692286/article/details/40891335
			 */
			URL httpurl = new URL(url);
		    HttpURLConnection urlcon = (HttpURLConnection)httpurl.openConnection();
		    urlcon.setDoOutput(true);
		    urlcon.setDoInput(true);
		    urlcon.setUseCaches(false);
		    urlcon.setRequestProperty("Content-type","application/x-www-form-urlencoded"); 
		//    urlcon.setRequestMethod("POST"); 
		    urlcon.setRequestMethod(method);
		    urlcon.connect(); //获取连接

		    OutputStream outputStream=urlcon.getOutputStream();//打开服务器的输入流
		    
		    String BOUNDARY = "----------" + System.currentTimeMillis();
		    // 第一部分：
		    StringBuilder sb = new StringBuilder();
		    sb.append("--"); // 必须多两道线
		    sb.append(BOUNDARY);
		    sb.append("\r\n");
		    sb.append("Content-Disposition: form-data;name=\"file\";filename=\""
		    + fileName + "\"\r\n");
		    sb.append("Content-Type:application/octet-stream\r\n\r\n");
		    sb.append("Content-Type:application/octet-stream\r\n\r\n");
		    byte[] head = sb.toString().getBytes("utf-8");
		    outputStream.write(head);
		
		    //第二部分文件写入,springMVC上传的是MultipartFile，转换为byte数组
		    outputStream.write(fileBytes);//将数据写入到服务器的输出流
		    
		    //第三部分
		    // 结尾部分
		    byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线
		    outputStream.write(foot);

		    outputStream.flush();
		    outputStream.close();
		    
		    
		    InputStream is = urlcon.getInputStream();
		    BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
		    StringBuffer bs = new StringBuffer();
		    String l = null;
		    while((l=buffer.readLine())!=null){
		        bs.append(l);
		    }
		    buffer.close();
		    is.close();
			return bs.toString();
		}
		
		public Map<String, Object> downloadRequest(String url,String method) throws Exception{
			URL httpurl = new URL(url);
		    HttpURLConnection urlcon = (HttpURLConnection)httpurl.openConnection();
		    urlcon.setDoOutput(true);
		    urlcon.setDoInput(true);
		    urlcon.setUseCaches(false);
		    urlcon.setRequestProperty("Content-type","application/x-www-form-urlencoded"); 
		    urlcon.setRequestMethod(method);
		    urlcon.connect(); //获取连接	    
		    InputStream is = urlcon.getInputStream();
		    Map<String, List<String>> header = urlcon.getHeaderFields();
		    String filename=header.get("Content-Disposition").get(0);
		    Map<String, Object> map=new HashMap<String, Object>();
		    map.put("fileName", filename.substring(filename.indexOf("\"")+1,filename.length()-1));
		    map.put("fileStream", is);
		    return map;
		}	
}
