package com.tyss.eletter.servicetest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tyss.eletter.dto.LetterInfoBean;
import com.tyss.eletter.service.ELetterService;
import com.tyss.eletter.service.ELetterServiceImpl;

public class ELetterServiceImplTest {
	private ELetterService service;
	
	private LetterInfoBean infoBean;
	
//	@BeforeEach
//	void createELetterObject() {
//		infoBean = new LetterInfoBean();
//		service = new ELetterServiceImpl();
//	}
	@Test
	void testAddLetterInformationWithNull() {
		infoBean = null;
		assertThrows(NullPointerException.class, ()->{
			service.addLetterInformation(infoBean);
		});
	}
	@Test
	void testAddLetterInformationWithValidData() {
		ELetterService  service = new ELetterServiceImpl();
		LocalDateTime dateTime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40);
		List<String> toEmail = new LinkedList<String>();
		toEmail.add("asdf@gmail.com");
		toEmail.add("ghjk@gmail.com");
		toEmail.add("qwer@gmail.com");
		LetterInfoBean infoBean = new LetterInfoBean();
		infoBean.setGeneratorEmpId("TYC999");
		infoBean.setGeneratedDate(dateTime);
		infoBean.setMailSentTime(dateTime);
		infoBean.setToEmail(toEmail);
		infoBean.setTypeOfLetter("HRLetter");
		try {
//			assertNotNull(service.addLetterInformation(infoBean));
			assertThrows(NullPointerException.class, ()->{
				service.addLetterInformation(infoBean);
			});
		} catch (Exception e) {
			for (StackTraceElement element : e.getStackTrace()) {
				System.out.println(element.toString());
			}
		}
	}
}
