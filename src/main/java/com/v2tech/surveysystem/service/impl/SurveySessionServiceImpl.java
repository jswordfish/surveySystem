package com.v2tech.surveysystem.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.v2tech.surveysystem.common.SurveyGenericException;
import com.v2tech.surveysystem.dao.JPADAO;
import com.v2tech.surveysystem.dao.SurveySessionDao;
import com.v2tech.surveysystem.domain.LeadershipSurveyResult;
import com.v2tech.surveysystem.domain.QuestionAnswer;
import com.v2tech.surveysystem.domain.SurveySession;
import com.v2tech.surveysystem.service.SurveySessionService;
import com.v2tech.surveysystem.service.servicehelpers.email.EmailService;
import com.v2tech.surveysystem.service.servicehelpers.excel.Template;
import com.v2tech.surveysystem.util.EmailThread;
@Service("surveyService")
@Transactional(propagation= Propagation.REQUIRED, rollbackFor=SurveyGenericException.class)
public class SurveySessionServiceImpl extends SurveyGenericServiceImpl<Long, SurveySession> implements SurveySessionService{
	@Autowired
    protected SurveySessionDao surveySessionDao;
	

	@PostConstruct
    public void init() throws Exception {
	 super.setDAO((JPADAO) surveySessionDao);
    }
    
    @PreDestroy
    public void destroy() {
    }
    
    @Override
    public void setEntityManagerOnDao(EntityManager entityManager){
    	surveySessionDao.setEntityManager(entityManager);
    }
    
    public boolean isEmailPresent(String email, String surveyType)  throws SurveyGenericException  {
	    Map<String, String> params = new HashMap<>();
	    params.put("email", email);
	    params.put("surveyType", surveyType);
	    String query = "SurveySession.findSurveySessionByEmailAndSurveyType";
	    List<SurveySession> surveySessions = super.findByNamedQueryAndNamedParams(query, params);
	    if(surveySessions != null && surveySessions.size() > 0){
	    	return true;
	    }
	    
	    return false;
    }

    @javax.transaction.Transactional
    public SurveySession saveOrUpdate(SurveySession surveySession) throws SurveyGenericException
	{
		try
			{
				String surveyType = surveySession.getSurveyType();
				surveySession.getDoubleQuestionAnswers();
				surveySession.getQuestionAnswers();
				if (surveyType.trim().equalsIgnoreCase("ManagerCompetencyAssessment") || surveyType.trim().equalsIgnoreCase("ParticipantCompetencyAssessment"))
					{
						List<com.v2tech.surveysystem.domain.QuestionAnswer> answers = surveySession.getQuestionAnswers();
						Map<String, List<QuestionAnswer>> map = new HashMap<String, List<QuestionAnswer>>();
						Iterator<QuestionAnswer> iterator = answers.iterator();
						while (iterator.hasNext())
							{
								QuestionAnswer questionAnswer = iterator.next();
								String qroupname = (questionAnswer.getContext()).trim().toLowerCase();
								if (map.containsKey(qroupname))
									{
										List<QuestionAnswer> list = map.get(qroupname);
										list.add(questionAnswer);
										map.remove(qroupname);
										map.put(qroupname, list);
									}
								else
									{
										List<QuestionAnswer> list = new ArrayList<QuestionAnswer>();
										list.add(questionAnswer);
										map.put(qroupname, list);
									}
							}
						
						surveySession = super.saveOrUpdate(surveySession);
						String sessionNumber = surveySession.getId()+"";
						if (surveyType.trim().equalsIgnoreCase("ManagerCompetencyAssessment"))
							{
								Template.createExcelTemplate1(sessionNumber, map ,surveySession);
								Template.createPdfTemplate1(sessionNumber, map, surveySession);
								if (surveySession.isSurveyCompleted() == true)
									{
									//EmailService.sendEmail(surveySession);
									EmailThread email = new EmailThread(surveySession);
									Thread thread = new Thread(email);
									thread.start();
									}
							}
						else
							{
								Template.createExcelTemplate2(sessionNumber, map, surveySession);
								Template.createPdfTemplate2(sessionNumber, map, surveySession);
								if (surveySession.isSurveyCompleted() == true)
								{
									EmailThread email = new EmailThread(surveySession);
									Thread thread = new Thread(email);
									thread.start();
								}
							}
						return surveySession;
					}
				else if (surveyType.trim().equalsIgnoreCase("ParticipantLeadershipStyle"))
					{
						List<com.v2tech.surveysystem.domain.DoubleQuestionAnswer> answers = surveySession.getDoubleQuestionAnswers();
						Map<String, List<com.v2tech.surveysystem.domain.DoubleQuestionAnswer>> map = new HashMap<String, List<com.v2tech.surveysystem.domain.DoubleQuestionAnswer>>();
						Iterator<com.v2tech.surveysystem.domain.DoubleQuestionAnswer> iterator = answers.iterator();
						while (iterator.hasNext())
							{
								com.v2tech.surveysystem.domain.DoubleQuestionAnswer doubleQuestionAnswer = iterator.next();
								String qroupname = (doubleQuestionAnswer.getContext()).trim().toLowerCase();
								if (map.containsKey(qroupname))
									{
										List<com.v2tech.surveysystem.domain.DoubleQuestionAnswer> list = map.get(qroupname);
										list.add(doubleQuestionAnswer);
										map.remove(qroupname);
										map.put(qroupname, list);
									}
								else
									{
										List<com.v2tech.surveysystem.domain.DoubleQuestionAnswer> list = new ArrayList<com.v2tech.surveysystem.domain.DoubleQuestionAnswer>();
										list.add(doubleQuestionAnswer);
										map.put(qroupname, list);
									}
							}
						
						surveySession = super.saveOrUpdate(surveySession);
						String sessionNumber = surveySession.getId()+"";
						LeadershipSurveyResult result = new LeadershipSurveyResult();
						result.setNumA(surveySession.getNumA());
						result.setNumC(surveySession.getNumC());
						result.setNumE(surveySession.getNumE());
						result.setNumT(surveySession.getNumT());
						Template.createExcelTemplate3(sessionNumber, map,surveySession, result );
						Template.createPdfTemplate3(sessionNumber, map, surveySession, result);
						if (surveySession.isSurveyCompleted() == true)
						{
							EmailThread email = new EmailThread(surveySession);
							Thread thread = new Thread(email);
							thread.start();
						}
						return surveySession;
					}
				return null;
			}
		catch (Exception e)
			{
				throw new SurveyGenericException(e.toString(), e);
			}
	}

	
	
 
}
