create schema public;

comment on schema public is 'standard public schema';

alter schema public owner to postgres;

create sequence hibernate_sequence;

alter sequence hibernate_sequence owner to postgres;

create type location as
(
	longitute real,
	latitude real
);

alter type location owner to postgres;

create type ride as
(
	ride_id bigint,
	car_id integer,
	identity_number varchar(20),
	datetime_from timestamp,
	datetime_to timestamp
);

alter type ride owner to postgres;

create table if not exists car
(
	car_id bigserial not null
		constraint car_pkey
			primary key,
	name varchar(50) not null,
	type varchar(20) not null,
	fuel_type varchar(3) not null,
	consumption double precision not null
);

alter table car owner to postgres;

create table if not exists course
(
	course_id serial not null
		constraint course_pk
			primary key,
	course_name varchar(50) not null,
	course_type varchar(20) not null
);

alter table course owner to postgres;

create table if not exists person
(
	identity_number varchar(20) not null
		constraint person_pk
			primary key,
	first_name varchar(50) not null,
	last_name varchar(50) not null,
	birthday timestamp not null
);

alter table person owner to postgres;

create table if not exists person_course
(
	driver_course_id bigserial not null
		constraint driver_course_pk
			primary key,
	course_id integer not null
		constraint driver_course_course_course_id_fk
			references course
				on update cascade on delete cascade,
	date_from timestamp not null,
	date_to timestamp,
	identity_number varchar(20) not null
		constraint person_course_person_identity_number_fk
			references person
				on update cascade on delete cascade
);

alter table person_course owner to postgres;

create table if not exists ride_obj of ride
(CONSTRAINT ride_obj_pk PRIMARY KEY (ride_id));

alter table ride_obj ADD CONSTRAINT ride_obj_car_car_id_fk
  FOREIGN KEY (car_id) REFERENCES car (car_id) on update cascade on delete cascade;
alter table ride_obj ADD CONSTRAINT ride_obj_person_identity_number_fk
  FOREIGN KEY (identity_number) REFERENCES person (identity_number) on update cascade on delete cascade;

alter table ride_obj owner to postgres;

create table if not exists location
(
	location_id bigserial not null
		constraint location_pk
			primary key,
	ride_id bigint not null
		constraint location_ride_obj_ride_id_fk
			references ride_obj
				on update cascade on delete cascade,
	time timestamp default CURRENT_TIMESTAMP not null,
	location location not null
);

alter table location owner to postgres;

create table if not exists payment
(
	payment_id bigserial not null
		constraint payment_pk
			primary key,
	ride_id bigint not null
		constraint payment_ride_ride_id_fk
			references ride_obj
				on update cascade on delete cascade,
	value double precision not null,
	description varchar(50) not null
);

alter table payment owner to postgres;

