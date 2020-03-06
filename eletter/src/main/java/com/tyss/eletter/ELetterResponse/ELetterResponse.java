package com.tyss.eletter.ELetterResponse;

import java.util.List;

import com.tyss.eletter.dto.LetterInfoBean;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class ELetterResponse {
	private int statusCode;
	private String message;
	private String description;
	private Object data;
	private Object error;
	private List<LetterInfoBean> letterInfoBeans;

}
