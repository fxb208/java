package com.generic;

import java.util.ArrayList;
import java.util.List;
/*
 * 自定义泛型类
 */
public class Order<T> {
	private String orderName;
	private String orderId;
	private T t;
	List<T> list=new ArrayList<T>();
	public void add(){
		list.add(t);
	}
	//声明泛型方法
	public <E>E getE(E e){
		return e;
	}
	//实现数组到集合的复制
	public <E> List<E> fromArrayToList(E[] e,List<E> list){
		for(E e1:e){
			list.add(e1);
		}
		return list;
	}
	@Override
	public String toString() {
		return "Order [orderName=" + orderName + ", orderId=" + orderId
				+ ", t=" + t + ", list=" + list + "]";
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	
}
//继承泛型类时或接口时，可以指明泛型的类型
class SubOrder extends Order<Integer>{
	
}
