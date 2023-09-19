CREATE SEQUENCE "public".actividad_id_acti_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".administrador_id_admin_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".empresa_id_emp_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".premio_id_pre_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".usuario_id_user_seq START WITH 1 INCREMENT BY 1;

CREATE  TABLE "public".actividad ( 
	nombre_acti          varchar(25)  NOT NULL  ,
	descripcion_acti     text  NOT NULL  ,
	tiempo_acti          time  NOT NULL  ,
	cal_quemadas_acti    numeric(7,2)  NOT NULL  ,
	puntos_ot_acti       numeric    ,
	id_acti              integer DEFAULT nextval('actividad_id_acti_seq'::regclass) NOT NULL  ,
	CONSTRAINT "PK_1c09d5a944d1ecb982b98d8b537" PRIMARY KEY ( id_acti )
 );

CREATE  TABLE "public".empresa ( 
	nombre_emp           varchar(25)  NOT NULL  ,
	direccion_emp        varchar(50)  NOT NULL  ,
	telefono_emp         numeric  NOT NULL  ,
	id_emp               integer DEFAULT nextval('empresa_id_emp_seq'::regclass) NOT NULL  ,
	CONSTRAINT "PK_873c5bc0aedc5135449b144c45c" PRIMARY KEY ( id_emp )
 );

CREATE  TABLE "public".premio ( 
	nombre_pre           varchar(25)  NOT NULL  ,
	descripcion_pre      text  NOT NULL  ,
	puntos_rq_pre        numeric  NOT NULL  ,
	id_pre               integer DEFAULT nextval('premio_id_pre_seq'::regclass) NOT NULL  ,
	CONSTRAINT "PK_bad2a677dffadb159e31fc5632d" PRIMARY KEY ( id_pre )
 );

CREATE  TABLE "public".administrador ( 
	nombre_admin         varchar(25)  NOT NULL  ,
	apellido_admin       varchar(25)  NOT NULL  ,
	correo_admin         varchar(50)  NOT NULL  ,
	"idEmpIdEmp"         integer    ,
	id_admin             integer DEFAULT nextval('administrador_id_admin_seq'::regclass) NOT NULL  ,
	contrasena_admin     varchar(25) DEFAULT ''::character varying NOT NULL  ,
	CONSTRAINT "PK_1c0fc451072d07939e9c6e6d8ec" PRIMARY KEY ( id_admin ),
	CONSTRAINT "FK_acc9267983e3073cd7e97c55381" FOREIGN KEY ( "idEmpIdEmp" ) REFERENCES "public".empresa( id_emp )   
 );

CREATE  TABLE "public".usuario ( 
	nombre_user          varchar(25)  NOT NULL  ,
	apellido_user        varchar(25)  NOT NULL  ,
	correo_user          varchar(50)  NOT NULL  ,
	fecha_nacimiento_user date  NOT NULL  ,
	genero_user          varchar(20)  NOT NULL  ,
	id_user              integer DEFAULT nextval('usuario_id_user_seq'::regclass) NOT NULL  ,
	contrasena_user      varchar(25) DEFAULT ''::character varying NOT NULL  ,
	"idEmpIdEmp"         integer    ,
	"idAdminIdAdmin"     integer    ,
	CONSTRAINT "PK_ae789b127d9fbab51630bd90365" PRIMARY KEY ( id_user ),
	CONSTRAINT "FK_626bdcfc3264481968b7d560020" FOREIGN KEY ( "idAdminIdAdmin" ) REFERENCES "public".administrador( id_admin )   ,
	CONSTRAINT "FK_c623503cceb98247485b7e4a537" FOREIGN KEY ( "idEmpIdEmp" ) REFERENCES "public".empresa( id_emp )   
 );

CREATE  TABLE "public".registro ( 
	fecha_hora_reg       date  NOT NULL  ,
	tipo_act_reg         text  NOT NULL  ,
	tiempo_reg           time  NOT NULL  ,
	distancia_reg        numeric(7,2)  NOT NULL  ,
	id_reg               varchar(11)  NOT NULL  ,
	"idActiIdActi"       integer    ,
	"idUserIdUser"       integer    ,
	CONSTRAINT "PK_15605ef7b89ed196d743dc84c0d" PRIMARY KEY ( id_reg ),
	CONSTRAINT "FK_5c228b3766ec506286140339214" FOREIGN KEY ( "idActiIdActi" ) REFERENCES "public".actividad( id_acti )   ,
	CONSTRAINT "FK_df837280f1a7d4d66b10c25137b" FOREIGN KEY ( "idUserIdUser" ) REFERENCES "public".usuario( id_user )   
 );

INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Caminata', 'Actividad de caminata a ritmo moderado', '00:30:00', 2500.50, 5, 1);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Caminata Rápida', 'Actividad de caminata a ritmo rápido', '00:25:00', 2100.75, 7, 2);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Trote', 'Actividad de trote a ritmo constante', '00:20:00', 1670, 10, 3);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Correr', 'Actividad de carrera continua', '00:18:00', 1500.25, 15, 4);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Caminata', 'Actividad de caminata a ritmo moderado', '00:40:00', 3350.50, 5, 5);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Caminata Rápida', 'Actividad de caminata a ritmo rápido', '00:35:00', 2930.75, 7, 6);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Trote', 'Actividad de trote a ritmo constante', '00:30:00', 2500, 10, 7);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Correr', 'Actividad de carrera continua', '00:28:00', 2320.25, 15, 8);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Caminata', 'Actividad de caminata a ritmo moderado', '00:20:00', 1670.50, 5, 9);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Caminata Rápida', 'Actividad de caminata a ritmo rápido', '00:15:00', 1250.75, 7, 10);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Trote', 'Actividad de trote a ritmo constante', '00:10:00', 830, 10, 11);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Correr', 'Actividad de carrera continua', '00:08:00', 670.25, 15, 12);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Caminata', 'Actividad de caminata a ritmo moderado', '00:35:00', 2930.50, 5, 13);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Caminata Rápida', 'Actividad de caminata a ritmo rápido', '00:30:00', 2500.75, 7, 14);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Trote', 'Actividad de trote a ritmo constante', '00:25:00', 2100, 10, 15);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Correr', 'Actividad de carrera continua', '00:23:00', 1920.25, 15, 16);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Caminata', 'Actividad de caminata a ritmo moderado', '00:15:00', 1250.50, 5, 17);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Caminata Rápida', 'Actividad de caminata a ritmo rápido', '00:10:00', 830.75, 7, 18);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Trote', 'Actividad de trote a ritmo constante', '00:08:00', 670, 10, 19);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Correr', 'Actividad de carrera continua', '00:05:00', 500.25, 15, 20);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Caminata', 'Actividad de caminata a ritmo moderado', '00:35:00', 2930.50, 5, 21);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Caminata Rápida', 'Actividad de caminata a ritmo rápido', '00:30:00', 2500.75, 7, 22);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Trote', 'Actividad de trote a ritmo constante', '00:25:00', 2100, 10, 23);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Correr', 'Actividad de carrera continua', '00:23:00', 1920.25, 15, 24);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Caminata', 'Actividad de caminata a ritmo moderado', '00:15:00', 1250.50, 5, 25);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Caminata Rápida', 'Actividad de caminata a ritmo rápido', '00:10:00', 830.75, 7, 26);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Trote', 'Actividad de trote a ritmo constante', '00:08:00', 670, 10, 27);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Correr', 'Actividad de carrera continua', '00:05:00', 500.25, 15, 28);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Caminata', 'Actividad de caminata a ritmo moderado', '00:30:00', 2500.50, 5, 29);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Caminata Rápida', 'Actividad de caminata a ritmo rápido', '00:25:00', 2100.75, 7, 30);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Trote', 'Actividad de trote a ritmo constante', '00:20:00', 1670, 10, 31);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Correr', 'Actividad de carrera continua', '00:18:00', 1500.25, 15, 32);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Caminata', 'Actividad de caminata a ritmo moderado', '00:40:00', 3350.50, 5, 33);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Caminata Rápida', 'Actividad de caminata a ritmo rápido', '00:35:00', 2930.75, 7, 34);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Trote', 'Actividad de trote a ritmo constante', '00:30:00', 2500, 10, 35);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Correr', 'Actividad de carrera continua', '00:28:00', 2320.25, 15, 36);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Caminata', 'Actividad de caminata a ritmo moderado', '00:20:00', 1670.50, 5, 37);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Caminata Rápida', 'Actividad de caminata a ritmo rápido', '00:15:00', 1250.75, 7, 38);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Trote', 'Actividad de trote a ritmo constante', '00:10:00', 830, 10, 39);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Correr', 'Actividad de carrera continua', '00:08:00', 670.25, 15, 40);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Caminata', 'Actividad de caminata a ritmo moderado', '00:35:00', 2930.50, 5, 41);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Caminata Rápida', 'Actividad de caminata a ritmo rápido', '00:30:00', 2500.75, 7, 42);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Trote', 'Actividad de trote a ritmo constante', '00:25:00', 2100, 10, 43);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Correr', 'Actividad de carrera continua', '00:23:00', 1920.25, 15, 44);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Caminata', 'Actividad de caminata a ritmo moderado', '00:15:00', 1250.50, 5, 45);
INSERT INTO "public".actividad( nombre_acti, descripcion_acti, tiempo_acti, cal_quemadas_acti, puntos_ot_acti, id_acti ) VALUES ( 'Caminata Rápida', 'Actividad de caminata a ritmo rápido', '00:10:00', 830.75, 7, 46);
INSERT INTO "public".empresa( nombre_emp, direccion_emp, telefono_emp, id_emp ) VALUES ( 'CodexESPE', 'Quito, San Carlos Bajo', 23525303, 1);
INSERT INTO "public".premio( nombre_pre, descripcion_pre, puntos_rq_pre, id_pre ) VALUES ( 'Descuento UberEats', 'Descuento de 5 dolares para UberEats', 200, 1);
INSERT INTO "public".premio( nombre_pre, descripcion_pre, puntos_rq_pre, id_pre ) VALUES ( 'Café late', 'Cupón de 7.50$ dólares para Juan Valdez', 200, 8);
INSERT INTO "public".premio( nombre_pre, descripcion_pre, puntos_rq_pre, id_pre ) VALUES ( 'Seco', 'Seco del gordo de 2.50$', 300, 10);
INSERT INTO "public".administrador( nombre_admin, apellido_admin, correo_admin, "idEmpIdEmp", id_admin, contrasena_admin ) VALUES ( 'Leonardo', 'Sandoval', 'lssandoval@espe.edu.ec', null, 2, '');
INSERT INTO "public".administrador( nombre_admin, apellido_admin, correo_admin, "idEmpIdEmp", id_admin, contrasena_admin ) VALUES ( 'Hamilton', 'Perez', 'hdperez@espe.edu.ec', null, 3, '');
INSERT INTO "public".administrador( nombre_admin, apellido_admin, correo_admin, "idEmpIdEmp", id_admin, contrasena_admin ) VALUES ( 'Martin', 'Medina', 'mamedina13@espe.edu.ec', null, 4, '');
INSERT INTO "public".administrador( nombre_admin, apellido_admin, correo_admin, "idEmpIdEmp", id_admin, contrasena_admin ) VALUES ( 'Dalton', 'Arevalo', 'djarevalo3@espe.edu.ec', 1, 1, '');
INSERT INTO "public".usuario( nombre_user, apellido_user, correo_user, fecha_nacimiento_user, genero_user, id_user, contrasena_user, "idEmpIdEmp", "idAdminIdAdmin" ) VALUES ( 'Luis', 'Hernandez', 'luhernandez@espe.edu.ec', '1992-07-05', 'Masculino', 2, '', null, null);
INSERT INTO "public".usuario( nombre_user, apellido_user, correo_user, fecha_nacimiento_user, genero_user, id_user, contrasena_user, "idEmpIdEmp", "idAdminIdAdmin" ) VALUES ( 'Alejandro', 'Rodriguez', 'alrodriguez@espe.edu.ec', '1997-11-28', 'Masculino', 3, '', null, null);
INSERT INTO "public".usuario( nombre_user, apellido_user, correo_user, fecha_nacimiento_user, genero_user, id_user, contrasena_user, "idEmpIdEmp", "idAdminIdAdmin" ) VALUES ( 'Francisco', 'Torres', 'fratorres@espe.edu.ec', '1987-08-16', 'Masculino', 8, '', null, null);
INSERT INTO "public".usuario( nombre_user, apellido_user, correo_user, fecha_nacimiento_user, genero_user, id_user, contrasena_user, "idEmpIdEmp", "idAdminIdAdmin" ) VALUES ( 'Javier', 'Herrera', 'jaherrera@espe.edu.ec', '1998-10-21', 'Masculino', 10, '', null, null);
INSERT INTO "public".usuario( nombre_user, apellido_user, correo_user, fecha_nacimiento_user, genero_user, id_user, contrasena_user, "idEmpIdEmp", "idAdminIdAdmin" ) VALUES ( 'Antonio', 'Vargas', 'anvargas@espe.edu.ec', '1989-06-14', 'Masculino', 11, '', null, null);
INSERT INTO "public".usuario( nombre_user, apellido_user, correo_user, fecha_nacimiento_user, genero_user, id_user, contrasena_user, "idEmpIdEmp", "idAdminIdAdmin" ) VALUES ( 'Rafael', 'Jimenez', 'rajimenez@espe.edu.ec', '1991-01-27', 'Masculino', 12, '', null, null);
INSERT INTO "public".usuario( nombre_user, apellido_user, correo_user, fecha_nacimiento_user, genero_user, id_user, contrasena_user, "idEmpIdEmp", "idAdminIdAdmin" ) VALUES ( 'Eduardo', 'Morales', 'edmorales@espe.edu.ec', '1995-12-10', 'Masculino', 13, '', null, null);
INSERT INTO "public".usuario( nombre_user, apellido_user, correo_user, fecha_nacimiento_user, genero_user, id_user, contrasena_user, "idEmpIdEmp", "idAdminIdAdmin" ) VALUES ( 'Andres', 'Silva', 'ansilva@espe.edu.ec', '1997-03-04', 'Masculino', 14, '', null, null);
INSERT INTO "public".usuario( nombre_user, apellido_user, correo_user, fecha_nacimiento_user, genero_user, id_user, contrasena_user, "idEmpIdEmp", "idAdminIdAdmin" ) VALUES ( 'Maria', 'Fernandez', 'mafernandez@espe.edu.ec', '1986-09-19', 'Femenino', 15, '', null, null);
INSERT INTO "public".usuario( nombre_user, apellido_user, correo_user, fecha_nacimiento_user, genero_user, id_user, contrasena_user, "idEmpIdEmp", "idAdminIdAdmin" ) VALUES ( 'Ana', 'Gomez', 'angomez@espe.edu.ec', '1992-08-07', 'Femenino', 16, '', null, null);
INSERT INTO "public".usuario( nombre_user, apellido_user, correo_user, fecha_nacimiento_user, genero_user, id_user, contrasena_user, "idEmpIdEmp", "idAdminIdAdmin" ) VALUES ( 'Laura', 'Perez', 'laperez@espe.edu.ec', '1987-04-23', 'Femenino', 17, '', null, null);
INSERT INTO "public".usuario( nombre_user, apellido_user, correo_user, fecha_nacimiento_user, genero_user, id_user, contrasena_user, "idEmpIdEmp", "idAdminIdAdmin" ) VALUES ( 'Carmen', 'Morales', 'camorales@espe.edu.ec', '1994-11-11', 'Femenino', 18, '', null, null);
INSERT INTO "public".usuario( nombre_user, apellido_user, correo_user, fecha_nacimiento_user, genero_user, id_user, contrasena_user, "idEmpIdEmp", "idAdminIdAdmin" ) VALUES ( 'Isabel', 'Torres', 'istorres@espe.edu.ec', '1993-07-02', 'Femenino', 19, '', null, null);
INSERT INTO "public".usuario( nombre_user, apellido_user, correo_user, fecha_nacimiento_user, genero_user, id_user, contrasena_user, "idEmpIdEmp", "idAdminIdAdmin" ) VALUES ( 'Patricia', 'Ruiz', 'paruiz@espe.edu.ec', '1999-02-18', 'Femenino', 20, '', null, null);
INSERT INTO "public".usuario( nombre_user, apellido_user, correo_user, fecha_nacimiento_user, genero_user, id_user, contrasena_user, "idEmpIdEmp", "idAdminIdAdmin" ) VALUES ( 'Pedro', 'Garcia', 'pegarcia@espe.edu.ec', '1986-03-17', 'Masculino', 1, '', 1, 2);
INSERT INTO "public".usuario( nombre_user, apellido_user, correo_user, fecha_nacimiento_user, genero_user, id_user, contrasena_user, "idEmpIdEmp", "idAdminIdAdmin" ) VALUES ( 'Jose', 'Banderitas', 'josebanderitas@espe.edu.ec', '2000-06-23', 'Masculino', 21, 'Banderitas2000', 1, 1);
INSERT INTO "public".usuario( nombre_user, apellido_user, correo_user, fecha_nacimiento_user, genero_user, id_user, contrasena_user, "idEmpIdEmp", "idAdminIdAdmin" ) VALUES ( 'Marco', 'Gonzalez', 'jogonzalez@espe.edu.ec', '1994-05-22', 'Masculino', 6, 'Gonzalez1994', 1, 1);
INSERT INTO "public".usuario( nombre_user, apellido_user, correo_user, fecha_nacimiento_user, genero_user, id_user, contrasena_user, "idEmpIdEmp", "idAdminIdAdmin" ) VALUES ( 'Marco', 'Duarte', 'maduarte@espe.edu.ec', '2003-02-26', 'Masculino', 24, 'Duarte2003', 1, 1);
INSERT INTO "public".usuario( nombre_user, apellido_user, correo_user, fecha_nacimiento_user, genero_user, id_user, contrasena_user, "idEmpIdEmp", "idAdminIdAdmin" ) VALUES ( 'Juan', 'Rodriguez', 'jumartinez@espe.edu.ec', '1990-04-12', 'Masculino', 4, 'Rodriguez1990', 1, 1);
INSERT INTO "public".registro( fecha_hora_reg, tipo_act_reg, tiempo_reg, distancia_reg, id_reg, "idActiIdActi", "idUserIdUser" ) VALUES ( '2023-06-19', 'Caminata', '01:00:00', 1500.25, '2', 45, 10);