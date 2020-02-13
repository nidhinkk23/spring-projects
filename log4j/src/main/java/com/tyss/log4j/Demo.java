package com.tyss.log4j;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Demo {
	
	static Logger log = LogManager.getLogger("dimple");
	
	public static void main(String[] args) {
		System.out.println("***************************");
		log.trace("Im trace method");
		log.debug("Im debug method");
		log.info("Im info method");
		log.warn("Im warn method");
		log.error("Im error method");
		log.fatal("Im fatal method");
		
	}
}
