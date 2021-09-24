CREATE TABLE student(
firstname varchar(20),
lastname varchar(10),
yearlevel integer ,
studentid integer NOT NULL PRIMARY KEY
);

CREATE TABLE curso(
codigo_curso integer  NOT NULL PRIMARY KEY,
nombre_curso varchar(10),
creditos integer,
semestre integer,
numero_estudiantes integer
);

CREATE TABLE curso_student(
studentid integer,
codigo_curso integer,
PRIMARY KEY(studentid,codigo_curso),
curso varchar(10)
);


ALTER TABLE curso_student ADD CONSTRAINT studentid_FK
Foreign Key (studentid) REFERENCES student (studentid);

ALTER TABLE curso_student ADD CONSTRAINT curso_FK
Foreign Key (codigo_curso) REFERENCES curso (codigo_curso);