package com.tyss.eletter.service;

import java.util.List;

import com.tyss.eletter.dto.LetterInfoBean;
import com.tyss.eletter.dto.TimeTest;

public interface ELetterService {
	
	boolean addLetterInformation(LetterInfoBean letterInfoBean);
	
	List<LetterInfoBean> search(String name);
	
	boolean deleteLetterInformation(int  id);
	
	boolean addTestTime(TimeTest test);
}
