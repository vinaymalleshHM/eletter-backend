package com.tyss.eletter.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.eletter.dto.LetterInfoBean;
import com.tyss.eletter.dto.TimeTest;

@Repository
public class ELetterDAOImpl implements ELetterDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;


	@Override
	public boolean addLetterInformation(LetterInfoBean letterInfoBean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		letterInfoBean.setActive(true);
		manager.persist(letterInfoBean);
		transaction.commit();
		return true;
		
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



	@Override
	public boolean addTestTime(TimeTest test) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(test);
		transaction.commit();
		return true;
	}



}
