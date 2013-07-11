CREATE DATABASE IF NOT EXISTS tts;
USE tts ;

CREATE TABLE IF NOT EXISTS tts_products (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  title VARCHAR(500) NULL ,
  content LONGBLOB NULL ,
  time timestamp default current_timestamp ,
  status TINYINT(1) DEFAULT 0 ,
  level INT NULL DEFAULT 0 ,
  PRIMARY KEY (id)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS tts_task (
	id bigint auto_increment,
	title varchar(128) not null,
	description varchar(255),
	user_id bigint not null,
    primary key (id)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS tts_user (
	id bigint auto_increment,
	login_name varchar(64) not null unique,
	name varchar(64) not null,
	password varchar(255) not null,
	salt varchar(64) not null,
	roles varchar(255) not null,
	register_date timestamp not null default 0,
	email varchar(128),
    status varchar(32),
    team_id bigint,
	primary key (id)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS tts_role (
    id bigint auto_increment,
	name varchar(255) not null unique,
	permissions varchar(255),
    primary key (id)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS tts_user_role (
    user_id bigint not null,
    role_id bigint not null,
    primary key (user_id, role_id)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS tts_team (
   	id bigint auto_increment,
	name varchar(255) not null unique,
	master_id bigint,
    primary key (id)
) ENGINE = InnoDB;