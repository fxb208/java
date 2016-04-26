package com.Excel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
//参考：http://blog.csdn.net/tkd03072010/article/details/6692366
public class JexcelApiTest {
	public static void main(String[] args) throws BiffException, IOException {
		test01();
	}
	public static void test01() throws IOException, BiffException{
		List<Judge> judges=new ArrayList<>();
		Judge judge=new Judge();
		
		String fileName=ClassLoader.getSystemResource("fg.xls").getPath(); // Excel文件所在路径  
        File file = new File(fileName); // 创建文件对象  
        Workbook wb = Workbook.getWorkbook(file); // 从文件流中获取Excel工作区对象（WorkBook）  
        Sheet sheet = wb.getSheet(0); // 从工作区中取得页（Sheet）  
         
        for (int i = 1; i < sheet.getRows(); i++) { // 循环打印Excel表中的内容  
            for (int j = 0; j < sheet.getColumns(); j++) {  
                Cell cell = sheet.getCell(j, i); 
                if(j==0){
                	judge.setName(cell.getContents());
                }else if(j==1){
                	judge.setDepartment(cell.getContents());
                }else if(j==2){
                	judge.setPhone(cell.getContents());
                }
            }  
            judges.add(judge); 
        }
        System.out.println(judges.size());
	}
}
