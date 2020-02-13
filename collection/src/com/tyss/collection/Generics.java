package com.tyss.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Generics {
	
	public static void main(String[] args) {
		List<Object> values = new ArrayList<>();
		values.add(7);
		values.add("hello");
		
		String i =  (String) values.get(1);
//		Iterator iterator = values.iterator();
//		while (iterator.hasNext()) {
//			System.out.println(iterator.next());
//			
//		}
//		
		for (Object object : values) {
			System.out.println(object);
		}
		
	}
	
	
}
