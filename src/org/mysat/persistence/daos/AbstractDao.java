/**
 * 
 */
package org.mysat.persistence.daos;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import org.mysat.Constants;

/**
 * @author imac
 *
 */
public abstract class AbstractDao<E, PK> {
	EntityManagerFactory emf;
	Class<E> managedClass;
	
	@SuppressWarnings("unchecked")
	protected List<E> getListFromNamedQuery(String namedQuery) throws NoResultException {
		List<E> itemsList = null;
		EntityManager mgr = null;
		Query query = null;
		
		try {
			mgr = getEntityManager();
			query = mgr.createNamedQuery(namedQuery);
			
			itemsList = query.getResultList();
		} catch(NoResultException noResultExc) {
			System.err.println(noResultExc);
		} finally {
			if (mgr != null) {
				mgr.close();
			}
		}
		
		return itemsList;
	}
	
	@SuppressWarnings("unchecked")
	protected List<E> getListFromNamedQueryParams(String namedQuery, Map<String, ?> params) throws NoResultException {
		List<E> itemsList = null;
		EntityManager mgr = null;
		Query query = null;
		
		try {
			mgr = getEntityManager();
			query = mgr.createNamedQuery(namedQuery);
			
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
			
			itemsList = query.getResultList();
		} catch(NoResultException noResultExc) {
			System.err.println(noResultExc);
		} finally {
			if (mgr != null) {
				mgr.close();
			}
		}
		
		return itemsList;
	}
	
	protected E findById(PK id) throws NonUniqueResultException, IllegalArgumentException {
		E entity = null;
		EntityManager mgr = null;
		
		try {
			mgr = getEntityManager();
			entity = mgr.find(managedClass, id);
		} catch(NoResultException noResultExc) {
			System.err.println(noResultExc);
		} finally {
			if (mgr != null) {
				mgr.close();
			}
		}
		
		return entity;
	}
	
	@SuppressWarnings("unchecked")
	protected E getItemFromNamedQueryParams(String namedQuery, Map<String, ?> params) throws NonUniqueResultException {
		E entity = null;
		EntityManager mgr = null;
		Query query = null;
		
		try {
			mgr = getEntityManager();
			query = mgr.createNamedQuery(namedQuery);
			
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
			
			entity = (E)query.getSingleResult();
		} catch(NoResultException noResultExc) {
			System.err.println(noResultExc);
		} finally {
			if (mgr != null) {
				mgr.close();
			}
		}
		
		return entity;
	}
	
	protected void insert(E entity) throws RollbackException, IllegalArgumentException {
		EntityManager mgr = null;
		
		try {
			mgr = getEntityManager();
			
			mgr.getTransaction().begin();
			
			mgr.persist(entity);
			
			mgr.getTransaction().commit();
		} finally {
			if (mgr != null) {
				mgr.close();
			}
		}
	}
	
	protected void update(E entity) throws RollbackException, IllegalArgumentException {
		EntityManager mgr = null;
		
		try {
			mgr = getEntityManager();
			
			mgr.getTransaction().begin();
			
			mgr.merge(entity);
			
			mgr.getTransaction().commit();
		} finally {
			if (mgr != null) {
				mgr.close();
			}
		}
	}
	
	protected void delete(PK id) throws IllegalArgumentException {
		EntityManager mgr = null;
		E entity = null;
		
		try {
			mgr = getEntityManager();
			
			entity = mgr.getReference(managedClass, id);
			
			mgr.getTransaction().begin();
			
			mgr.remove(entity);
			
			mgr.getTransaction().commit();
		} finally {
			if (mgr != null) {
				mgr.close();
			}
		}
	}
	
	private EntityManager getEntityManager() {
		
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT);
		}
		
		return emf.createEntityManager();
	}
	
	protected String getParamLike(String param) {
		StringBuffer stringBuffer = new StringBuffer();
		
		if (param != null) {
			stringBuffer.append(Constants.PERCENT);
			stringBuffer.append(param);
			stringBuffer.append(Constants.PERCENT);
		}
		
		return stringBuffer.toString();
	}
}
