package com.tyss.curdhibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.curdhibernate.dto.Employee;

public class DynamicInsertDmo {
	public static void main(String[] args) {
		

		EntityManagerFactory factory = null;
		EntityManager manager=null;
		EntityTransaction transaction=null;
		try {
			factory = Persistence.createEntityManagerFactory("test");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			String jpql = "insert into employee_primary_info values (109)";
			Query query = manager.createNativeQuery(jpql);
//			query.setParameter("eid", 101);
//			query.setParameter("edob", "2007-07-11");
//			query.setParameter("edate", "2007-07-11");
			int r = query.executeUpdate();
			System.out.println("inserted successfully");
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {

			manager.close();
			factory.close();
		}

	}//End of the Method


}
