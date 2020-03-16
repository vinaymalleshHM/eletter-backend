package com.tyss.eletter.dao;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tyss.eletter.dto.LetterInfoBean;
import com.tyss.eletter.dto.TimeTest;

public interface ELetterDAO {

	boolean addLetterInformation(LetterInfoBean letterInfoBean);
	
	List<LetterInfoBean> search(String name);
	
	boolean deleteLetterInformation(int id);
	
	
	boolean addTestTime(TimeTest test);
}
