/**
 * 
 */
package org.mysat.persistence.daos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.RollbackException;

import org.mysat.Constants;
import org.mysat.persistence.entities.PersonaMoral;

/**
 * @author imac
 *
 */
public class PersonaMoralDao extends AbstractDao<PersonaMoral, Long> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8789580497710494558L;

	public PersonaMoralDao() {
		managedClass = PersonaMoral.class;
	}

	public List<PersonaMoral> findAll() {
		List<PersonaMoral> itemsList = (List<PersonaMoral>)getListFromNamedQuery(Constants.NAMED_QUERY_PERSONA_MORAL_FIND_ALL);
		
		return itemsList;
	}

	public List<PersonaMoral> findByRfcLike(String rfc) {
		Map<String, String> params = null;
		List<PersonaMoral> itemsList = null;
		
		if (rfc != null) {
			params = new HashMap<String, String>();
			
			params.put("rfc", getParamLike(rfc));
			
			itemsList = (List<PersonaMoral>)getListFromNamedQueryParams(Constants.NAMED_QUERY_PERSONA_MORAL_FIND_BY_RFC_LIKE, params);
		}	
		
		return itemsList;
	}

	public List<PersonaMoral> findByNombreLike(String nombre) {
		Map<String, String> params = null;
		List<PersonaMoral> itemsList = null;
		
		if (nombre != null) {
			params = new HashMap<String, String>();
			
			params.put("nombre", getParamLike(nombre));
			
			itemsList = (List<PersonaMoral>)getListFromNamedQueryParams(Constants.NAMED_QUERY_PERSONA_MORAL_FIND_BY_NOMBRE_LIKE, params);
		}	
		
		return itemsList;
	}

	public PersonaMoral findById(Long id) {
		PersonaMoral item = null;
		
		if (id > 0) {
			item = super.findById(id);
		}

		return item;
	}

	public PersonaMoral findByRfc(String rfc) {
		Map<String, String> params = null;
		PersonaMoral item = null;
		
		if (rfc != null) {
			params = new HashMap<String, String>();
			
			params.put("rfc", rfc);
			
			item = (PersonaMoral)getItemFromNamedQueryParams(Constants.NAMED_QUERY_PERSONA_MORAL_FIND_BY_RFC, params);
		}	
		
		return item;
	}

	public PersonaMoral findByNombre(String nombre) {
		Map<String, String> params = null;
		PersonaMoral item = null;
		
		if (nombre != null) {
			params = new HashMap<String, String>();
			
			params.put("nombre", nombre);
			
			item = (PersonaMoral)getItemFromNamedQueryParams(Constants.NAMED_QUERY_PERSONA_MORAL_FIND_BY_NOMBRE, params);
		}	
		
		return item;
	}

	public void insert(PersonaMoral item) throws RollbackException, IllegalArgumentException {
		super.insert(item);
	}
	
	public void update(PersonaMoral item) throws RollbackException, IllegalArgumentException {
		super.update(item);
	}

	public void delete(PersonaMoral item) {
		super.delete(item.getId());
	}

}
