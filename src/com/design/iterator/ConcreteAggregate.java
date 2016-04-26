package com.design.iterator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteAggregate implements Aggregate{
	private List list=new ArrayList<>();
	@Override
	public void add(Object object) {
		// TODO Auto-generated method stub
		list.add(object);
	}

	@Override
	public void remove(Object object) {
		// TODO Auto-generated method stub
		list.remove(object);
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new ConcreteIterator(list);
	}

}
