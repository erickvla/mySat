package org.mysat;

public class Constants {
	
	public static final String PERSISTENCE_UNIT = "mysatPU";
	
	public static final String PERCENT = "%";
	
	/**************************************************************************
	 * NAMED QUERIES
	 *************************************************************************/
	
	// Persona Entity
	
	public static final String NAMED_QUERY_PERSONA_FIND_ALL = "Persona.findAll";
	public static final String NAMED_QUERY_PERSONA_FIND_BY_ID = "Persona.findById";
	public static final String NAMED_QUERY_PERSONA_FIND_BY_NOMBRE = "Persona.findByNombre";
	public static final String NAMED_QUERY_PERSONA_FIND_BY_NOMBRE_LIKE = "Persona.findByNombreLike";
	public static final String NAMED_QUERY_PERSONA_FIND_BY_APELLIDO = "Persona.findByApellido";
	public static final String NAMED_QUERY_PERSONA_FIND_BY_APELLIDO_LIKE = "Persona.findByApellidoLike";
	
	// PersonaFisica Entity
	
	public static final String NAMED_QUERY_PERSONA_FISICA_FIND_ALL = "PersonaFisica.findAll";
	public static final String NAMED_QUERY_PERSONA_FISICA_FIND_BY_ID = "PersonaFisica.findById";
	public static final String NAMED_QUERY_PERSONA_FISICA_FIND_BY_RFC = "PersonaFisica.findByRfc";
	public static final String NAMED_QUERY_PERSONA_FISICA_FIND_BY_RFC_LIKE = "PersonaFisica.findByRfcLike";
	public static final String NAMED_QUERY_PERSONA_FISICA_FIND_BY_NOMBRE = "PersonaFisica.findByNombre";
	public static final String NAMED_QUERY_PERSONA_FISICA_FIND_BY_NOMBRE_LIKE = "PersonaFisica.findByNombreLike";
	public static final String NAMED_QUERY_PERSONA_FISICA_FIND_BY_APELLIDO = "PersonaFisica.findByApellido";
	public static final String NAMED_QUERY_PERSONA_FISICA_FIND_BY_APELLIDO_LIKE = "PersonaFisica.findByApellidoLike";
	
	// Estudiante Entity
	
	public static final String NAMED_QUERY_ESTUDIANTE_FIND_ALL = "Estudiante.findAll";
	public static final String NAMED_QUERY_ESTUDIANTE_FIND_BY_ID = "Estudiante.findById";
	public static final String NAMED_QUERY_ESTUDIANTE_FIND_BY_CURP = "Estudiante.findByCurp";
	public static final String NAMED_QUERY_ESTUDIANTE_FIND_BY_CURP_LIKE = "Estudiante.findByCurpLike";
	public static final String NAMED_QUERY_ESTUDIANTE_FIND_BY_NOMBRE = "Estudiante.findByNombre";
	public static final String NAMED_QUERY_ESTUDIANTE_FIND_BY_NOMBRE_LIKE = "Estudiante.findByNombreLike";
	public static final String NAMED_QUERY_ESTUDIANTE_FIND_BY_APELLIDO = "Estudiante.findByApellido";
	public static final String NAMED_QUERY_ESTUDIANTE_FIND_BY_APELLIDO_LIKE = "Estudiante.findByApellidoLike";
	
	// NivelEscolar Entity
	
	public static final String NAMED_QUERY_NIVEL_ESCOLAR_FIND_ALL = "NivelEscolar.findAll";
	public static final String NAMED_QUERY_NIVEL_ESCOLAR_FIND_BY_ID = "NivelEscolar.findById";
	
	// EspecialidadMedica Entity
	
	public static final String NAMED_QUERY_ESPECIALIDAD_MEDICA_FIND_ALL = "EspecialidadMedica.findAll";
	public static final String NAMED_QUERY_ESPECIALIDAD_MEDICA_FIND_BY_ID = "EspecialidadMedica.findById";
}
