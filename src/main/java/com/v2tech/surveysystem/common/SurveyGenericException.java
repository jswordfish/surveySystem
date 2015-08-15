package com.v2tech.surveysystem.common;

public class SurveyGenericException extends RuntimeException{

	public SurveyGenericException(){
		super();
	}
	
	public SurveyGenericException(String message){
		super(message);
	}
	
	public SurveyGenericException(String message, Throwable t){
		super(message, t);
	}

}

