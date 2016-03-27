/**
 * 
 */
package org.mysat;

import java.util.List;

import org.apache.derby.shared.common.error.DerbySQLIntegrityConstraintViolationException;
import org.mysat.persistence.daos.EstudianteDao;
import org.mysat.persistence.daos.PersonaDao;
import org.mysat.persistence.daos.PersonaFisicaDao;
import org.mysat.persistence.entities.Estudiante;
import org.mysat.persistence.entities.Persona;
import org.mysat.persistence.entities.PersonaFisica;

/**
 * @author imac
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// ----------------------------------------
			// Insertar persona fisica
			// ----------------------------------------
			// insertPersonaFisica();

			// ----------------------------------------
			// Insertar especialidad medica
			// ----------------------------------------
			// insertEspecialidadMedica();

			// ----------------------------------------
			// Insertar nivel escolar
			// ----------------------------------------
			// insertNivelEscolar();
			
			// ----------------------------------------
			// Insertar nivel escolar
			// ----------------------------------------
			// insertEstudiante();

			// ----------------------------------------
			// test
			// ----------------------------------------
			test();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	private static void insertPersonaFisica() throws DerbySQLIntegrityConstraintViolationException, IllegalArgumentException {
		PersonaFisicaDao pfController = new PersonaFisicaDao();
		PersonaDao pController = new PersonaDao();
		PersonaFisica pfItem = new PersonaFisica();
		Persona pItem = new Persona();

		pItem.setNombre("Beatriz");
		pItem.setApellido("López Juárez");

		pController.insert(pItem);

		pfItem.setRfc("LOJB6803081E9");
		pfItem.setPersona(pItem);

		pfController.insert(pfItem);

		System.out.println("PERSONA FISICA: " + pfItem.toString());
	}

	private static void insertEstudiante() {
		EstudianteDao eController = new EstudianteDao();
		List<Estudiante> itemsList = null;
		Estudiante itemFindById = null;
		Estudiante itemFindByNombre = null;
		Estudiante itemFindByCurp = null;
		
		/*PersonaDao pController = new PersonaDao();
		NivelEscolarDao neController = new NivelEscolarDao();

		// Emilio
		Persona pItem1 = pController.findById(new Long(3));
		// Diego
		Persona pItem2 = pController.findById(new Long(4));
		// Santiago
		Persona pItem3 = pController.findById(new Long(5));
		// Mauricio
		Persona pItem4 = pController.findById(new Long(6));

		// Preescolar
		NivelEscolar neItem1 = neController.findById(new Long(1));
		// Primaria
		NivelEscolar neItem2 = neController.findById(new Long(2));

		Estudiante eItem1 = new Estudiante();
		Estudiante eItem2 = new Estudiante();
		Estudiante eItem3 = new Estudiante();
		Estudiante eItem4 = new Estudiante();

		// Emilio
		eItem1.setEstudianteCurp("GOHE060221HNLNRMA0");
		eItem1.setPersona(pItem1);
		eItem1.setNivelEscolar(neItem2);

		eController.insert(eItem1);

		// Diego
		eItem2.setEstudianteCurp("GOHD070412HNLNRGA9");
		eItem2.setPersona(pItem2);
		eItem2.setNivelEscolar(neItem2);

		eController.insert(eItem2);

		// Santiago
		eItem3.setEstudianteCurp("GOHS090330HNLNRNA1");
		eItem3.setPersona(pItem3);
		eItem3.setNivelEscolar(neItem2);

		eController.insert(eItem3);

		// Mauricio
		eItem4.setEstudianteCurp("GOHM120306HNLNRRA4");
		eItem4.setPersona(pItem4);
		eItem4.setNivelEscolar(neItem1);

		eController.insert(eItem4);*/

		itemsList = eController.findAll();

		for (Estudiante obj : itemsList) {
			System.out.println(obj.toString());
			System.out.println("========================");
		}
		
		itemFindById = eController.findById(new Long(1));
		
		System.out.println("findById: 1");
		System.out.println(itemFindById.toString());
		System.out.println("========================");
		
		itemFindByNombre = eController.findByNombre("Diego Marcelo");
		
		System.out.println("findByNombre: Diego Marcelo");
		System.out.println(itemFindByNombre.toString());
		System.out.println("========================");
		
		itemFindByCurp = eController.findByCurp("GOHS090330HNLNRNA1");
		
		System.out.println("findByCurp: GOHS090330HNLNRNA1");
		System.out.println(itemFindByCurp.toString());
		System.out.println("========================");
	}

	private static void test() {
		// TODO Auto-generated method stub
		PersonaDao pController = new PersonaDao();
		List<Persona> findAllList = null;
		Persona newPersona = new Persona();
		Persona updatedPersona = new Persona();
		
		System.out.println();
		System.out.println("findAll");
		System.out.println();

		findAllList = pController.findAll();

		for (Persona item : findAllList) {
			System.out.println(item.toString());
			System.out.println("========================");
		}
		
		newPersona = pController.findById(new Long(8));
		
		System.out.println();
		System.out.println("Deleting record: " + newPersona.toString());
		System.out.println();
		
		pController.delete(newPersona);
		
		System.out.println();
		System.out.println("findAll");
		System.out.println();

		findAllList = pController.findAll();

		for (Persona item : findAllList) {
			System.out.println(item.toString());
			System.out.println("========================");
		}
		
		/*
		
		newPersona.setPersonaNombre("Ogalis");
		
		pController.update(newPersona);
		
		System.out.println();
		System.out.println("Updated record: " + newPersona.toString());
		System.out.println();
		
		System.out.println();
		System.out.println("findAll");
		System.out.println();

		findAllList = pController.findAll();

		for (Persona item : findAllList) {
			System.out.println(item.toString());
			System.out.println("========================");
		}
		
		pController.delete(newPersona);
		
		System.out.println();
		System.out.println("Deleted record: " + newPersona.toString());
		System.out.println();*/
		
		/*List<Persona> findByNombreLike = null;
		List<Persona> findByApellidoLike = null;
		Persona pfById = null;
		Persona pfByNombre = null;
		Persona pfByApellido = null;

		try {
			pfController = new PersonaDao();
			
			System.out.println();
			System.out.println("findAll");
			System.out.println();

			findAllList = pfController.findAll();

			for (Persona item : findAllList) {
				System.out.println(item.toString());
				System.out.println("========================");
			}

			pfByNombre = pfController.findByNombre("Erick Vladimir");

			System.out.println();
			System.out.println("findByNombre: Erick Vladimir");
			System.out.println();

			System.out.println(pfByNombre.toString());
			System.out.println("========================");

			pfByApellido = pfController.findByApellido("Huerta Montalvo");

			System.out.println();
			System.out.println("pfByApellido: Huerta Montalvo");
			System.out.println();

			System.out.println(pfByApellido.toString());
			System.out.println("========================");

			findByNombreLike = pfController.findByNombreLike("io");

			System.out.println();
			System.out.println("findByNombreLike: io");
			System.out.println();

			for (Persona item : findByNombreLike) {
				System.out.println(item.toString());
				System.out.println("========================");
			}

			findByApellidoLike = pfController.findByApellidoLike("Huerta");

			System.out.println();
			System.out.println("pfByApellido: Huerta");
			System.out.println();

			for (Persona item : findByApellidoLike) {
				System.out.println(item.toString());
				System.out.println("========================");
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}*/
	}

}
