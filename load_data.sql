/**
 * Create Personas
 */

insert into MYSAT.PERSONA 
(PERSONA_NOMBRE, PERSONA_APELLIDO) 
values 
('Erick Vladimir', 'González Ortiz');

insert into MYSAT.PERSONA 
(PERSONA_NOMBRE, PERSONA_APELLIDO) 
values 
('Sian Andey', 'Huerta Montalvo');

insert into MYSAT.PERSONA 
(PERSONA_NOMBRE, PERSONA_APELLIDO) 
values 
('Emilio Alejandro', 'González Huerta');

insert into MYSAT.PERSONA 
(PERSONA_NOMBRE, PERSONA_APELLIDO) 
values 
('Diego Marcelo', 'González Huerta');

insert into MYSAT.PERSONA 
(PERSONA_NOMBRE, PERSONA_APELLIDO) 
values 
('Santiago David', 'González Huerta');

insert into MYSAT.PERSONA 
(PERSONA_NOMBRE, PERSONA_APELLIDO) 
values 
('Mauricio Alonso', 'González Huerta');

/**
 * Create PersonaFisicas
 */

insert into MYSAT.PERSONA_FISICA
(PERSONA_FISICA_RFC, PERSONA_ID) 
values 
('GOOE7802149V3', 1);

insert into MYSAT.PERSONA_FISICA
(PERSONA_FISICA_RFC, PERSONA_ID) 
values 
('HUMS760713A57', 2);

/**
 * Create Estudiantes
 */

insert into MYSAT.ESTUDIANTE
(ESTUDIANTE_CURP, PERSONA_ID) 
values 
('GOHE060221HNLNRMA0', 3);

insert into MYSAT.ESTUDIANTE
(ESTUDIANTE_CURP, PERSONA_ID) 
values 
('GOHD070412HNLNRGA9', 4);

insert into MYSAT.ESTUDIANTE
(ESTUDIANTE_CURP, PERSONA_ID) 
values 
('GOHS090330HNLNRNA1', 5);

insert into MYSAT.ESTUDIANTE
(ESTUDIANTE_CURP, PERSONA_ID) 
values 
('GOHM120306HNLNRRA4', 6);

/**
 * Create PersonaFisicaEstudiantes
 */

insert into MYSAT.PERSONA_FISICA_ESTUDIANTE
(PERSONA_FISICA_ID, ESTUDIANTE_ID) 
values 
(1, 1);

insert into MYSAT.PERSONA_FISICA_ESTUDIANTE
(PERSONA_FISICA_ID, ESTUDIANTE_ID) 
values 
(1, 2);

insert into MYSAT.PERSONA_FISICA_ESTUDIANTE
(PERSONA_FISICA_ID, ESTUDIANTE_ID) 
values 
(1, 3);

insert into MYSAT.PERSONA_FISICA_ESTUDIANTE
(PERSONA_FISICA_ID, ESTUDIANTE_ID) 
values 
(1, 4);
