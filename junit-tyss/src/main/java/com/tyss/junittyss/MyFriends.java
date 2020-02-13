package com.tyss.junittyss;

import java.util.ArrayList;

public class MyFriends {

	private ArrayList<String> a1 = new ArrayList<String>();
	
	public MyFriends() {
		a1.add("DQ");
		a1.add("MESSI");
		a1.add("CR");
		a1.add("NJR");
	}
	
	
	public String getName() {
		if(a1.size() == 0) {
			return null;
		}else {
			return a1.remove(0);
		}
	}
}
