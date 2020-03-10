package com.tyss.eletter.servicetest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.junit.Before;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.tyss.eletter.dao.ELetterDAOImpl;
import com.tyss.eletter.dto.LetterInfoBean;
import com.tyss.eletter.service.ELetterServiceImpl;
@SpringBootTest
class TestService {

	@InjectMocks
	ELetterServiceImpl serviceImpl;

	@Mock
	ELetterDAOImpl daoImpl;

	@PersistenceUnit
	private EntityManagerFactory factory;


	@Before
	void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testSearchByGeneratoreId() {
		List<String> toEmail = new LinkedList<String>();
		toEmail.add("test1@gmail.com");
		toEmail.add("test2@gmail.com");
		toEmail.add("test3@gmail.com");

		LetterInfoBean bean = new LetterInfoBean();
		bean.setGeneratorEmpId("tyc123");
		bean.setGeneratedDate(LocalDateTime.of(2016, Month.NOVEMBER, 15, 12, 9, 13) );
		bean.setSequenceNumber(1);
		bean.setToEmail(toEmail);
		bean.setTypeOfLetter("HRletter");
		bean.setMailSentTime(LocalDateTime.of(2020, Month.MARCH, 03, 10, 17, 28) );

		LetterInfoBean bean1 = new LetterInfoBean();
		bean1.setGeneratorEmpId("tyc123");
		bean1.setGeneratedDate(LocalDateTime.of(2016, Month.NOVEMBER, 15, 12, 9, 13) );
		bean1.setSequenceNumber(2);
		bean1.setToEmail(toEmail);
		bean1.setTypeOfLetter("HRletter");
		bean1.setMailSentTime(LocalDateTime.of(2020, Month.MARCH, 03, 10, 17, 28) );

		LetterInfoBean bean2 = new LetterInfoBean();
		bean2.setGeneratorEmpId("tyc123");
		bean2.setGeneratedDate(LocalDateTime.of(2016, Month.NOVEMBER, 15, 12, 9, 13) );
		bean2.setSequenceNumber(3);
		bean2.setToEmail(toEmail);
		bean2.setTypeOfLetter("HRletter");
		bean2.setMailSentTime(LocalDateTime.of(2020, Month.MARCH, 03, 10, 17, 28) );

		List<LetterInfoBean> list = new LinkedList<LetterInfoBean>();
		list.add(bean);
		list.add(bean1);
		list.add(bean2);
		when(daoImpl.search("tyc123")).thenReturn(list);

		List<LetterInfoBean> letterList = serviceImpl.search("tyc123");

		assertEquals(3, letterList.size());
	}
	
	
	@Test
	void testSearchByGeneratoreIdNull() {
		LetterInfoBean bean1 = new LetterInfoBean();
		LetterInfoBean bean2 = new LetterInfoBean();
		LetterInfoBean bean3 = new LetterInfoBean();
		List<LetterInfoBean> list = new LinkedList<LetterInfoBean>();
		list.add(bean3);
		list.add(bean1);
		list.add(bean2);

		when(daoImpl.search(null)).thenReturn(list);

		List<LetterInfoBean> letterList = serviceImpl.search(null);
		System.out.println("letterList.isEmpty() "+letterList.isEmpty());
		System.out.println("list.isEmpty() "+list.isEmpty());
		assertEquals(!list.isEmpty(),!letterList.isEmpty());
	}

	@Test
	void testAddLetterInformation() {
		List<String> toEmail = new LinkedList<String>();
		toEmail.add("rohan1@gmail.com");
		toEmail.add("rohan2@gmail.com");
		toEmail.add("rohan3@gmail.com");

		LetterInfoBean bean = new LetterInfoBean();
		bean.setGeneratorEmpId("roh123");
		bean.setGeneratedDate(LocalDateTime.of(2016, Month.NOVEMBER, 15, 12, 9, 13) );
		bean.setSequenceNumber(1);
		bean.setToEmail(toEmail);
		bean.setTypeOfLetter("HRletter");
		bean.setMailSentTime(LocalDateTime.of(2020, Month.MARCH, 03, 10, 17, 28) );
		boolean expected = true;
		when(daoImpl.addLetterInformation(bean)).thenReturn(expected);
		boolean actual = serviceImpl.addLetterInformation(bean);
		assertEquals(expected, actual);
	}

	@Test
	void testAddLetterInformationWithNull() {
		LetterInfoBean bean = null;
		boolean expected = false;
		when(daoImpl.addLetterInformation(bean)).thenReturn(expected);
		boolean actual = serviceImpl.addLetterInformation(bean);
		assertEquals(expected, actual);
	}

	@Test
	void testDeleteLetterInformation() {
		List<String> toEmail = new LinkedList<String>();
		toEmail.add("rohan1@gmail.com");
		toEmail.add("rohan2@gmail.com");
		toEmail.add("rohan3@gmail.com");

		LetterInfoBean bean = new LetterInfoBean();
		bean.setGeneratorEmpId("roh123");
		bean.setGeneratedDate(LocalDateTime.of(2016, Month.NOVEMBER, 15, 12, 9, 13) );
		bean.setSequenceNumber(5);
		bean.setToEmail(toEmail);
		bean.setTypeOfLetter("HRletter");
		bean.setMailSentTime(LocalDateTime.of(2020, Month.MARCH, 03, 10, 17, 28) );

		boolean expected = true;
		when(daoImpl.deleteLetterInformation(1)).thenReturn(expected);
		boolean actual = serviceImpl.deleteLetterInformation(1);
		assertEquals(expected, actual);
	} 

	@Test
	void testDeleteLetterInformationNagativeId() {
		List<String> toEmail = new LinkedList<String>();
		toEmail.add("rohan1@gmail.com");
		toEmail.add("rohan2@gmail.com");
		toEmail.add("rohan3@gmail.com");

		LetterInfoBean bean = new LetterInfoBean();
		bean.setGeneratorEmpId("roh123");
		bean.setGeneratedDate(LocalDateTime.of(2016, Month.NOVEMBER, 15, 12, 9, 13) );
		bean.setSequenceNumber(-1);
		bean.setToEmail(toEmail);
		bean.setTypeOfLetter("HRletter");
		bean.setMailSentTime(LocalDateTime.of(2020, Month.MARCH, 03, 10, 17, 28) );
		boolean expected = false;
		when(daoImpl.deleteLetterInformation(-1)).thenReturn(expected);
		boolean actual = serviceImpl.deleteLetterInformation(-1);
		assertEquals(expected, actual);
	}
}
