package com.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DaoImpl<T> {
	Map<String, T> map=new HashMap<String, T>();
	public void save(String id,T entity){
		map.put(id, entity);
	}
	public T get(String id){
		return map.get(id);
	}
	public void update(String id,T t){
		map.put(id, t);
	}
	public List<T> list(){
		List<T> list=new ArrayList<>();
		for(String str:map.keySet()){
			list.add(map.get(str));
		}
		return list;
	}
	public void remove(String id){
		map.remove(id);
	}
}
