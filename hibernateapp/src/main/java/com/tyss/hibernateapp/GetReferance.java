package com.tyss.hibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tyss.hibernateapp.dto.Movie;

public class GetReferance {
	public static void main(String[] args) {
		EntityManagerFactory factory = null;
		EntityManager manager=null;
		
		factory = Persistence.createEntityManagerFactory("test");
		manager = factory.createEntityManager();
//		Movie result = manager.find(Movie.class, 1);
		Movie result = manager.getReference(Movie.class, 1);
		System.out.println(result.getClass());
		System.out.println(result.getId());
		System.out.println(result.getName());
		System.out.println(result.getRating());
		
		
		manager.close();
		factory.close();
		
	}
}
