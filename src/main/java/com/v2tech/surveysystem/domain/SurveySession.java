package com.v2tech.surveysystem.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
@Entity
public class SurveySession extends Base{
	
	
	
	String user;
	
	String email;
	

	String surveyType;
	
	boolean surveyCompleted;
	
	@ElementCollection
	List<DoubleQuestionAnswer> doubleQuestionAnswers = new ArrayList<DoubleQuestionAnswer>();
	
	@ElementCollection
	List<QuestionAnswer> questionAnswers = new ArrayList<QuestionAnswer>();

	

	public String getSurveyType() {
		return surveyType;
	}

	public void setSurveyType(String surveyType) {
		this.surveyType = surveyType;
	}

	public List<QuestionAnswer> getQuestionAnswers() {
		return questionAnswers;
	}

	public void setQuestionAnswers(List<QuestionAnswer> questionAnswers) {
		this.questionAnswers = questionAnswers;
	}



	public List<DoubleQuestionAnswer> getDoubleQuestionAnswers() {
		return doubleQuestionAnswers;
	}

	public void setDoubleQuestionAnswers(
			List<DoubleQuestionAnswer> doubleQuestionAnswers) {
		this.doubleQuestionAnswers = doubleQuestionAnswers;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isSurveyCompleted() {
		return surveyCompleted;
	}

	public void setSurveyCompleted(boolean surveyCompleted) {
		this.surveyCompleted = surveyCompleted;
	}
	
	

}
