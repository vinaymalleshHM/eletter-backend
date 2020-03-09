package com.tyss.eletter.servicetest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tyss.eletter.dao.ELetterDAO;
import com.tyss.eletter.dto.LetterInfoBean;

@SpringBootTest
class ELetterDAOtest {

	@Autowired
	private ELetterDAO dao;

	LetterInfoBean infoBean ; 

	@BeforeEach
	void createELetterObject() {
		infoBean = new LetterInfoBean();
	}

	@Test
	void testAddLetterInformationWithNull() {
		infoBean = null;
		assertThrows(NullPointerException.class, ()->{
			dao.addLetterInformation(infoBean);
		});
	}

	@Test
	void testAddLetterInformationWithValidData() {
		LocalDateTime dateTime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40);
		List<String> toEmail = new LinkedList<String>();
		toEmail.add("asdf@gmail.com");
		toEmail.add("ghjk@gmail.com");
		toEmail.add("qwer@gmail.com");
		LetterInfoBean infoBean = new LetterInfoBean();
		infoBean.setGeneratorEmpId("TYC456");
		infoBean.setGeneratedDate(dateTime);
		infoBean.setMailSentTime(dateTime);
		infoBean.setToEmail(toEmail);
		infoBean.setTypeOfLetter("HRLetter");
		try {
			assertNotNull(dao.addLetterInformation(infoBean));
		} catch (Exception e) {
			for (StackTraceElement element : e.getStackTrace()) {
				System.out.println(element.toString());
			}
		}
	}

	@Test
	void testSearchWithNull() {
		String name = "abc123";
		try {
			boolean actual = dao.search(name).isEmpty();
			boolean expected = true;
			assertEquals(expected , actual);
		} catch (Exception e) {
			for (StackTraceElement element : e.getStackTrace()) {
				System.out.println(element.toString());
			}
		}
	}

	@Test
	void testSearchWithValidData() {
		String name = "tyc123";
		try {
			boolean actual = dao.search(name).isEmpty();
			boolean expected = false;
			assertEquals(expected, actual);
		} catch (Exception e) {
			for (StackTraceElement element : e.getStackTrace()) {
				System.out.println(element.toString());
			}
		}
	}

	void testdeleteLetterInformationWithNotValidId() {
		int id = 1;
		try {
			boolean actual = dao.deleteLetterInformation(id);
			boolean expected = true;
			assertEquals(expected, actual);
		} catch (Exception e) {
			for (StackTraceElement element : e.getStackTrace()) {
				System.out.println(element.toString());
			}
		}
	}
}
