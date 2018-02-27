use hospital;

DROP TABLE IF EXISTS HOSPITAL_FE;
CREATE TABLE HOSPITAL_FEhospital_fe(
	id_hospital INT  auto_increment primary key,
    code_hospital nvarchar(30),
    name_hospital nvarchar(300) ,
	confirm_api_link nvarchar(30) ,
	active_begin nvarchar(45) ,
	address nvarchar(45) ,
	active_end nvarchar(45)
)
;


DROP TABLE IF EXISTS GUES_USER_FE;
CREATE TABLE GUES_USER_FE(
	id_user INT auto_increment primary key,
    code_user nvarchar(30) ,
	first_name nvarchar(30) ,
	last_name nvarchar(30) ,
	email nvarchar(50) ,
	register_date timestamp ,
	phone nvarchar(30) ,
	birth_gues_user timestamp  DEFAULT  CURRENT_TIMESTAMP ,
	person_number nvarchar(30)
);


DROP TABLE IF EXISTS register_fe;
CREATE TABLE register_fe(
	id_register INT auto_increment,
    gues_user_id INT,
	hospital_id INT,
	register_day timestamp ,
	is_confirm INT(1) ,
	message_details varchar(500),
    PRIMARY KEY (id_register),
	INDEX par_gues_user (gues_user_id),
    FOREIGN KEY (gues_user_id) REFERENCES hospital.gues_user_fe(id_user) ON DELETE CASCADE,
    INDEX par_hospital (hospital_id),
    FOREIGN KEY (hospital_id) REFERENCES hospital.hospital_fe(id_hospital) ON DELETE CASCADE
);