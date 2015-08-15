package com.v2tech.surveysystem.service.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.v2tech.surveysystem.common.SurveyGenericException;
import com.v2tech.surveysystem.dao.JPADAO;
import com.v2tech.surveysystem.service.SurveyGenericService;
public class SurveyGenericServiceImpl<K,E> implements SurveyGenericService{
	private JPADAO dao;

	protected Class<E> entityClass; 



		

		@SuppressWarnings("unchecked") 
		public SurveyGenericServiceImpl() { 
		    ParameterizedType genericSuperclass = (ParameterizedType) getClass() 
		            .getGenericSuperclass(); 
		    this.entityClass = (Class<E>) genericSuperclass 
		            .getActualTypeArguments()[1]; 
		} 
		
		public void setEntityManagerOnDao(EntityManager entityManager){
	    	dao.setEntityManager(entityManager);
	    	
	    }
		
		protected void setDAO(JPADAO<K, E> dAO){
			this.dao = dAO;
		}

		@Transactional(value=TxType.NOT_SUPPORTED)
		public E find(long id) throws SurveyGenericException {
			try{
			return (E) dao.findById(id);
			}
			catch(Exception e){
				throw new SurveyGenericException( entityClass.getName()+" - not found ", e);
			}
		}

		@Transactional(value=TxType.NOT_SUPPORTED)
		public List<E> findAll() throws SurveyGenericException {
			try{
				return dao.findAll();
			}
			catch(Exception e){
				throw new SurveyGenericException( entityClass.getName()+" - ", e);
			}
			
		}
		@Transactional(value=TxType.NOT_SUPPORTED)
        public List<E> find(int startFrom,int maxResults) throws SurveyGenericException {
          try{
			return dao.find(startFrom, maxResults);
	            }
	            catch(Exception e){
			throw new SurveyGenericException( entityClass.getName()+" - ", e);
          }
		}

		public void save(Object entity) throws SurveyGenericException {
			try{
			dao.persist(entity);
			}
			catch(Exception e){
				throw new SurveyGenericException( entityClass.getName()+" - ", e);
			}
			
		}

		public E update(Object entity) throws SurveyGenericException {
			try{
	                        dao.merge(entity);
	                        return (E) dao.flush(entity);
			}
			catch(Exception e){
				throw new SurveyGenericException( entityClass.getName()+" - ", e);
			}
		}

		public E saveOrUpdate(Object entity) throws SurveyGenericException {
			try{
				entity = dao.merge(entity);
	            return (E) dao.flush(entity);
			}
			catch(Exception e){
				e.printStackTrace();
				throw new SurveyGenericException( entityClass.getName()+" - ", e);
			}
			
		}
		
		

		public void delete(long id) throws SurveyGenericException {
			E e = null;	
			try{
				e = find(id);
				if(e == null){
					throw new SurveyGenericException( entityClass.getName()+" - ");
				}
			}
			catch(Exception e1){
				throw new SurveyGenericException( entityClass.getName()+" - ", e1);
			}
			
			
			try{
				if(e != null){
					dao.remove(e);
	                                dao.flush(e);
				}
			}
			catch(Exception e1){
				throw new SurveyGenericException( entityClass.getName()+" - ", e1);
			}
			
			
		}

		public void deleteIfExisting(long id) throws Exception {
			try{
				E e = find(id);
					if(e != null){
						dao.remove(e);
	                                        dao.flush(e);
					}
			}
			catch(Exception e){
				throw new SurveyGenericException( entityClass.getName()+" - ", e);
			}
			
		}

		@Transactional(value=TxType.NOT_SUPPORTED)
		public List findByNamedQueryAndNamedParams(String queryName, Map params) {
			// TODO Auto-generated method stub
			return dao.findByNamedQueryAndNamedParams(queryName, params);
		}

		@Transactional(value=TxType.NOT_SUPPORTED)
		public List findByNamedQueryAndNamedParams(String queryName, Map params,
				int startFrom, int maxResults) {
			return dao.findByNamedQueryAndNamedParams(queryName, params, startFrom, maxResults);
		}

		@Transactional(value=TxType.NOT_SUPPORTED)
		public int recordCount(String name, Map params) {
			return dao.recordCount(name, params);
		}

		@Override
		public void remove(long id) throws SurveyGenericException {
			// TODO Auto-generated method stub
			dao.remove(id);
		}


		
	}

