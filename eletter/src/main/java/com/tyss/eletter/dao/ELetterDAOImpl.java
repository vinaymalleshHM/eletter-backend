package com.tyss.eletter.dao;

import java.time.Instant;
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
	public boolean addLetterInformation(LetterInfoBean letterInfoBean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
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
		return query.getResultList();
	}


	@Override
	public boolean deleteLetterInformation(String empId) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		String jpql ="from LetterInfoBean where generatorEmpId=:empId";
		TypedQuery< LetterInfoBean>  query = manager.createQuery(jpql, LetterInfoBean.class);
		query.setParameter("empId", empId);
		LetterInfoBean bean = query.getSingleResult();
		LetterInfoBean record = manager.find(LetterInfoBean.class, bean.getSequenceNumber());
		manager.remove(record);
		transaction.commit();
		return true;
	}

	@Override
	public boolean deleteLetterInformation(int id) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		String jpql ="from LetterInfoBean where sequenceNumber=:id";
		TypedQuery< LetterInfoBean>  query = manager.createQuery(jpql, LetterInfoBean.class);
		query.setParameter("id", id);
		LetterInfoBean bean = query.getSingleResult();
		LetterInfoBean record = manager.find(LetterInfoBean.class, bean.getSequenceNumber());
		manager.remove(record);
		transaction.commit();
		return true;
	}



}
