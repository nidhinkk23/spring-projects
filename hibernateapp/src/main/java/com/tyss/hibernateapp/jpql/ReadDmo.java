package com.tyss.hibernateapp.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.hibernateapp.dto.Movie;

public class ReadDmo {
	public static void main(String[] args) {
		EntityManagerFactory factory = null;
		EntityManager manager=null;
		
		factory = Persistence.createEntityManagerFactory("test");
		manager = factory.createEntityManager();
		String jpql = "select m from Movie m";
		Query query = manager.createQuery(jpql);
		List<Movie> record = query.getResultList();
		for (Movie movie : record) {
			System.out.println(movie.getId());
			System.out.println(movie.getName());
			System.out.println(movie.getRating());
		}
	}
}
