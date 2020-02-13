package com.tyss.junittyss;

public class MyRestService {
	
	public String getStudentName() {
		return "Nived";
	}
	
	public String getTeacherName() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "MESSI";
	}
}
