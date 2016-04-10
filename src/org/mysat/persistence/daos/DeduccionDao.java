/**
 * 
 */
package org.mysat.persistence.daos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.RollbackException;

import org.mysat.Constants;
import org.mysat.persistence.entities.Deduccion;

/**
 * @author imac
 *
 */
public class DeduccionDao extends AbstractDao<Deduccion, Long> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -806657410111510315L;

	public DeduccionDao() {
		managedClass = Deduccion.class;
	}

	public List<Deduccion> findAll() {
		List<Deduccion> itemsList = (List<Deduccion>)getListFromNamedQuery(Constants.NAMED_QUERY_DEDUCCION_FIND_ALL);
		
		return itemsList;
	}

	public Deduccion findById(Long id) {
		Deduccion item = null;
		
		if (id > 0) {
			item = super.findById(id);
		}

		return item;
	}

	public void insert(Deduccion item) throws RollbackException, IllegalArgumentException {
		super.insert(item);
	}
	
	public void update(Deduccion item) throws RollbackException, IllegalArgumentException {
		super.update(item);
	}

	public void delete(Deduccion item) {
		super.delete(item.getId());
	}

}
