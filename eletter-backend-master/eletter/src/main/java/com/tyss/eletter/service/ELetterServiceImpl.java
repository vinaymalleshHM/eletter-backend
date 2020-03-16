package com.tyss.eletter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.eletter.dao.ELetterDAO;
import com.tyss.eletter.dao.ELetterDAOImpl;
import com.tyss.eletter.dto.LetterInfoBean;
import com.tyss.eletter.dto.TimeTest;

@Service

public class ELetterServiceImpl implements ELetterService{

	@Autowired
	private ELetterDAO dao;
	
	
	
	@Override
	public boolean addLetterInformation(LetterInfoBean letterInfoBean) {
			return dao.addLetterInformation(letterInfoBean);
	}

	@Override
	public List<LetterInfoBean> search(String empId) {
		return dao.search(empId);
	}

	
	@Override
	public boolean deleteLetterInformation(int id) {
		return dao.deleteLetterInformation(id);
	}

	@Override
	public boolean addTestTime(TimeTest test) {
		return dao.addTestTime(test);
	}

}
