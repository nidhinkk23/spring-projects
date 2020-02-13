package com.tyss.myproperties.common;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class FirstPropertyFile {
	public static void main(String[] args) {
		
		try {
			FileOutputStream stream = new FileOutputStream("first.properties");
			Properties pro =new Properties();
			pro.setProperty("name", "messi");
			pro.setProperty("mobile", "8592046871");
			pro.store(stream,"new file");
			System.out.println("done");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}//End of the method
}//End of the class
