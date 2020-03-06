package com.tyss.eletter.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tyss.eletter.dto.LetterInfoBean;

@Repository
public class ELetterDAOImpl implements ELetterDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;


	@Override
	public LetterInfoBean addLetterInformation(LetterInfoBean letterInfoBean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		letterInfoBean.setActive(true);
		manager.persist(letterInfoBean);
		transaction.commit();
		return letterInfoBean;
		
	}



	@Override
	public List<LetterInfoBean> search(String empId) {
		EntityManager manager = factory.createEntityManager();
		String jpql ="from LetterInfoBean where generatorEmpId=:empId";
		TypedQuery< LetterInfoBean>  query = manager.createQuery(jpql, LetterInfoBean.class);
		query.setParameter("empId", empId);
		System.out.println(query);
		System.out.println(query.getResultList());
		return query.getResultList();
	}


	
	@Override
	public boolean deleteLetterInformation(int id) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		LetterInfoBean record = manager.find(LetterInfoBean.class, id);
		if (record!=null) {
			record.setActive(false);
			transaction.commit();
			return true;
			
		} else {
			return false;
		}
	}



}
