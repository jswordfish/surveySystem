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
	public void testCreateSurveySessionForManagerComepetency(){
		try {
			SurveySession surveySession1 = new SurveySession();
			QuestionAnswer questionAnswer1= new QuestionAnswer();
			questionAnswer1.setQuestion("Understands how his/her goals and KPIs fit with our broader business strategy.");
			questionAnswer1.setContext("Business Perspective");
			
			QuestionAnswer questionAnswer2= new QuestionAnswer();
			questionAnswer2.setQuestion("Knows how the various functions at Colgate contribute to achieve Colgate's strategic priorities.");
			questionAnswer2.setContext("Business Perspective");
			
			QuestionAnswer questionAnswer3= new QuestionAnswer();
			questionAnswer3.setQuestion("Has a clear understanding of how Colgate delivers shareholder value, customer value and employee value.");
			questionAnswer3.setContext("Business Perspective");
			
			QuestionAnswer questionAnswer4= new QuestionAnswer();
			questionAnswer4.setQuestion("Understands how actions by his/her function can have a positive or negative impact on other functions at Colgate.");
			questionAnswer4.setContext("Business Perspective");
			
			QuestionAnswer questionAnswer5= new QuestionAnswer();
			questionAnswer5.setQuestion("Understands the competitive dynamics faced by Colgate in today's market environment.");
			questionAnswer5.setContext("Business Perspective");
			
			QuestionAnswer questionAnswer6= new QuestionAnswer();
			questionAnswer6.setQuestion("Once a problem (or opportunity) is identified he/she is able to clearly define the problem and goal statement.");
			questionAnswer6.setContext("Problem Solving");
			
			QuestionAnswer questionAnswer7= new QuestionAnswer();
			questionAnswer7.setQuestion("Can analyze the problem using multiple problem analysis tools to clearly understand the situation.");
			questionAnswer7.setContext("Problem Solving");
			
			QuestionAnswer questionAnswer8= new QuestionAnswer();
			questionAnswer8.setQuestion("Can generate multiple solutions to solve the problem.");
			questionAnswer8.setContext("Problem Solving");
			
			QuestionAnswer questionAnswer9= new QuestionAnswer();
			questionAnswer9.setQuestion("Can choose the best possible solution to resolve the problem.");
			questionAnswer9.setContext("Problem Solving");
			
			QuestionAnswer questionAnswer10= new QuestionAnswer();
			questionAnswer10.setQuestion("Can implement a solution and ensure the goal statement is obtained.");
			questionAnswer10.setContext("Problem Solving");
			
			QuestionAnswer questionAnswer11= new QuestionAnswer();
			questionAnswer11.setQuestion("Can structure his/her message in a clear and concise manner.");
			questionAnswer11.setContext("Communication Skills");
			
			QuestionAnswer questionAnswer12= new QuestionAnswer();
			questionAnswer12.setQuestion("Projects confidence when communicating through his/her voice.");
			questionAnswer12.setContext("Communication Skills");
			
			QuestionAnswer questionAnswer13= new QuestionAnswer();
			questionAnswer13.setQuestion("Projects t confidence when communicating through his/her body language.");
			questionAnswer13.setContext("Communication Skills");
			
			QuestionAnswer questionAnswer14= new QuestionAnswer();
			questionAnswer14.setQuestion("Can adapt his/her message based on the person and the situation.");
			questionAnswer14.setContext("Communication Skills");
			
			QuestionAnswer questionAnswer15= new QuestionAnswer();
			questionAnswer15.setQuestion("Is confident when influencing others to adopt his/her recommendation, initiative or ideas.");
			questionAnswer15.setContext("Influencing Skills");
			
			QuestionAnswer questionAnswer16= new QuestionAnswer();
			questionAnswer16.setQuestion("Can adapt his/her influencing approach based on his/her stakeholders and the situation.");
			questionAnswer16.setContext("Influencing Skills");
			
			QuestionAnswer questionAnswer17= new QuestionAnswer();
			questionAnswer17.setQuestion("Can take a strategic approach in terms of planning and communicating with his/her stakeholders when influencing.");
			questionAnswer17.setContext("Influencing Skills");
			
			QuestionAnswer questionAnswer18= new QuestionAnswer();
			questionAnswer18.setQuestion("Can effective utilize the knowledge, skills and experience of others when influencing his/her stakeholders.");
			questionAnswer18.setContext("Influencing Skills");
			
			QuestionAnswer questionAnswer19= new QuestionAnswer();
			questionAnswer19.setQuestion("Can follow-up with my stakeholders to ensure my ideas, recommendations and initiatives are implemented.");
			questionAnswer19.setContext("Influencing Skills");
			
			QuestionAnswer questionAnswer20= new QuestionAnswer();
			questionAnswer20.setQuestion("Has a clear understanding of his/her leadership strengths.");
			questionAnswer20.setContext("Self-Awareness");
			
			QuestionAnswer questionAnswer21= new QuestionAnswer();
			questionAnswer21.setQuestion("Has a clear understanding of his/her development areas.");
			questionAnswer21.setContext("Self-Awareness");
			
			QuestionAnswer questionAnswer22= new QuestionAnswer();
			questionAnswer22.setQuestion("Is aware of his/her leadership and communication style and the impact it has on others in the organization.");
			questionAnswer22.setContext("Self-Awareness");
			
			QuestionAnswer questionAnswer23= new QuestionAnswer();
			questionAnswer23.setQuestion("Understands how he/she want to be seen by others in the organization. ");
			questionAnswer23.setContext("Self-Awareness");
			
			QuestionAnswer questionAnswer24= new QuestionAnswer();
			questionAnswer24.setQuestion("Is able to adapt his/her words, voice, body language and actions to achieve his/her desired impression.");
			questionAnswer24.setContext("Self-Awareness");
			
			List<QuestionAnswer> questionAnswers = new ArrayList<QuestionAnswer>();
			questionAnswers.add(questionAnswer1);
			questionAnswers.add(questionAnswer2);
			questionAnswers.add(questionAnswer3);
			questionAnswers.add(questionAnswer4);
			questionAnswers.add(questionAnswer5);
			questionAnswers.add(questionAnswer6);
			
			questionAnswers.add(questionAnswer7);
			questionAnswers.add(questionAnswer8);
			questionAnswers.add(questionAnswer9);
			questionAnswers.add(questionAnswer10);
			questionAnswers.add(questionAnswer11);
			questionAnswers.add(questionAnswer12);
			
			questionAnswers.add(questionAnswer13);
			questionAnswers.add(questionAnswer14);
			questionAnswers.add(questionAnswer15);
			questionAnswers.add(questionAnswer16);
			questionAnswers.add(questionAnswer17);
			questionAnswers.add(questionAnswer18);
			
			questionAnswers.add(questionAnswer19);
			questionAnswers.add(questionAnswer20);
			questionAnswers.add(questionAnswer21);
			questionAnswers.add(questionAnswer22);
			questionAnswers.add(questionAnswer23);
			questionAnswers.add(questionAnswer24);
			surveySession1.setQuestionAnswers(questionAnswers);
			surveySession1 = (SurveySession) surveySessionService.saveOrUpdate(surveySession1);
		} catch (SurveyGenericException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
