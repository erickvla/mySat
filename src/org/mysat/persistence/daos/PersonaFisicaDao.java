/**
 * 
 */
package org.mysat.persistence.daos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mysat.Constants;
import org.mysat.persistence.entities.PersonaFisica;

/**
 * @author imac
 *
 */
public class PersonaFisicaDao extends AbstractDao<PersonaFisica, Long> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1121595954697077155L;
	
	public PersonaFisicaDao() {
		managedClass = PersonaFisica.class;
	}

	public List<PersonaFisica> findAll() {
		List<PersonaFisica> itemsList = (List<PersonaFisica>)getListFromNamedQuery(Constants.NAMED_QUERY_PERSONA_FISICA_FIND_ALL);
		
		return itemsList;
	}

	public List<PersonaFisica> findByRfcLike(String rfc) {
		Map<String, String> params = null;
		List<PersonaFisica> itemsList = null;
		
		if (rfc != null) {
			params = new HashMap<String, String>();
			
			params.put("rfc", getParamLike(rfc));
			
			itemsList = (List<PersonaFisica>)getListFromNamedQueryParams(Constants.NAMED_QUERY_PERSONA_FISICA_FIND_BY_RFC_LIKE, params);
		}	
		
		return itemsList;
	}

	public List<PersonaFisica> findByNombreLike(String nombre) {
		Map<String, String> params = null;
		List<PersonaFisica> itemsList = null;
		
		if (nombre != null) {
			params = new HashMap<String, String>();
			
			params.put("nombre", getParamLike(nombre));
			
			itemsList = (List<PersonaFisica>)getListFromNamedQueryParams(Constants.NAMED_QUERY_PERSONA_FISICA_FIND_BY_NOMBRE_LIKE, params);
		}	
		
		return itemsList;
	}

	public List<PersonaFisica> findByApellidoLike(String apellido) {
		Map<String, String> params = null;
		List<PersonaFisica> itemsList = null;
		
		if (apellido != null) {
			params = new HashMap<String, String>();
			
			params.put("apellido", getParamLike(apellido));
			
			itemsList = (List<PersonaFisica>)getListFromNamedQueryParams(Constants.NAMED_QUERY_PERSONA_FISICA_FIND_BY_APELLIDO_LIKE, params);
		}	
		
		return itemsList;
	}

	public PersonaFisica findById(Long id) {
		PersonaFisica item = null;
		
		if (id > 0) {
			item = super.findById(id);
		}

		return item;
	}

	public PersonaFisica findByRfc(String rfc) {
		Map<String, String> params = null;
		PersonaFisica item = null;
		
		if (rfc != null) {
			params = new HashMap<String, String>();
			
			params.put("rfc", rfc);
			
			item = (PersonaFisica)getItemFromNamedQueryParams(Constants.NAMED_QUERY_PERSONA_FISICA_FIND_BY_RFC, params);
		}	
		
		return item;
	}

	public PersonaFisica findByNombre(String nombre) {
		Map<String, String> params = null;
		PersonaFisica item = null;
		
		if (nombre != null) {
			params = new HashMap<String, String>();
			
			params.put("nombre", nombre);
			
			item = (PersonaFisica)getItemFromNamedQueryParams(Constants.NAMED_QUERY_PERSONA_FISICA_FIND_BY_NOMBRE, params);
		}	
		
		return item;
	}

	public PersonaFisica findByApellido(String apellido) {
		Map<String, String> params = null;
		PersonaFisica item = null;
		
		if (apellido != null) {
			params = new HashMap<String, String>();
			
			params.put("apellido", apellido);
			
			item = (PersonaFisica)getItemFromNamedQueryParams(Constants.NAMED_QUERY_PERSONA_FISICA_FIND_BY_APELLIDO, params);
		}	
		
		return item;
	}

	public void insert(PersonaFisica item) {
		super.insert(item);
	}
	
	public void update(PersonaFisica item) {
		super.update(item);
	}

	public void delete(PersonaFisica item) {
		super.delete(item.getId());
	}

}
