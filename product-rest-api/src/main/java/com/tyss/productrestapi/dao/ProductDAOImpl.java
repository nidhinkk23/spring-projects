package com.tyss.productrestapi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.tyss.productrestapi.dto.ProductInfoBean;

import lombok.extern.java.Log;


@Log
@Repository
public class ProductDAOImpl implements ProductDAO {


	@PersistenceUnit
	private EntityManagerFactory factory;

	@Autowired
	private BCryptPasswordEncoder encoder;


	@Override
	public boolean addProduct(ProductInfoBean bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(bean);
			transaction.commit();
			return true;

		} catch (Exception e) {
			log.info(e.getMessage());

			for (StackTraceElement element : e.getStackTrace()) {
				log.info(e.toString());
			}

			return false;

		}

	}

	@Override
	public boolean removeProduct(int id) {

		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		ProductInfoBean bean = manager.find(ProductInfoBean.class, id);
		manager.remove(bean);
		transaction.commit();
		return true;

	}

	@Override
	public boolean updateProduct(ProductInfoBean bean) {

		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		ProductInfoBean infoBean = manager.find(ProductInfoBean.class, bean.getId());


		infoBean.setName(bean.getName());
		infoBean.setImageUrl(bean.getImageUrl());
		infoBean.setPrice(bean.getPrice());
		infoBean.setQuantity(bean.getQuantity());
		infoBean.setDescription(bean.getDescription());


		manager.persist(infoBean);
		transaction.commit();

		return true;
	}

	@Override
	public List<ProductInfoBean> getProductByName(String name) {
		
		String jpql = "select p from ProductInfoBean p where p.name=:name";
		EntityManager manager = factory.createEntityManager();

		TypedQuery<ProductInfoBean> query = 
				manager.createQuery(jpql,ProductInfoBean.class);


		query.setParameter("name", name);

		return query.getResultList();
	}

	@Override
	public List<ProductInfoBean> getAllProduct() {
		
		String jpql = "select p from ProductInfoBean p";
		EntityManager manager = factory.createEntityManager();

		TypedQuery<ProductInfoBean> query = 
				manager.createQuery(jpql,ProductInfoBean.class);


		return query.getResultList();
	}

}
