package com.compare;

import java.util.Comparator;

public class UserComparator implements Comparator<User>{

	@Override
	public int compare(User arg0, User arg1) {
		// TODO Auto-generated method stub
		return arg0.getAge()-arg1.getAge();
	}

}
