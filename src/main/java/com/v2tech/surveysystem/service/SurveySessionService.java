package com.v2tech.surveysystem.service;

import com.v2tech.surveysystem.common.SurveyGenericException;
import com.v2tech.surveysystem.domain.SurveySession;



public interface SurveySessionService extends SurveyGenericService{
	
	public boolean isEmailPresent(String email, String surveyType)  throws SurveyGenericException;   

	public SurveySession saveOrUpdate(SurveySession surveySession)  throws SurveyGenericException;
	
}
