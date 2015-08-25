package com.v2tech.surveysystem.webservices;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.v2tech.surveysystem.common.SurveyGenericException;
import com.v2tech.surveysystem.domain.DoubleQuestionAnswer;
import com.v2tech.surveysystem.domain.LeadershipSurveyResult;
import com.v2tech.surveysystem.domain.QuestionAnswer;
import com.v2tech.surveysystem.domain.SurveySession;
import com.v2tech.surveysystem.service.SurveySessionService;

@Path("/surveyMgmtRestService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class SurveyManagementWebService {
	
	@Autowired
	SurveySessionService surveySessionService;
	
	@GET
	@Path("/surveySession/exist/email/{email}/surveyType/{surveyType}")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean isEmailPresent(@PathParam("email") String email, @PathParam("surveyType") String surveyType){
		if(email == null || surveyType == null){
			return false;
		}
		
		if(email.trim().length() == 0 || surveyType.trim().length() == 0){
			return false;
		}
		
		boolean emailPresent = surveySessionService.isEmailPresent(email, surveyType);
		
		return emailPresent;
	}
	
	@GET
	@Path("/surveySessionForParticipantLeadership")
	@Produces(MediaType.APPLICATION_JSON)
	public SurveySession getSurveySessionForParticipantLeadership(){
		SurveySession surveySession1 = new SurveySession();
		surveySession1.setEmail("jatinsut@yahoo.com");
		surveySession1.setUser("Jatin Sutaria");
		surveySession1.setSurveyCompleted(false);
		//surveySession1.setSurveyType("ParticipantLeadership");
		List<DoubleQuestionAnswer> questionAnswers = new ArrayList<DoubleQuestionAnswer>();
		DoubleQuestionAnswer doubleQuestionAnswer1 = new DoubleQuestionAnswer();
		QuestionAnswer questionAnswer1= new QuestionAnswer();
		questionAnswer1.setQuestion("I tend to tell people what is on my mind.");
		questionAnswer1.setContext("1");
		QuestionAnswer questionAnswer2= new QuestionAnswer();
		questionAnswer2.setQuestion("I tend to keep things to myself.");
		questionAnswer2.setContext("1");
		doubleQuestionAnswer1.setContext("1");
		doubleQuestionAnswer1.setQuestionAnswer1(questionAnswer1);
		doubleQuestionAnswer1.setQuestionAnswer2(questionAnswer2);
		
		DoubleQuestionAnswer doubleQuestionAnswer2 = new DoubleQuestionAnswer();
		QuestionAnswer questionAnswer3= new QuestionAnswer();
		questionAnswer3.setQuestion("I see myself as cool and guarded with others.");
		questionAnswer3.setContext("2");
		QuestionAnswer questionAnswer4= new QuestionAnswer();
		questionAnswer4.setQuestion("I see myself as warm and friendly with others.");
		questionAnswer4.setContext("2");
		doubleQuestionAnswer2.setContext("2");
		doubleQuestionAnswer2.setQuestionAnswer1(questionAnswer3);
		doubleQuestionAnswer2.setQuestionAnswer2(questionAnswer4);
		
		DoubleQuestionAnswer doubleQuestionAnswer3 = new DoubleQuestionAnswer();
		QuestionAnswer questionAnswer5= new QuestionAnswer();
		questionAnswer5.setQuestion("I tend to show my emotions to others.");
		questionAnswer5.setContext("3");
		QuestionAnswer questionAnswer6= new QuestionAnswer();
		questionAnswer6.setQuestion("I tend to keep my emotions “inside”.");
		questionAnswer6.setContext("3");
		doubleQuestionAnswer3.setContext("3");
		doubleQuestionAnswer3.setQuestionAnswer1(questionAnswer5);
		doubleQuestionAnswer3.setQuestionAnswer2(questionAnswer6);
		
		DoubleQuestionAnswer doubleQuestionAnswer4 = new DoubleQuestionAnswer();
		QuestionAnswer questionAnswer7= new QuestionAnswer();
		questionAnswer7.setQuestion("I see myself as fast-paced.");
		questionAnswer7.setContext("4");
		QuestionAnswer questionAnswer8= new QuestionAnswer();
		questionAnswer8.setQuestion("I see myself as slow-paced.");
		questionAnswer8.setContext("4");
		doubleQuestionAnswer4.setContext("4");
		doubleQuestionAnswer4.setQuestionAnswer1(questionAnswer7);
		doubleQuestionAnswer4.setQuestionAnswer2(questionAnswer8);
		
		DoubleQuestionAnswer doubleQuestionAnswer5 = new DoubleQuestionAnswer();
		QuestionAnswer questionAnswer9= new QuestionAnswer();
		questionAnswer9.setQuestion("I see myself as a risk-taker in most situations.");
		questionAnswer9.setContext("5");
		QuestionAnswer questionAnswer10= new QuestionAnswer();
		questionAnswer10.setQuestion("I view myself as one who avoids or minimizes risk in most situations.");
		questionAnswer10.setContext("5");
		doubleQuestionAnswer5.setContext("5");
		doubleQuestionAnswer5.setQuestionAnswer1(questionAnswer9);
		doubleQuestionAnswer5.setQuestionAnswer2(questionAnswer10);
		
		DoubleQuestionAnswer doubleQuestionAnswer6 = new DoubleQuestionAnswer();
		QuestionAnswer questionAnswer11= new QuestionAnswer();
		questionAnswer11.setQuestion("I see myself as playful and fun-loving.");
		questionAnswer11.setContext("6");
		QuestionAnswer questionAnswer12= new QuestionAnswer();
		questionAnswer12.setQuestion("I see myself as serious and thoughtful.");
		questionAnswer12.setContext("6");
		doubleQuestionAnswer6.setContext("6");
		doubleQuestionAnswer6.setQuestionAnswer1(questionAnswer11);
		doubleQuestionAnswer6.setQuestionAnswer2(questionAnswer12);
		
		DoubleQuestionAnswer doubleQuestionAnswer7 = new DoubleQuestionAnswer();
		QuestionAnswer questionAnswer13= new QuestionAnswer();
		questionAnswer13.setQuestion("I tend to wait for others to initiate interactions with me.");
		questionAnswer13.setContext("7");
		QuestionAnswer questionAnswer14= new QuestionAnswer();
		questionAnswer14.setQuestion("I tend to initiate interactions with others.");
		questionAnswer14.setContext("7");
		doubleQuestionAnswer7.setContext("7");
		doubleQuestionAnswer7.setQuestionAnswer1(questionAnswer13);
		doubleQuestionAnswer7.setQuestionAnswer2(questionAnswer14);
		
		DoubleQuestionAnswer doubleQuestionAnswer8 = new DoubleQuestionAnswer();
		QuestionAnswer questionAnswer15= new QuestionAnswer();
		questionAnswer15.setQuestion("I tend to talk in terms of opinions.");
		questionAnswer15.setContext("8");
		QuestionAnswer questionAnswer16= new QuestionAnswer();
		questionAnswer16.setQuestion("I tend to talk in terms of facts");
		questionAnswer16.setContext("8");
		doubleQuestionAnswer8.setContext("8");
		doubleQuestionAnswer8.setQuestionAnswer1(questionAnswer15);
		doubleQuestionAnswer8.setQuestionAnswer2(questionAnswer16);
		
		DoubleQuestionAnswer doubleQuestionAnswer9 = new DoubleQuestionAnswer();
		QuestionAnswer questionAnswer17= new QuestionAnswer();
		questionAnswer17.setQuestion("I tend to like to work with others.");
		questionAnswer17.setContext("9");
		QuestionAnswer questionAnswer18= new QuestionAnswer();
		questionAnswer18.setQuestion("I tend to like to work alone.");
		questionAnswer18.setContext("9");
		doubleQuestionAnswer9.setContext("9");
		doubleQuestionAnswer9.setQuestionAnswer1(questionAnswer17);
		doubleQuestionAnswer9.setQuestionAnswer2(questionAnswer18);
		
		DoubleQuestionAnswer doubleQuestionAnswer10 = new DoubleQuestionAnswer();
		QuestionAnswer questionAnswer19= new QuestionAnswer();
		questionAnswer19.setQuestion("I tend to take charge of a situation.");
		questionAnswer19.setContext("10");
		QuestionAnswer questionAnswer20= new QuestionAnswer();
		questionAnswer20.setQuestion("I tend to remain in the background.");
		questionAnswer20.setContext("10");
		doubleQuestionAnswer10.setContext("10");
		doubleQuestionAnswer10.setQuestionAnswer1(questionAnswer19);
		doubleQuestionAnswer10.setQuestionAnswer2(questionAnswer20);
		
		DoubleQuestionAnswer doubleQuestionAnswer11 = new DoubleQuestionAnswer();
		QuestionAnswer questionAnswer21= new QuestionAnswer();
		questionAnswer21.setQuestion("I see myself as outgoing and direct.");
		questionAnswer21.setContext("11");
		QuestionAnswer questionAnswer22= new QuestionAnswer();
		questionAnswer22.setQuestion("I see myself as quiet and moderate.");
		questionAnswer22.setContext("11");
		doubleQuestionAnswer11.setContext("11");
		doubleQuestionAnswer11.setQuestionAnswer1(questionAnswer21);
		doubleQuestionAnswer11.setQuestionAnswer2(questionAnswer22);
		
		DoubleQuestionAnswer doubleQuestionAnswer12 = new DoubleQuestionAnswer();
		QuestionAnswer questionAnswer23= new QuestionAnswer();
		questionAnswer23.setQuestion("I tend to focus on the outcome or results.");
		questionAnswer23.setContext("12");
		QuestionAnswer questionAnswer24= new QuestionAnswer();
		questionAnswer24.setQuestion("I tend to focus on the process or the method.");
		questionAnswer24.setContext("12");
		doubleQuestionAnswer12.setContext("12");
		doubleQuestionAnswer12.setQuestionAnswer1(questionAnswer23);
		doubleQuestionAnswer12.setQuestionAnswer2(questionAnswer24);
		
		DoubleQuestionAnswer doubleQuestionAnswer13 = new DoubleQuestionAnswer();
		QuestionAnswer questionAnswer25= new QuestionAnswer();
		questionAnswer25.setQuestion("I tend to be more interested in how people feel.");
		questionAnswer25.setContext("13");
		QuestionAnswer questionAnswer26= new QuestionAnswer();
		questionAnswer26.setQuestion("I tend to be more interested in what people think.");
		questionAnswer26.setContext("13");
		doubleQuestionAnswer13.setContext("13");
		doubleQuestionAnswer13.setQuestionAnswer1(questionAnswer25);
		doubleQuestionAnswer13.setQuestionAnswer2(questionAnswer26);
		
		DoubleQuestionAnswer doubleQuestionAnswer14 = new DoubleQuestionAnswer();
		QuestionAnswer questionAnswer27= new QuestionAnswer();
		questionAnswer27.setQuestion("I tend to be casual and informal in my dealings with others.");
		questionAnswer27.setContext("14");
		QuestionAnswer questionAnswer28= new QuestionAnswer();
		questionAnswer28.setQuestion("I tend to be business-like and formal in my dealings with others.");
		questionAnswer28.setContext("14");
		doubleQuestionAnswer14.setContext("14");
		doubleQuestionAnswer14.setQuestionAnswer1(questionAnswer27);
		doubleQuestionAnswer14.setQuestionAnswer2(questionAnswer28);
		
		DoubleQuestionAnswer doubleQuestionAnswer15 = new DoubleQuestionAnswer();
		QuestionAnswer questionAnswer29= new QuestionAnswer();
		questionAnswer29.setQuestion("I tend to avoid personal involvement with people.");
		questionAnswer29.setContext("15");
		QuestionAnswer questionAnswer30= new QuestionAnswer();
		questionAnswer30.setQuestion("I tend to deal with people in a more personal way.");
		questionAnswer30.setContext("15");
		doubleQuestionAnswer15.setContext("15");
		doubleQuestionAnswer15.setQuestionAnswer1(questionAnswer29);
		doubleQuestionAnswer15.setQuestionAnswer2(questionAnswer30);
		
		DoubleQuestionAnswer doubleQuestionAnswer16 = new DoubleQuestionAnswer();
		QuestionAnswer questionAnswer31= new QuestionAnswer();
		questionAnswer31.setQuestion("I tend to confront conflict head-on.");
		questionAnswer31.setContext("16");
		QuestionAnswer questionAnswer32= new QuestionAnswer();
		questionAnswer32.setQuestion("I tend to avoid conflict and confrontation.");
		questionAnswer32.setContext("16");
		doubleQuestionAnswer16.setContext("16");
		doubleQuestionAnswer16.setQuestionAnswer1(questionAnswer31);
		doubleQuestionAnswer16.setQuestionAnswer2(questionAnswer32);
		
		DoubleQuestionAnswer doubleQuestionAnswer17 = new DoubleQuestionAnswer();
		QuestionAnswer questionAnswer33= new QuestionAnswer();
		questionAnswer33.setQuestion("I tend to get impatient with others.");
		questionAnswer33.setContext("17");
		QuestionAnswer questionAnswer34= new QuestionAnswer();
		questionAnswer34.setQuestion("I see myself as patient with others.");
		questionAnswer34.setContext("17");
		doubleQuestionAnswer17.setContext("17");
		doubleQuestionAnswer17.setQuestionAnswer1(questionAnswer33);
		doubleQuestionAnswer17.setQuestionAnswer2(questionAnswer34);
		
		DoubleQuestionAnswer doubleQuestionAnswer18 = new DoubleQuestionAnswer();
		QuestionAnswer questionAnswer35= new QuestionAnswer();
		questionAnswer35.setQuestion("I tend to have a lot of interactions with others.");
		questionAnswer35.setContext("18");
		QuestionAnswer questionAnswer36= new QuestionAnswer();
		questionAnswer36.setQuestion("I tend to have limited interactions with others.");
		questionAnswer36.setContext("18");
		doubleQuestionAnswer18.setContext("18");
		doubleQuestionAnswer18.setQuestionAnswer1(questionAnswer35);
		doubleQuestionAnswer18.setQuestionAnswer2(questionAnswer36);
		
		DoubleQuestionAnswer doubleQuestionAnswer19 = new DoubleQuestionAnswer();
		QuestionAnswer questionAnswer37= new QuestionAnswer();
		questionAnswer37.setQuestion("I tend to be more task oriented.");
		questionAnswer37.setContext("19");
		QuestionAnswer questionAnswer38= new QuestionAnswer();
		questionAnswer38.setQuestion("I tend to be more relationship oriented.");
		questionAnswer38.setContext("19");
		doubleQuestionAnswer19.setContext("19");
		doubleQuestionAnswer19.setQuestionAnswer1(questionAnswer37);
		doubleQuestionAnswer19.setQuestionAnswer2(questionAnswer38);
		
		DoubleQuestionAnswer doubleQuestionAnswer20 = new DoubleQuestionAnswer();
		QuestionAnswer questionAnswer39= new QuestionAnswer();
		questionAnswer39.setQuestion("I tend to be standoffish and aloof with others.");
		questionAnswer39.setContext("20");
		QuestionAnswer questionAnswer40= new QuestionAnswer();
		questionAnswer40.setQuestion("I tend to be open and disclosing with others.");
		questionAnswer40.setContext("20");
		doubleQuestionAnswer20.setContext("20");
		doubleQuestionAnswer20.setQuestionAnswer1(questionAnswer39);
		doubleQuestionAnswer20.setQuestionAnswer2(questionAnswer40);
		
		DoubleQuestionAnswer doubleQuestionAnswer21 = new DoubleQuestionAnswer();
		QuestionAnswer questionAnswer41= new QuestionAnswer();
		questionAnswer41.setQuestion("I see myself as more competitive with others.");
		questionAnswer41.setContext("21");
		QuestionAnswer questionAnswer42= new QuestionAnswer();
		questionAnswer42.setQuestion("I see myself as more cooperative in dealing with others.");
		questionAnswer42.setContext("21");
		doubleQuestionAnswer21.setContext("21");
		doubleQuestionAnswer21.setQuestionAnswer1(questionAnswer41);
		doubleQuestionAnswer21.setQuestionAnswer2(questionAnswer42);
		
		DoubleQuestionAnswer doubleQuestionAnswer22 = new DoubleQuestionAnswer();
		QuestionAnswer questionAnswer43= new QuestionAnswer();
		questionAnswer43.setQuestion("I see myself as more reserved in dealing with others.");
		questionAnswer43.setContext("22");
		QuestionAnswer questionAnswer44= new QuestionAnswer();
		questionAnswer44.setQuestion("I see myself as more forceful with other people.");
		questionAnswer44.setContext("22");
		doubleQuestionAnswer22.setContext("22");
		doubleQuestionAnswer22.setQuestionAnswer1(questionAnswer43);
		doubleQuestionAnswer22.setQuestionAnswer2(questionAnswer44);
		
		DoubleQuestionAnswer doubleQuestionAnswer23 = new DoubleQuestionAnswer();
		QuestionAnswer questionAnswer45= new QuestionAnswer();
		questionAnswer45.setQuestion("I tend to be indifferent to the feelings of others.");
		questionAnswer45.setContext("23");
		QuestionAnswer questionAnswer46= new QuestionAnswer();
		questionAnswer46.setQuestion("I tend to get involved with the feelings of others.");
		questionAnswer46.setContext("23");
		doubleQuestionAnswer23.setContext("23");
		doubleQuestionAnswer23.setQuestionAnswer1(questionAnswer45);
		doubleQuestionAnswer23.setQuestionAnswer2(questionAnswer46);
		
		DoubleQuestionAnswer doubleQuestionAnswer24 = new DoubleQuestionAnswer();
		QuestionAnswer questionAnswer47= new QuestionAnswer();
		questionAnswer47.setQuestion("I tend to make quick decisions.");
		questionAnswer47.setContext("24");
		QuestionAnswer questionAnswer48= new QuestionAnswer();
		questionAnswer48.setQuestion("I tend to take longer in making decisions.");
		questionAnswer48.setContext("24");
		doubleQuestionAnswer24.setContext("24");
		doubleQuestionAnswer24.setQuestionAnswer1(questionAnswer47);
		doubleQuestionAnswer24.setQuestionAnswer2(questionAnswer48);
		
		DoubleQuestionAnswer doubleQuestionAnswer25 = new DoubleQuestionAnswer();
		QuestionAnswer questionAnswer49= new QuestionAnswer();
		questionAnswer49.setQuestion("I see myself as easy-going and tolerant.");
		questionAnswer49.setContext("25");
		QuestionAnswer questionAnswer50= new QuestionAnswer();
		questionAnswer50.setQuestion("I see myself as requiring of myself and others.");
		questionAnswer50.setContext("25");
		doubleQuestionAnswer25.setContext("25");
		doubleQuestionAnswer25.setQuestionAnswer1(questionAnswer49);
		doubleQuestionAnswer25.setQuestionAnswer2(questionAnswer50);
		
		DoubleQuestionAnswer doubleQuestionAnswer26 = new DoubleQuestionAnswer();
		QuestionAnswer questionAnswer51= new QuestionAnswer();
		questionAnswer51.setQuestion("I tend to follow the lead of others.");
		questionAnswer51.setContext("26");
		QuestionAnswer questionAnswer52= new QuestionAnswer();
		questionAnswer52.setQuestion("I tend to direct the actions of others.");
		questionAnswer52.setContext("26");
		doubleQuestionAnswer26.setContext("26");
		doubleQuestionAnswer26.setQuestionAnswer1(questionAnswer51);
		doubleQuestionAnswer26.setQuestionAnswer2(questionAnswer52);
		
		DoubleQuestionAnswer doubleQuestionAnswer27 = new DoubleQuestionAnswer();
		QuestionAnswer questionAnswer53= new QuestionAnswer();
		questionAnswer53.setQuestion("I tend to be a cautious and measured communicator.");
		questionAnswer53.setContext("27");
		QuestionAnswer questionAnswer54= new QuestionAnswer();
		questionAnswer54.setQuestion("I tend to be an impulsive and dramatic communicator.");
		questionAnswer54.setContext("27");
		doubleQuestionAnswer27.setContext("27");
		doubleQuestionAnswer27.setQuestionAnswer1(questionAnswer53);
		doubleQuestionAnswer27.setQuestionAnswer2(questionAnswer54);
		
		DoubleQuestionAnswer doubleQuestionAnswer28 = new DoubleQuestionAnswer();
		QuestionAnswer questionAnswer55= new QuestionAnswer();
		questionAnswer55.setQuestion("I tend to keep my opinions and thoughts to myself.");
		questionAnswer55.setContext("28");
		QuestionAnswer questionAnswer56= new QuestionAnswer();
		questionAnswer56.setQuestion("I tend to readily share my options and ideas.");
		questionAnswer56.setContext("28");
		doubleQuestionAnswer28.setContext("28");
		doubleQuestionAnswer28.setQuestionAnswer1(questionAnswer55);
		doubleQuestionAnswer28.setQuestionAnswer2(questionAnswer56);
		
		DoubleQuestionAnswer doubleQuestionAnswer29 = new DoubleQuestionAnswer();
		QuestionAnswer questionAnswer57= new QuestionAnswer();
		questionAnswer57.setQuestion("I tend to want to do things my way when I work with others.");
		questionAnswer57.setContext("29");
		QuestionAnswer questionAnswer58= new QuestionAnswer();
		questionAnswer58.setQuestion("I tend to be accepting when I work with other people.");
		questionAnswer58.setContext("29");
		doubleQuestionAnswer29.setContext("29");
		doubleQuestionAnswer29.setQuestionAnswer1(questionAnswer57);
		doubleQuestionAnswer29.setQuestionAnswer2(questionAnswer58);
		
		DoubleQuestionAnswer doubleQuestionAnswer30 = new DoubleQuestionAnswer();
		QuestionAnswer questionAnswer59= new QuestionAnswer();
		questionAnswer59.setQuestion("I tend to share my personal feelings with others.");
		questionAnswer59.setContext("30");
		QuestionAnswer questionAnswer60= new QuestionAnswer();
		questionAnswer60.setQuestion("I tend to keep my personal feelings to myself.");
		questionAnswer60.setContext("30");
		doubleQuestionAnswer30.setContext("30");
		doubleQuestionAnswer30.setQuestionAnswer1(questionAnswer59);
		doubleQuestionAnswer30.setQuestionAnswer2(questionAnswer60);
		
		
		questionAnswers.add(doubleQuestionAnswer1);
		questionAnswers.add(doubleQuestionAnswer2);
		questionAnswers.add(doubleQuestionAnswer3);
		questionAnswers.add(doubleQuestionAnswer4);
		
		questionAnswers.add(doubleQuestionAnswer5);
		questionAnswers.add(doubleQuestionAnswer6);
		questionAnswers.add(doubleQuestionAnswer7);
		questionAnswers.add(doubleQuestionAnswer8);
		
		questionAnswers.add(doubleQuestionAnswer9);
		questionAnswers.add(doubleQuestionAnswer10);
		questionAnswers.add(doubleQuestionAnswer11);
		questionAnswers.add(doubleQuestionAnswer12);
		
		questionAnswers.add(doubleQuestionAnswer13);
		questionAnswers.add(doubleQuestionAnswer14);
		questionAnswers.add(doubleQuestionAnswer15);
		questionAnswers.add(doubleQuestionAnswer16);
		
		questionAnswers.add(doubleQuestionAnswer17);
		questionAnswers.add(doubleQuestionAnswer18);
		questionAnswers.add(doubleQuestionAnswer19);
		questionAnswers.add(doubleQuestionAnswer20);
		
		questionAnswers.add(doubleQuestionAnswer21);
		questionAnswers.add(doubleQuestionAnswer22);
		questionAnswers.add(doubleQuestionAnswer23);
		questionAnswers.add(doubleQuestionAnswer24);
		
		questionAnswers.add(doubleQuestionAnswer25);
		questionAnswers.add(doubleQuestionAnswer26);
		questionAnswers.add(doubleQuestionAnswer27);
		questionAnswers.add(doubleQuestionAnswer28);
		
		questionAnswers.add(doubleQuestionAnswer29);
		questionAnswers.add(doubleQuestionAnswer30);
		surveySession1.setDoubleQuestionAnswers(questionAnswers);
		return surveySession1;
	}
	
	@GET
	@Path("/surveySessionForParticipantCompetency")
	@Produces(MediaType.APPLICATION_JSON)
	public SurveySession getSurveySessionForParticipantCompetency(){
		SurveySession surveySession1 = new SurveySession();
		QuestionAnswer questionAnswer1= new QuestionAnswer();
		questionAnswer1.setQuestion("I understand how my goals and KPIs fit with our broader business strategy.");
		questionAnswer1.setContext("Business Perspective");
		
		QuestionAnswer questionAnswer2= new QuestionAnswer();
		questionAnswer2.setQuestion("I know how the the various functions at Colgate contribute to achieve Colgate's strategic priorities.");
		questionAnswer2.setContext("Business Perspective");
		
		QuestionAnswer questionAnswer3= new QuestionAnswer();
		questionAnswer3.setQuestion("I understand how actions by my function can have a positive or negative impact on other functions at Colgate.");
		questionAnswer3.setContext("Business Perspective");
		
		QuestionAnswer questionAnswer4= new QuestionAnswer();
		questionAnswer4.setQuestion("I have a clear understanding of how Colgate delivers shareholder value, customer value and employee value.");
		questionAnswer4.setContext("Business Perspective");
		
		QuestionAnswer questionAnswer5= new QuestionAnswer();
		questionAnswer5.setQuestion("I understand the competitive dynamics faced by Colgate in today’s market environment.");
		questionAnswer5.setContext("Business Perspective");
		
		QuestionAnswer questionAnswer6= new QuestionAnswer();
		questionAnswer6.setQuestion("Once a problem (or opportunity) is identified I am able to clearly define the problem and goal statement.");
		questionAnswer6.setContext("Problem Solving");
		
		QuestionAnswer questionAnswer7= new QuestionAnswer();
		questionAnswer7.setQuestion("I am able to analyze the problem using multiple problem analysis tools to clearly understand the situation.");
		questionAnswer7.setContext("Problem Solving");
		
		QuestionAnswer questionAnswer8= new QuestionAnswer();
		questionAnswer8.setQuestion("I am able to generate multiple solutions to solve the problem.");
		questionAnswer8.setContext("Problem Solving");
		
		QuestionAnswer questionAnswer9= new QuestionAnswer();
		questionAnswer9.setQuestion("I am able to choose the best possible solution to resolve the problem.");
		questionAnswer9.setContext("Problem Solving");
		
		QuestionAnswer questionAnswer10= new QuestionAnswer();
		questionAnswer10.setQuestion("I am able to implement a solution and ensure the goal statement is obtained.");
		questionAnswer10.setContext("Problem Solving");
		
		QuestionAnswer questionAnswer11= new QuestionAnswer();
		questionAnswer11.setQuestion("I am able to structure my message in a clear and concise manner.");
		questionAnswer11.setContext("Communication Skills");
		
		QuestionAnswer questionAnswer12= new QuestionAnswer();
		questionAnswer12.setQuestion("I project confidence when communicating through my voice.");
		questionAnswer12.setContext("Communication Skills");
		
		QuestionAnswer questionAnswer13= new QuestionAnswer();
		questionAnswer13.setQuestion("I project confidence when communicating through my body language.");
		questionAnswer13.setContext("Communication Skills");
		
		QuestionAnswer questionAnswer14= new QuestionAnswer();
		questionAnswer14.setQuestion("I am able to adapt my message based on the person and the situation.");
		questionAnswer14.setContext("Communication Skills");
		
		QuestionAnswer questionAnswer15= new QuestionAnswer();
		questionAnswer15.setQuestion("I feel confident when influencing others to adopt my recommendation, initiative or ideas.");
		questionAnswer15.setContext("Influencing Skills");
		
		QuestionAnswer questionAnswer16= new QuestionAnswer();
		questionAnswer16.setQuestion("I am able to adapt my influencing approach based on my stakeholders and the situation.");
		questionAnswer16.setContext("Influencing Skills");
		
		QuestionAnswer questionAnswer17= new QuestionAnswer();
		questionAnswer17.setQuestion("I am able to take a strategic approach in terms of planning and communicating with my stakeholders when influencing.");
		questionAnswer17.setContext("Influencing Skills");
		
		QuestionAnswer questionAnswer18= new QuestionAnswer();
		questionAnswer18.setQuestion("I am able to effective utilize the knowledge, skills and experience of others when influencing my stakeholders.");
		questionAnswer18.setContext("Influencing Skills");
		
		QuestionAnswer questionAnswer19= new QuestionAnswer();
		questionAnswer19.setQuestion("I am able to follow-up with my stakeholders to ensure my ideas, recommendations and initiatives are implemented.");
		questionAnswer19.setContext("Influencing Skills");
		
		QuestionAnswer questionAnswer20= new QuestionAnswer();
		questionAnswer20.setQuestion("I have a clear understanding of my leadership strengths.");
		questionAnswer20.setContext("Self-Awareness");
		
		QuestionAnswer questionAnswer21= new QuestionAnswer();
		questionAnswer21.setQuestion("I have a clear understanding of my development areas.");
		questionAnswer21.setContext("Self-Awareness");
		
		QuestionAnswer questionAnswer22= new QuestionAnswer();
		questionAnswer22.setQuestion("I am aware of my leadership and communication style and the impact it has on others in the organization.");
		questionAnswer22.setContext("Self-Awareness");
		
		QuestionAnswer questionAnswer23= new QuestionAnswer();
		questionAnswer23.setQuestion("I understand how I want to be seen by others in the organization.  ");
		questionAnswer23.setContext("Self-Awareness");
		
		QuestionAnswer questionAnswer24= new QuestionAnswer();
		questionAnswer24.setQuestion("I am able to adapt my words, voice, body language and actions to achieve my desired impression.");
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
		return surveySession1;
	}
	
	@GET
	@Path("/surveySessionForManagerComepency")
	@Produces(MediaType.APPLICATION_JSON)
	public SurveySession getSurveySessionForManagerComepency(){
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
		questionAnswer13.setQuestion("Projects confidence when communicating through his/her body language.");
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
		return surveySession1;
	}
	
	@POST
	@Path("/save/SurveySession")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Long saveOrUpdateSurveySession(SurveySession surveySession){
		try {
			boolean emailPresent = isEmailPresent(surveySession.getEmail(), surveySession.getSurveyType());
			if(emailPresent){
				return -25l;
			}
			
			surveySession.setSurveyCompleted(true);
			if(surveySession.getSurveyType().equalsIgnoreCase("ParticipantLeadershipStyle")){
				surveySession = processLeadershipResults(surveySession);
				LeadershipSurveyResult result = populateLeadershipSurveySessionWithResults(surveySession);
				surveySession.setNumA(result.getNumA());
				surveySession.setNumC(result.getNumC());
				surveySession.setNumE(result.getNumE());
				surveySession.setNumT(result.getNumT());
			}
			surveySession = (SurveySession) surveySessionService.saveOrUpdate(surveySession);
			return surveySession.getId();
		} catch (SurveyGenericException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			String msg = e.getMessage();
			if(e.getMessage().equals("com.v2tech.surveysystem.common.SurveyGenericException: SurveySubmitted")){
				return -25l;
			}
			return -1l;
		}
	}
	
	private SurveySession processLeadershipResults(SurveySession surveySession){
		List<DoubleQuestionAnswer> doubleQuestionAnswers = surveySession.getDoubleQuestionAnswers();
		Iterator<DoubleQuestionAnswer> itr = doubleQuestionAnswers.iterator();
		while(itr.hasNext()){
			DoubleQuestionAnswer dqa = itr.next();
			String ans = dqa.getQuestionAnswer1().getAnswer();
			if(ans.contains("1")){
				if(ans.trim().length() > 0){
					String tempa = ""+ans.charAt(0);
					dqa.getQuestionAnswer1().setAnswer(tempa);
					dqa.getQuestionAnswer2().setAnswer("");
				}
				else{
					dqa.getQuestionAnswer2().setAnswer("");
				}
				
			}
			else{
				if(ans.trim().length() > 0){
					String tempa = ""+ans.charAt(0);
					dqa.getQuestionAnswer2().setAnswer(tempa);
					dqa.getQuestionAnswer1().setAnswer("");
				}
				
				
			}
		}
	return surveySession;
	}
//LeadershipSurveyResult
	
	@POST
	@Path("/get/ResultCountLeadership")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public LeadershipSurveyResult populateLeadershipSurveySessionWithResults(SurveySession surveySession){
		LeadershipSurveyResult result = new LeadershipSurveyResult();
		//surveySession = processLeadershipResults(surveySession);
		Iterator<DoubleQuestionAnswer> itr = surveySession.getDoubleQuestionAnswers().iterator();
			while(itr.hasNext()){
				DoubleQuestionAnswer q = itr.next();
				QuestionAnswer qa1 = q.getQuestionAnswer1();
				QuestionAnswer qa2 = q.getQuestionAnswer2();
				if(qa1.getAnswer().contains("A")){
					result.setNumA(result.getNumA() + 1);
				}
				else if(qa1.getAnswer().contains("T")){
					result.setNumT(result.getNumT() + 1);
				}
				else if(qa1.getAnswer().contains("C")){
					result.setNumC(result.getNumC() + 1);
				}
				else if(qa1.getAnswer().contains("E")){
					result.setNumE(result.getNumE() + 1);
				}
				
				if(qa2.getAnswer().contains("A")){
					result.setNumA(result.getNumA() + 1);
				}
				else if(qa2.getAnswer().contains("T")){
					result.setNumT(result.getNumT() + 1);
				}
				else if(qa2.getAnswer().contains("C")){
					result.setNumC(result.getNumC() + 1);
				}
				else if(qa2.getAnswer().contains("E")){
					result.setNumE(result.getNumE() + 1);
				}
			}
		
		return result;
	}
}
