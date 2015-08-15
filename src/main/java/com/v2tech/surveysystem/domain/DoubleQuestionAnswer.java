package com.v2tech.surveysystem.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.OneToOne;
@Embeddable
public class DoubleQuestionAnswer {
	
	Long id;
	
	@AttributeOverrides({
        @AttributeOverride(name="question", column= @Column(name="questionAnswer1_question")),
        @AttributeOverride(name="answer", column= @Column(name="questionAnswer1_answer")),
        @AttributeOverride(name="id", column= @Column(name="questionAnswer1_id"))
        
      })
	@Embedded
	QuestionAnswer questionAnswer1;
	
	@AttributeOverrides({
        @AttributeOverride(name="question", column= @Column(name="questionAnswer2_question")),
        @AttributeOverride(name="answer", column= @Column(name="questionAnswer2_answer")),
        @AttributeOverride(name="id", column= @Column(name="questionAnswer2_id"))
        
      })
	@Embedded
	QuestionAnswer questionAnswer2;

	public QuestionAnswer getQuestionAnswer1() {
		return questionAnswer1;
	}

	public void setQuestionAnswer1(QuestionAnswer questionAnswer1) {
		this.questionAnswer1 = questionAnswer1;
	}

	public QuestionAnswer getQuestionAnswer2() {
		return questionAnswer2;
	}

	public void setQuestionAnswer2(QuestionAnswer questionAnswer2) {
		this.questionAnswer2 = questionAnswer2;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
