package com.v2tech.surveysystem.service;

import com.v2tech.surveysystem.common.SurveyGenericException;
import com.v2tech.surveysystem.domain.SurveySession;



public interface SurveySessionService extends SurveyGenericService{

	public SurveySession saveOrUpdate(SurveySession surveySession)  throws SurveyGenericException;
	
}
