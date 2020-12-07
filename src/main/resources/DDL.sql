create database ria_dataset with owner postgres;
CREATE SCHEMA If NOT EXISTS public;
comment on schema public is 'standard public schema';

alter schema public owner to postgres;


CREATE TABLE users (
  id serial,
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100),
  age int CHECK(age > 0),
  nickname VARCHAR(20) NOT NULL,
  email VARCHAR(100) NOT NULL,
  password VARCHAR(60) NOT NULL,
  register_time bigint,
  user_role VARCHAR(25),
  user_status VARCHAR(25),
  PRIMARY KEY (id)
);

