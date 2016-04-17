/**
 * 
 */
package org.mysat.persistence.daos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.RollbackException;

import org.mysat.Constants;
import org.mysat.persistence.entities.Beneficiario;

/**
 * @author imac
 *
 */
public class BeneficiarioDao extends AbstractDao<Beneficiario, Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2354370480158804188L;

	public BeneficiarioDao() {
		managedClass = Beneficiario.class;
	}

	public List<Beneficiario> findAll() {
		List<Beneficiario> itemsList = (List<Beneficiario>)getListFromNamedQuery(Constants.NAMED_QUERY_BENEFICIARIO_FIND_ALL);
		
		return itemsList;
	}

	public Beneficiario findById(Long id) {
		Beneficiario item = null;
		
		if (id > 0) {
			item = super.findById(id);
		}

		return item;
	}

	public void insert(Beneficiario item) throws RollbackException, IllegalArgumentException {
		super.insert(item);
	}
	
	public void update(Beneficiario item) throws RollbackException, IllegalArgumentException {
		super.update(item);
	}

	public void delete(Beneficiario item) {
		super.delete(item.getId());
	}

}
