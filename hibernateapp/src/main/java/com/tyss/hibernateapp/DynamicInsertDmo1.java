package com.tyss.hibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DynamicInsertDmo1 {
	public static void main(String[] args) {
		EntityManagerFactory factory = null;
		EntityManager manager=null;
		EntityTransaction transaction=null;
		try {
			factory = Persistence.createEntityManagerFactory("test");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			String jpql = "insert into movie_info values (:id,:name,:rating)";
			Query query = manager.createNativeQuery(jpql);
			query.setParameter("id", 5);
			query.setParameter("name", "akaaka");
			query.setParameter("rating", "bad");
			int r=query.executeUpdate();
			transaction.commit();
			System.out.println("inserted successfully");
		}catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {

			manager.close();
			factory.close();
		}
	}
}
