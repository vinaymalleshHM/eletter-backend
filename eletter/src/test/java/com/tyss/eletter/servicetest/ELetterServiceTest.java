package com.tyss.eletter.servicetest;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import com.tyss.eletter.ELetterResponse.ELetterGenericResponse;
import com.tyss.eletter.ELetterResponse.ELetterResponse;
import com.tyss.eletter.ELetterResponse.ELetterResponseRes;
import com.tyss.eletter.dao.ELetterDAO;
import com.tyss.eletter.dto.LetterInfoBean;
import com.tyss.eletter.service.ELetterService;

@SpringBootTest
public class ELetterServiceTest {

	@Autowired
	private ELetterService service;

	@MockBean
	private ELetterDAO dao;

	private LetterInfoBean bean = new LetterInfoBean();

	@Before
	void createELetterObject() {
		LocalDateTime dateTime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40);
		List<String> toEmail = new LinkedList<String>();
		toEmail.add("asdf@gmail.com");
		toEmail.add("ghjk@gmail.com");
		toEmail.add("qwer@gmail.com");
		bean.setGeneratorEmpId("TYC123");
		bean.setGeneratedDate(dateTime);
		bean.setMailSentTime(dateTime);
		bean.setToEmail(toEmail);
		bean.setTypeOfLetter("HRLetter");
		bean.setActive(true);
	}

	@Test
	void testAddLetterInformationWithValidData() {
		LocalDateTime dateTime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40);
		List<String> toEmail = new LinkedList<String>();
		toEmail.add("asdf@gmail.com");
		toEmail.add("ghjk@gmail.com");
		toEmail.add("qwer@gmail.com");
		bean.setGeneratorEmpId("TYC123");
		bean.setGeneratedDate(dateTime);
		bean.setMailSentTime(dateTime);
		bean.setToEmail(toEmail);
		bean.setTypeOfLetter("HRLetter");
		bean.setActive(true);
		when(dao.addLetterInformation(bean)).thenReturn(bean);
		LetterInfoBean  actualResponse = service.addLetterInformation(bean);
		ELetterResponse expectedResponse = ELetterResponseRes.fillerSuccess("");
		expectedResponse.setData(bean);
		try {
			assertEquals(expectedResponse, actualResponse);
		} catch (Exception e) {
			for (StackTraceElement element : e.getStackTrace()) {
				System.out.println(element.toString());
			}
		}
	}


}
