package com.tyss.eletter.ELetterResponse;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ELetterGenericResponse {
	
	private boolean error;
	private Object data;
	private String message;

}
