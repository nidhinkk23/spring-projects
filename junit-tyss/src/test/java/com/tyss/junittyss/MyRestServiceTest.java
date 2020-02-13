package com.tyss.junittyss;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class MyRestServiceTest {

	@Test
	@Timeout(value = 1000,unit = TimeUnit.MILLISECONDS)
	void getStudentNametest() {
		MyRestService service = new MyRestService();
		String name = service.getStudentName();
		assertNotNull(name);
	}
	
	
	/*
	 * @Test
	 * 
	 * @Timeout(value = 1000,unit = TimeUnit.MILLISECONDS) void getTeacherNametest()
	 * { MyRestService service = new MyRestService(); String name =
	 * service.getTeacherName(); assertNotNull(name); }
	 */

}
