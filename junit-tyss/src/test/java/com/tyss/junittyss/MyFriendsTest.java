package com.tyss.junittyss;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

class MyFriendsTest {
	
	static MyFriends m =null;
	
	@BeforeAll
	static void createObjects() {
		m = new MyFriends();
	}
	
	@RepeatedTest(5)
	void getNameTest(RepetitionInfo info) {
		
		int repCount = info.getCurrentRepetition();
		
		String name = m.getName();
		if(repCount <= 4) {
			assertNotNull(name);
		}else {
			assertNull(name);
		}
	}

}
