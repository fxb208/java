package com.exception;

public class EcmDef {
	public static void main(String[] args) {
		try {
			int i=Integer.parseInt(args[0]);
			int j=Integer.parseInt(args[1]);
			ecm(i,j);
		} catch (NumberFormatException e) {
			System.out.println("类型转换异常");
			// TODO Auto-generated catch block
		} catch(ArrayIndexOutOfBoundsException e){
			System.out.println("缺少命令行参数");
		} catch(ArithmeticException e){
			System.out.println("分母为0了");
		} catch (EcDefException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	public static void ecm(int i,int j) throws EcDefException{
		if(i<0||j<0){
			throw new EcDefException("输入的参数存在负数");
		}
		System.out.println(i/j);
	}
}

class EcDefException extends Exception{
	private static final long serialVersionUID = 1L;
	public EcDefException(){
		
	}
	public EcDefException(String msg){
		super(msg);
	}
}
