create sequence hibernate_sequence;

alter sequence hibernate_sequence owner to postgres;

create type coordinates as
(
	longitute real,
	latitude real
);

alter type coordinates owner to postgres;

create type ride as
(
	ride_id bigint,
	car_id integer,
	identity_number bigint,
	datetime_from timestamp,
	datetime_to timestamp
);

alter type ride owner to postgres;

create type fuel_type as enum ('95', '100', 'D', 'LPG');

alter type fuel_type owner to postgres;

create table if not exists car
(
	car_id bigserial not null
		constraint car_pkey
			primary key,
	name varchar(50) not null,
	type varchar(20) not null,
	fuel fuel_type not null,
	consumption double precision not null,
	picture bytea
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
	identity_number bigint not null
		constraint person_pk
			primary key,
	first_name varchar(50) not null,
	last_name varchar(50) not null,
	birthday timestamp not null
);

alter table person owner to postgres;

create table if not exists person_course
(
	person_course_id bigserial not null
		constraint driver_course_pk
			primary key,
	course_id integer not null
		constraint driver_course_course_course_id_fk
			references course
				on update cascade on delete cascade,
	date_from timestamp not null,
	date_to timestamp,
	identity_number bigint not null
		constraint person_course_person_identity_number_fk
			references person
				on update cascade on delete cascade
);

alter table person_course owner to postgres;

create table if not exists ride_obj of ride
(CONSTRAINT ride_obj_pk PRIMARY KEY (ride_id));

alter table ride_obj ADD CONSTRAINT ride_obj_car_car_id_fk FOREIGN KEY (car_id) REFERENCES car (car_id) on update cascade on delete cascade;
alter table ride_obj ADD CONSTRAINT ride_obj_person_identity_number_fk FOREIGN KEY (identity_number) REFERENCES person (identity_number) on update cascade on delete cascade;

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
	coordinates coordinates not null
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

create or replace function picture_import(p_path text, OUT p_result bytea) returns bytea
	language plpgsql
as $$
declare
  l_oid oid;
begin
  select lo_import(p_path) into l_oid;
  select lo_get(l_oid) INTO p_result;
  perform lo_unlink(l_oid);
end;
$$;

alter function picture_import(text, out bytea) owner to postgres;

