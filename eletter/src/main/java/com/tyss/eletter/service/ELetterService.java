package com.tyss.eletter.service;

import java.util.List;

import com.tyss.eletter.dto.LetterInfoBean;

public interface ELetterService {
	
	boolean addLetterInformation(LetterInfoBean hrInfoBean);
	
	List<LetterInfoBean> search(String name);
	
	boolean deleteLetterInformation(String empId);

	boolean deleteLetterInformation(int  id);
}
