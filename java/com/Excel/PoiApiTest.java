package com.Excel;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
//参考：http://my.oschina.net/zimingforever/blog/101142
public class PoiApiTest {
	public static void main(String[] args) {
	//	test01();
		test02();
	}
	public static void test01(){
		List<Judge> judges=new ArrayList<>();
		Judge judge=new Judge();
		String fileName=ClassLoader.getSystemResource("fg.xls").getPath(); // Excel文件所在路径  
        File file = new File(fileName); // 创建文件对象  
        FileInputStream fis=null;
        try {
        	fis=new FileInputStream(file);
			POIFSFileSystem ts= new POIFSFileSystem(fis);
			HSSFWorkbook wb=new HSSFWorkbook(ts);
			HSSFSheet sh= wb.getSheetAt(0);
			HSSFRow ro=null;
			for (int i = 1; sh.getRow(i)!=null; i++) { // 循环打印Excel表中的内容  
				ro=sh.getRow(i);
			    for (int j = 0; ro.getCell(j)!=null; j++) {  
			        if(j==0){
			        	judge.setName(ro.getCell(j)+"");
			        }else if(j==1){
			        	judge.setDepartment(ro.getCell(j)+"");
			        }else if(j==2){
			        	judge.setPhone(ro.getCell(j)+"");
			        }
			    }  
			    judges.add(judge); 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        System.out.println(judges.size());
	}
	
	
	public static void test02(){
		List<Judge> judges=new ArrayList<>();
		Judge judge=new Judge();
		InputStream is=ClassLoader.getSystemResourceAsStream("fg.xls"); // Excel文件所在路径  
        try {
			POIFSFileSystem ts= new POIFSFileSystem(is);
			HSSFWorkbook wb=new HSSFWorkbook(ts);
			HSSFSheet sh= wb.getSheetAt(0);
			HSSFRow ro=null;
			for (int i = 1; sh.getRow(i)!=null; i++) { // 循环打印Excel表中的内容  
				ro=sh.getRow(i);
			    for (int j = 0; ro.getCell(j)!=null; j++) {  
			        if(j==0){
			        	judge.setName(ro.getCell(j)+"");
			        }else if(j==1){
			        	judge.setDepartment(ro.getCell(j)+"");
			        }else if(j==2){
			        	judge.setPhone(ro.getCell(j)+"");
			        }
			    }  
			    judges.add(judge); 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        System.out.println(judges);
	}
}
