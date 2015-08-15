package com.v2tech.surveyManagement.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.v2tech.surveysystem.common.SurveyGenericException;
import com.v2tech.surveysystem.domain.DoubleQuestionAnswer;
import com.v2tech.surveysystem.domain.QuestionAnswer;
import com.v2tech.surveysystem.domain.SurveySession;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:appContext.xml"})
@Transactional
public class TestSurveySessionService {
	@Autowired
	com.v2tech.surveysystem.service.SurveySessionService surveySessionService;
	
	@Test
	@Rollback(value=false)
	public void testCreateSurveySessions(){
		try {
			SurveySession surveySession1 = new SurveySession();
			surveySession1.setEmail("jatinsut@yahoo.com");
			surveySession1.setUser("Jatin Sutaria");
			surveySession1.setSurveyCompleted(false);
			surveySession1.setSurveyType("Manager");
			QuestionAnswer questionAnswer1= new QuestionAnswer();
			questionAnswer1.setQuestion("Where is India?");
			questionAnswer1.setAnswer("Asia");
			
			QuestionAnswer questionAnswer2= new QuestionAnswer();
			questionAnswer2.setQuestion("Where is Nambia?");
			questionAnswer2.setAnswer("Africa");
			DoubleQuestionAnswer doubleQuestionAnswer = new DoubleQuestionAnswer();
			doubleQuestionAnswer.setQuestionAnswer1(questionAnswer1);
			doubleQuestionAnswer.setQuestionAnswer2(questionAnswer2);
			
			List<DoubleQuestionAnswer> questionAnswers = new ArrayList<DoubleQuestionAnswer>();
			questionAnswers.add(doubleQuestionAnswer);
			
			surveySession1.setDoubleQuestionAnswers(questionAnswers);
			surveySession1 = (SurveySession) surveySessionService.saveOrUpdate(surveySession1);
		} catch (SurveyGenericException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
