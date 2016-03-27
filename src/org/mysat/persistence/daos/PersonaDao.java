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
import org.mysat.persistence.entities.Persona;

/**
 * @author imac
 *
 */
public class PersonaDao extends AbstractDao<Persona, Long> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3542134649305920795L;
	
	public PersonaDao() {
		managedClass = Persona.class;
	}

	public List<Persona> findAll() {
		List<Persona> itemsList = (List<Persona>)getListFromNamedQuery(Constants.NAMED_QUERY_PERSONA_FIND_ALL);
		
		return itemsList;
	}
	
	public List<Persona> findByNombreLike(String nombre) {
		Map<String, String> params = null;
		List<Persona> itemsList = null;
		
		if (nombre != null) {
			params = new HashMap<String, String>();
			
			params.put("nombre", getParamLike(nombre));
			
			itemsList = (List<Persona>)getListFromNamedQueryParams(Constants.NAMED_QUERY_PERSONA_FIND_BY_NOMBRE_LIKE, params);
		}	
		
		return itemsList;
	}
	
	public List<Persona> findByApellidoLike(String apellido) {
		Map<String, String> params = null;
		List<Persona> itemsList = null;
		
		if (apellido != null) {
			params = new HashMap<String, String>();
			
			params.put("apellido", getParamLike(apellido));
			
			itemsList = (List<Persona>)getListFromNamedQueryParams(Constants.NAMED_QUERY_PERSONA_FIND_BY_APELLIDO_LIKE, params);
		}	
		
		return itemsList;
	}
	
	public Persona findById(long id) {
		Persona item = null;
		
		if (id > 0) {
			item = super.findById(id);
		}
		
		return item;
	}
	
	public Persona findByNombre(String nombre) {
		Map<String, String> params = null;
		Persona item = null;
		
		if (nombre != null) {
			params = new HashMap<String, String>();
			
			params.put("nombre", nombre);
			
			item = (Persona)getItemFromNamedQueryParams(Constants.NAMED_QUERY_PERSONA_FIND_BY_NOMBRE, params);
		}	
		
		return item;
	}
	
	public Persona findByApellido(String apellido) {
		Map<String, String> params = null;
		Persona item = null;
		
		if (apellido != null) {
			params = new HashMap<String, String>();
			
			params.put("apellido", apellido);
			
			item = (Persona)getItemFromNamedQueryParams(Constants.NAMED_QUERY_PERSONA_FIND_BY_APELLIDO, params);
		}	
		
		return item;
	}
	
	public void insert(Persona item) throws RollbackException, IllegalArgumentException {
		super.insert(item);
	}
	
	public void update(Persona item) throws RollbackException, IllegalArgumentException {
		super.update(item);
	}
	
	public void delete(Persona item) {
		super.delete(item.getId());
	}

}
