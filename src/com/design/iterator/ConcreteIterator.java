package com.design.iterator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteIterator implements Iterator{
	private List list=new ArrayList();
	private int cursor=0;
	public ConcreteIterator(List list){
		this.list=list;
	}
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(cursor==list.size()){
			return false;
		}
		return true;
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		Object object=null;
		if(this.hasNext()){
			object=this.list.get(cursor++);
		}
		return object;
	}

}
