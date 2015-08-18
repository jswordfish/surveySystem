package com.v2tech.surveysystem.util;

import org.apache.commons.mail.EmailException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.v2tech.surveysystem.domain.SurveySession;
import com.v2tech.surveysystem.service.servicehelpers.email.EmailService;

public class EmailThread implements Runnable{
	Logger logger = LoggerFactory.getLogger(EmailThread.class);
	SurveySession surveySession;
	public EmailThread(SurveySession surveySession){
		this.surveySession = surveySession;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			EmailService.sendEmail(surveySession);
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String admin = UtilService.getValue("adminEmailToSentTo");
			logger.error("Problem in sending email to "+surveySession.getEmail() +" "+admin, e);
		}
	}

}
