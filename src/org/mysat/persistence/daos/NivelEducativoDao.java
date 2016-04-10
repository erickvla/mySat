/**
 * 
 */
package org.mysat.persistence.daos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.RollbackException;

import org.mysat.Constants;
import org.mysat.persistence.entities.NivelEducativo;

/**
 * @author imac
 *
 */
public class NivelEducativoDao extends AbstractDao<NivelEducativo, Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5247944178329644972L;

	public NivelEducativoDao() {
		managedClass = NivelEducativo.class;
	}

	public List<NivelEducativo> findAll() {
		List<NivelEducativo> itemsList = (List<NivelEducativo>)getListFromNamedQuery(Constants.NAMED_QUERY_NIVEL_EDUCATVO_FIND_ALL);
		
		return itemsList;
	}

	public NivelEducativo findById(Long id) {
		NivelEducativo item = null;
		
		if (id > 0) {
			item = super.findById(id);
		}

		return item;
	}

	public void insert(NivelEducativo item) throws RollbackException, IllegalArgumentException {
		super.insert(item);
	}
	
	public void update(NivelEducativo item) throws RollbackException, IllegalArgumentException {
		super.update(item);
	}

	public void delete(NivelEducativo item) {
		super.delete(item.getId());
	}

}
