package com.tyss.eletter.ELetterResponse;

public class ELetterResponseRes {
	private static final int SUCCESS_STATUS_CODE = 201;
	private static final int FAILURE_STATUS_CODE = 401;
	private static final int EXCEPTION_STATUS_CODE = 501;

	private static final String SUCCESS_MESSAGE = "Success";
	private static final String FAILURE_MESSAGE = "Failure";
	private static final String EXCEPTION_MESSAGE = "Exception";
	
	
	public ELetterResponseRes() {}

	public static ELetterResponse fillerSuccess(String description) {

		return ELetterResponse.builder().statusCode(SUCCESS_STATUS_CODE).message(SUCCESS_MESSAGE).description(description)
				.build();
	}
	
	
	public static ELetterResponse fillerFailure(String description) {
		return ELetterResponse.builder().statusCode(FAILURE_STATUS_CODE).message(FAILURE_MESSAGE).description(description)
				.build();
	}
	
	public static ELetterResponse fillerException(String description) {
		return ELetterResponse.builder().statusCode(EXCEPTION_STATUS_CODE).message(EXCEPTION_MESSAGE).description(description)
				.build();
	}
}
