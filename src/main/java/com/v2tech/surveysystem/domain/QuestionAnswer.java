package com.v2tech.surveysystem.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class QuestionAnswer {
	Long id;
	
	@Column(nullable=false, length=500)
	private String question;
	
	private String answer;
	
	private String context;
	
	//private boolean isAnswered = false;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

//	public boolean isAnswered() {
//		return isAnswered;
//	}
//
//	public void setAnswered(boolean isAnswered) {
//		this.isAnswered = isAnswered;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	
}
