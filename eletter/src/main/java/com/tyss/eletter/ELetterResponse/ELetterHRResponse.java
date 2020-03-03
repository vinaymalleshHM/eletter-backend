package com.tyss.eletter.ELetterResponse;

import java.util.List;

import com.tyss.eletter.dto.LetterInfoBean;

import lombok.Data;

@Data
public class ELetterHRResponse {
	
	private int status;
	private String message;
	private String description;
	private List<LetterInfoBean> letterInfoBeans;

}
