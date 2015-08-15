package com.v2tech.surveysystem.dao.impl;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.v2tech.surveysystem.dao.SurveySessionDao;
import com.v2tech.surveysystem.domain.SurveySession;
@Repository("surveyDAO")
public class SurveySessionDaoImpl extends JpaDAOImpl<Long, SurveySession> implements SurveySessionDao{
	@Autowired
    EntityManagerFactory entityManagerFactory;
	
	@PersistenceContext(unitName="Survey_PersistenceUnit")
	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager em) {
		this.entityManager = em;
		super.setEntityManager(entityManager);
		}
    
    @PostConstruct
    public void init() {
        super.setEntityManagerFactory(entityManagerFactory);
        super.setEntityManager(entityManager);
    }

    

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	
	
	
}
