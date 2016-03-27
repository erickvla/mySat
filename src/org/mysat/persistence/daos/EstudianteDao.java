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
import org.mysat.persistence.entities.Estudiante;

/**
 * @author imac
 *
 */
public class EstudianteDao extends AbstractDao<Estudiante, Long> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4127770595113029878L;
	
	public EstudianteDao() {
		managedClass = Estudiante.class;
	}

	public List<Estudiante> findAll() {
		List<Estudiante> itemsList = (List<Estudiante>)getListFromNamedQuery(Constants.NAMED_QUERY_ESTUDIANTE_FIND_ALL);
		
		return itemsList;
	}
	
	public List<Estudiante> findByCurpLike(String curp) {
		Map<String, String> params = null;
		List<Estudiante> itemsList = null;
		
		if (curp != null) {
			params = new HashMap<String, String>();
			
			params.put("curp", getParamLike(curp));
			
			itemsList = (List<Estudiante>)getListFromNamedQueryParams(Constants.NAMED_QUERY_ESTUDIANTE_FIND_BY_CURP_LIKE, params);
		}	
		
		return itemsList;
	}
	
	public List<Estudiante> findByNombreLike(String nombre) {
		Map<String, String> params = null;
		List<Estudiante> itemsList = null;
		
		if (nombre != null) {
			params = new HashMap<String, String>();
			
			params.put("nombre", getParamLike(nombre));
			
			itemsList = (List<Estudiante>)getListFromNamedQueryParams(Constants.NAMED_QUERY_ESTUDIANTE_FIND_BY_NOMBRE_LIKE, params);
		}	
		
		return itemsList;
	}
	
	public List<Estudiante> findByApellidoLike(String apellido) {
		Map<String, String> params = null;
		List<Estudiante> itemsList = null;
		
		if (apellido != null) {
			params = new HashMap<String, String>();
			
			params.put("apellido", getParamLike(apellido));
			
			itemsList = (List<Estudiante>)getListFromNamedQueryParams(Constants.NAMED_QUERY_ESTUDIANTE_FIND_BY_APELLIDO_LIKE, params);
		}	
		
		return itemsList;
	}
	
	public Estudiante findById(Long id) {
		Estudiante item = null;
		
		if (id > 0) {
			item = super.findById(id);
		}
		
		return item;
	}
	
	public Estudiante findByCurp(String curp) {
		Map<String, String> params = null;
		Estudiante item = null;
		
		if (curp != null) {
			params = new HashMap<String, String>();
			
			params.put("curp", curp);
			
			item = (Estudiante)getItemFromNamedQueryParams(Constants.NAMED_QUERY_ESTUDIANTE_FIND_BY_CURP, params);
		}	
		
		return item;
	}
	
	public Estudiante findByNombre(String nombre) {
		Map<String, String> params = null;
		Estudiante item = null;
		
		if (nombre != null) {
			params = new HashMap<String, String>();
			
			params.put("nombre", nombre);
			
			item = (Estudiante)getItemFromNamedQueryParams(Constants.NAMED_QUERY_ESTUDIANTE_FIND_BY_NOMBRE, params);
		}	
		
		return item;
	}
	
	public Estudiante findByApellido(String apellido) {
		Map<String, String> params = null;
		Estudiante item = null;
		
		if (apellido != null) {
			params = new HashMap<String, String>();
			
			params.put("apellido", apellido);
			
			item = (Estudiante)getItemFromNamedQueryParams(Constants.NAMED_QUERY_ESTUDIANTE_FIND_BY_APELLIDO, params);
		}	
		
		return item;
	}
	
	public void insert(Estudiante item) throws RollbackException, IllegalArgumentException {
		super.insert(item);
	}

}
