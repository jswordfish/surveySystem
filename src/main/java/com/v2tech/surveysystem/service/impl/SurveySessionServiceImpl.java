package com.v2tech.surveysystem.service.impl;

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
import com.v2tech.surveysystem.domain.SurveySession;
import com.v2tech.surveysystem.service.SurveySessionService;
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

    
    
	
 
}
